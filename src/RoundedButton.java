import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {

    private int radius = 15;

    public RoundedButton(String text) {
        super(text);

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);

        setForeground(Colors.TEXT_PRIMARY);
        setBackground(Colors.ACCENT);
        setFont(Theme.BUTTON_FONT);

        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isPressed()) {
            g2.setColor(getBackground().darker());
        }
        else if (getModel().isRollover()) {
            g2.setColor(getBackground().brighter());
        }
        else {
            g2.setColor(getBackground());
        }

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        super.paintComponent(g2);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No border
    }
}