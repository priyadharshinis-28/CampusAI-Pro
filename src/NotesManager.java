import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class NotesManager extends JPanel {

    private JTextField titleField;
    private JTextField searchField;
    private JComboBox<String> categoryBox;
    private JTextArea contentArea;

    private DefaultListModel<String> listModel;
    private JList<String> noteList;

    private final String FOLDER = "data/notes";

    public NotesManager() {

        setLayout(new BorderLayout(10,10));
        setBackground(Colors.BACKGROUND);

        File folder = new File(FOLDER);
        if(!folder.exists())
            folder.mkdirs();

        JLabel title = new JLabel("📝 Notes Manager");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Colors.TEXT_PRIMARY);
        title.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        add(title, BorderLayout.NORTH);

        // LEFT PANEL

        JPanel left = new JPanel(new BorderLayout(5,5));
        left.setPreferredSize(new Dimension(220,500));

        searchField = new JTextField();

        JButton searchButton = new JButton("Search");

        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(searchField,BorderLayout.CENTER);
        searchPanel.add(searchButton,BorderLayout.EAST);

        listModel = new DefaultListModel<>();
        noteList = new JList<>(listModel);

        left.add(searchPanel,BorderLayout.NORTH);
        left.add(new JScrollPane(noteList),BorderLayout.CENTER);

        add(left,BorderLayout.WEST);

        // CENTER

        JPanel center = new JPanel(new BorderLayout(10,10));
        center.setBackground(Colors.BACKGROUND);

        JPanel top = new JPanel(new GridLayout(2,2,10,10));
        top.setBackground(Colors.BACKGROUND);

        titleField = new JTextField();

        categoryBox = new JComboBox<>(new String[]{
                "College",
                "Projects",
                "Japan",
                "Interview",
                "Personal"
        });

        top.add(new JLabel("Title"));
        top.add(titleField);

        top.add(new JLabel("Category"));
        top.add(categoryBox);

        center.add(top,BorderLayout.NORTH);

        contentArea = new JTextArea();
        contentArea.setFont(Theme.BODY_FONT);
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);

        center.add(new JScrollPane(contentArea),BorderLayout.CENTER);

        JPanel buttons = new JPanel();

        JButton newButton = new JButton("New");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");
        JButton deleteButton = new JButton("Delete");

        buttons.add(newButton);
        buttons.add(saveButton);
        buttons.add(loadButton);
        buttons.add(deleteButton);

        center.add(buttons,BorderLayout.SOUTH);

        add(center,BorderLayout.CENTER);

        loadNoteList();

        newButton.addActionListener(e->{

            titleField.setText("");
            contentArea.setText("");
            categoryBox.setSelectedIndex(0);

        });

        saveButton.addActionListener(e->saveNote());

        loadButton.addActionListener(e->loadSelectedNote());

        deleteButton.addActionListener(e->deleteSelectedNote());

        searchButton.addActionListener(e->searchNotes());

        noteList.addListSelectionListener(e->{

            if(!e.getValueIsAdjusting())
                loadSelectedNote();

        });

    }

    private void loadNoteList(){

        listModel.clear();

        File folder=new File(FOLDER);

        File[] files=folder.listFiles();

        if(files==null)
            return;

        for(File f:files){

            if(f.getName().endsWith(".txt")){

                listModel.addElement(
                        f.getName().replace(".txt","")
                );

            }

        }
        DashboardData.setNotesCount(listModel.getSize());

    }

    private void saveNote(){

        try{

            String title=titleField.getText().trim();

            if(title.isEmpty()){

                JOptionPane.showMessageDialog(this,"Enter note title");

                return;

            }

            FileWriter writer=new FileWriter(FOLDER+"/"+title+".txt");

            writer.write("Category:"+categoryBox.getSelectedItem()+"\n");
            writer.write(contentArea.getText());

            writer.close();

            JOptionPane.showMessageDialog(this,"Note Saved");

            loadNoteList();
            DashboardData.setNotesCount(listModel.getSize());

            NavigationController.showScreen("Dashboard");
            NavigationController.showScreen("Notes");

        }

        catch(Exception ex){

            ex.printStackTrace();

        }

    }

    private void loadSelectedNote(){

        try{

            String title=noteList.getSelectedValue();

            if(title==null)
                return;

            titleField.setText(title);

            BufferedReader br=new BufferedReader(
                    new FileReader(FOLDER+"/"+title+".txt"));

            String first=br.readLine();

            if(first!=null && first.startsWith("Category:")){

                categoryBox.setSelectedItem(
                        first.substring(9)
                );

            }

            contentArea.setText("");

            String line;

            while((line=br.readLine())!=null){

                contentArea.append(line+"\n");

            }

            br.close();

        }

        catch(Exception ex){

            ex.printStackTrace();

        }

    }

    private void deleteSelectedNote(){

        String title=noteList.getSelectedValue();

        if(title==null)
            return;

        File file=new File(FOLDER+"/"+title+".txt");

        file.delete();

        titleField.setText("");
        contentArea.setText("");

        loadNoteList();
        DashboardData.setNotesCount(listModel.getSize());

        NavigationController.showScreen("Dashboard");
        NavigationController.showScreen("Notes");

    }

    private void searchNotes(){

        String key=searchField.getText().toLowerCase();

        listModel.clear();

        File[] files=new File(FOLDER).listFiles();

        if(files==null)
            return;

        for(File f:files){

            String name=f.getName().replace(".txt","");

            if(name.toLowerCase().contains(key))

                listModel.addElement(name);

        }

    }

}