import javax.swing.*;
import java.awt.*;

public class TypingAnimation extends JPanel {

    private JLabel label;
    private javax.swing.Timer timer;

    private int dots = 0;

    public TypingAnimation() {

        setOpaque(false);

        label = new JLabel("CampusAI is typing");
        label.setForeground(Colors.TEXT_SECONDARY);
        label.setFont(Theme.BODY_FONT);

        add(label);

        timer = new javax.swing.Timer(500, e -> {

            dots++;

            if (dots > 3)
                dots = 0;

            StringBuilder text = new StringBuilder("CampusAI is typing");

            for (int i = 0; i < dots; i++) {
                text.append(".");
            }

            label.setText(text.toString());
        });
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
        label.setText("CampusAI is typing");
    }
}