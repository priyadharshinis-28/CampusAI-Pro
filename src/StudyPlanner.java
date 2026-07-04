import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class StudyPlanner extends JPanel {

    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField inputField;

    private final String FILE_NAME = "data/tasks.txt";

    public StudyPlanner() {

        setLayout(new BorderLayout());
        setBackground(Colors.BACKGROUND);

        // Title
        JLabel title = new JLabel("📚 Study Planner");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Colors.TEXT_PRIMARY);
        title.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        add(title, BorderLayout.NORTH);

        // List
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setFont(Theme.BODY_FONT);
        taskList.setBackground(Colors.CARD);
        taskList.setForeground(Colors.TEXT_PRIMARY);

        JScrollPane scrollPane = new JScrollPane(taskList);

        // Input panel
        JPanel inputPanel = new JPanel(new BorderLayout(10,10));
        inputPanel.setBackground(Colors.BACKGROUND);

        inputField = new JTextField();
        inputField.setFont(Theme.BODY_FONT);

        JButton addBtn = new JButton("Add");
        JButton deleteBtn = new JButton("Delete");

        addBtn.addActionListener(e -> addTask());
        deleteBtn.addActionListener(e -> deleteTask());

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(addBtn, BorderLayout.EAST);
        inputPanel.add(deleteBtn, BorderLayout.SOUTH);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        loadTasks();
    }

    private void addTask() {

        String task = inputField.getText().trim();

        if (!task.isEmpty()) {
            listModel.addElement("🟡 " + task);
            inputField.setText("");
            saveTasks();
            DashboardData.setTotalTasks(listModel.getSize());
        }
    }

    private void deleteTask() {

        int index = taskList.getSelectedIndex();

        if (index != -1) {
            listModel.remove(index);
            saveTasks();
            DashboardData.setTotalTasks(listModel.getSize());
        }
    }

    private void saveTasks() {

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {

            for (int i = 0; i < listModel.size(); i++) {
                writer.println(listModel.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadTasks() {

        File file = new File(FILE_NAME);

        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {
                listModel.addElement(line);
            }
            DashboardData.setTotalTasks(listModel.getSize());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}