import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HeaderPanel extends JPanel {

    private JLabel titleLabel;
    private JLabel statusLabel;
    private JLabel userLabel;

    public HeaderPanel() {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(0, 70));
        setBackground(Colors.HEADER);
        setBorder(new EmptyBorder(10, 20, 10, 20));

        titleLabel = new JLabel("🤖 CampusAI Pro");
        titleLabel.setFont(Theme.HEADER_FONT);
        titleLabel.setForeground(Colors.TEXT_PRIMARY);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 5));
        rightPanel.setOpaque(false);

        statusLabel = new JLabel("🟢 Online");
        statusLabel.setFont(Theme.BODY_FONT);
        statusLabel.setForeground(Colors.SUCCESS);

        userLabel = new JLabel("👤 Student");
        userLabel.setFont(Theme.BODY_FONT);
        userLabel.setForeground(Colors.TEXT_PRIMARY);

        rightPanel.add(statusLabel);
        rightPanel.add(userLabel);

        add(titleLabel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }

    public void setUserName(String name) {
        userLabel.setText("👤 " + name);
    }

    public void setTitle(String title) {
        titleLabel.setText(title);
    }
}