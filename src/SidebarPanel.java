import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SidebarPanel extends JPanel {

    private final String[] menus = {
            "Dashboard",
            "Chat",
            "Study Planner",
            "GPA Calculator",
            "Career Advisor",
            "Interview Practice",
            "Analytics",
            "Notes",
            "Japan Mode",
            "Voice Assistant",
            "Chat History",
            "Settings"
    };

    public SidebarPanel() {

        setPreferredSize(new Dimension(Theme.SIDEBAR_WIDTH, 0));
        setBackground(Colors.SIDEBAR);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(20, 15, 20, 15));

        JLabel logo = new JLabel("CampusAI Pro");
        logo.setFont(Theme.TITLE_FONT);
        logo.setForeground(Colors.TEXT_PRIMARY);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(logo);
        add(Box.createVerticalStrut(35));

        for (String menu : menus) {
            add(createButton(menu));
            add(Box.createVerticalStrut(10));
        }

        add(Box.createVerticalGlue());

        JLabel version = new JLabel("Version 1.0");
        version.setForeground(Colors.TEXT_SECONDARY);
        version.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(version);
    }

    private JButton createButton(String text) {

        RoundedButton button = new RoundedButton(text);

        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(190, 42));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.addActionListener(e -> {

            System.out.println("Clicked: " + text);

            if (text.equals("Chat History")) {
                NavigationController.showScreen("Chat");
            } else {
                NavigationController.showScreen(text);
            }

});
        
        

        return button;
    }
}