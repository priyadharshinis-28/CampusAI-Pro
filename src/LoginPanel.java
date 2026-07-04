import javax.swing.*;
import java.awt.*;
import java.io.*;

public class LoginPanel extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    private JButton loginButton;
    private JButton registerButton;
    private JCheckBox showPassword;
    private final String FILE_NAME = "users.txt";

    public LoginPanel() {

        setTitle("CampusAI Pro - Login");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(35, 35, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("CampusAI Pro");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;

        JLabel userLabel = new JLabel("Username");
        userLabel.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(userLabel, gbc);

        usernameField = new JTextField(20);

        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        JLabel passLabel = new JLabel("Password");
        passLabel.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passLabel, gbc);

        passwordField = new JPasswordField(20);

        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        showPassword = new JCheckBox("Show Password");
        showPassword.setBackground(new Color(35,35,40));
        showPassword.setForeground(Color.WHITE);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(showPassword, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(35,35,40));

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);

        add(panel);

        // Show / Hide Password
        showPassword.addActionListener(e -> {

            if(showPassword.isSelected())
                passwordField.setEchoChar((char)0);
            else
                passwordField.setEchoChar('•');

        });

        // Buttons
        loginButton.addActionListener(e -> login());

        registerButton.addActionListener(e -> register());
    }

    private void login() {

    String username = usernameField.getText().trim();
    String password = new String(passwordField.getPassword());

    try {

        BufferedReader br =
                new BufferedReader(new FileReader(FILE_NAME));

        String line;

        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            if (data[0].equals(username)
                    && data[1].equals(password)) {

                br.close();

                JOptionPane.showMessageDialog(
                        this,
                        "Welcome " + username + "!");

                dispose();

                Main.openCampusAI();

                return;

            }

        }

        br.close();

        JOptionPane.showMessageDialog(
                this,
                "Invalid Username or Password.");

    }

    catch (Exception ex) {

        JOptionPane.showMessageDialog(
                this,
                "No registered users found.");

    }

}

    private void register() {

    String username = usernameField.getText().trim();
    String password = new String(passwordField.getPassword());

    if (username.isEmpty() || password.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Enter username and password.");

        return;
    }

    try {

        File file = new File(FILE_NAME);

        if (!file.exists())
            file.createNewFile();

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            if (data[0].equals(username)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Username already exists.");

                br.close();
                return;
            }
        }

        br.close();

        FileWriter writer = new FileWriter(file, true);

        writer.write(username + "," + password + "\n");

        writer.close();

        JOptionPane.showMessageDialog(
                this,
                "Registration Successful!");

    } catch (Exception ex) {

        ex.printStackTrace();

    }

}
}