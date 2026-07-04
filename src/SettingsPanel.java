import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SettingsPanel extends JPanel {

    private JTextField usernameField;

    private JComboBox<String> themeBox;
    private JComboBox<String> fontSizeBox;

    private JCheckBox notificationBox;
    private JCheckBox autoSaveBox;

    private JButton saveButton;
    private JButton resetButton;

    private final String SETTINGS_FILE = "settings.properties";

    public SettingsPanel() {

        setLayout(new BorderLayout());
        setBackground(Colors.BACKGROUND);

        JLabel title = new JLabel("Settings");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Colors.TEXT_PRIMARY);
        title.setBorder(new EmptyBorder(20,25,20,20));

        add(title, BorderLayout.NORTH);

        JPanel form = new JPanel();
        form.setBackground(Colors.CARD);
        form.setBorder(new EmptyBorder(30,40,30,40));
        form.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(15,15,15,15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //-----------------------------------------
        // Username
        //-----------------------------------------

        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel userLabel = new JLabel("Username");
        userLabel.setForeground(Colors.TEXT_PRIMARY);
        userLabel.setFont(Theme.BODY_FONT);
        form.add(userLabel, gbc);

        gbc.gridx = 1;

        usernameField = new JTextField(20);
        usernameField.setFont(Theme.BODY_FONT);
        form.add(usernameField, gbc);

        //-----------------------------------------
        // Theme
        //-----------------------------------------

        gbc.gridx = 0;
        gbc.gridy++;

        JLabel themeLabel = new JLabel("Theme");
        themeLabel.setForeground(Colors.TEXT_PRIMARY);
        themeLabel.setFont(Theme.BODY_FONT);
        form.add(themeLabel, gbc);

        gbc.gridx = 1;

        themeBox = new JComboBox<>(
                new String[]{
                        "Dark",
                        "Light"
                });

        form.add(themeBox, gbc);

        //-----------------------------------------
        // Font Size
        //-----------------------------------------

        gbc.gridx = 0;
        gbc.gridy++;

        JLabel fontLabel = new JLabel("Font Size");
        fontLabel.setForeground(Colors.TEXT_PRIMARY);
        fontLabel.setFont(Theme.BODY_FONT);

        form.add(fontLabel, gbc);

        gbc.gridx = 1;

        fontSizeBox = new JComboBox<>(
                new String[]{
                        "Small",
                        "Medium",
                        "Large"
                });

        fontSizeBox.setSelectedIndex(1);

        form.add(fontSizeBox, gbc);

        //-----------------------------------------
        // Notifications
        //-----------------------------------------

        gbc.gridx = 0;
        gbc.gridy++;

        notificationBox = new JCheckBox("Enable Notifications");

        notificationBox.setBackground(Colors.CARD);
        notificationBox.setForeground(Colors.TEXT_PRIMARY);
        notificationBox.setFont(Theme.BODY_FONT);

        gbc.gridwidth = 2;

        form.add(notificationBox, gbc);

        //-----------------------------------------
        // Auto Save
        //-----------------------------------------

        gbc.gridy++;

        autoSaveBox = new JCheckBox("Enable Auto Save");

        autoSaveBox.setBackground(Colors.CARD);
        autoSaveBox.setForeground(Colors.TEXT_PRIMARY);
        autoSaveBox.setFont(Theme.BODY_FONT);

        form.add(autoSaveBox, gbc);

        //-----------------------------------------
        // Buttons
        //-----------------------------------------

        gbc.gridy++;

        JPanel buttonPanel = new JPanel();

        buttonPanel.setBackground(Colors.CARD);

        saveButton = new RoundedButton("Save Settings");
        resetButton = new RoundedButton("Reset");

        buttonPanel.add(saveButton);
        buttonPanel.add(resetButton);

        form.add(buttonPanel, gbc);

        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setBackground(Colors.BACKGROUND);
        wrapper.add(form);

        add(wrapper, BorderLayout.CENTER);

        //-----------------------------------------
        // Load saved settings
        //-----------------------------------------

        loadSettings();

        //-----------------------------------------
        // Events
        //-----------------------------------------

        saveButton.addActionListener(e -> saveSettings());

        resetButton.addActionListener(e -> {

            resetSettings();
            saveSettings();

});
    }
    // ---------------------------------------------------
// Save Settings
// ---------------------------------------------------
    private void saveSettings() {

        Properties properties = new Properties();

        properties.setProperty("username", usernameField.getText().trim());
        properties.setProperty("theme", themeBox.getSelectedItem().toString());
        properties.setProperty("fontSize", fontSizeBox.getSelectedItem().toString());
        properties.setProperty("notifications",
                String.valueOf(notificationBox.isSelected()));
        properties.setProperty("autosave",
                String.valueOf(autoSaveBox.isSelected()));

        try (FileOutputStream fos = new FileOutputStream(SETTINGS_FILE)) {

            properties.store(fos, "CampusAI Settings");

            JOptionPane.showMessageDialog(
                    this,
                    "Settings saved successfully!",
                    "CampusAI",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to save settings.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ---------------------------------------------------
    // Load Settings
    // ---------------------------------------------------
    private void loadSettings() {

        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(SETTINGS_FILE)) {

            properties.load(fis);

            usernameField.setText(
                    properties.getProperty("username", ""));

            themeBox.setSelectedItem(
                    properties.getProperty("theme", "Dark"));

            fontSizeBox.setSelectedItem(
                    properties.getProperty("fontSize", "Medium"));

            notificationBox.setSelected(
                    Boolean.parseBoolean(
                            properties.getProperty("notifications", "true")));

            autoSaveBox.setSelected(
                    Boolean.parseBoolean(
                            properties.getProperty("autosave", "true")));

        } catch (IOException e) {

            // First run - no settings file yet.
            resetSettings();
        }
    }

    // ---------------------------------------------------
    // Reset Settings
    // ---------------------------------------------------
    private void resetSettings() {

        usernameField.setText("");

        themeBox.setSelectedItem("Dark");

        fontSizeBox.setSelectedItem("Medium");

        notificationBox.setSelected(true);

        autoSaveBox.setSelected(true);
    }

    // Methods will be added in Part 2
}