import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;

public class NavigationController {

    private static final CardLayout CARD_LAYOUT = new CardLayout();
    private static final JPanel MAIN_PANEL = new JPanel(CARD_LAYOUT);

    private NavigationController() {}

    public static JPanel getMainPanel() {
        return MAIN_PANEL;
    }

    public static void addScreen(String name, JPanel panel) {
        panel.setName(name);
        MAIN_PANEL.add(panel, name);
    }

    public static void showScreen(String name) {

        // Refresh dashboard whenever it is opened
        if (name.equals("Dashboard")) {

            for (Component c : MAIN_PANEL.getComponents()) {

                if (c instanceof DashboardPanel) {

                    ((DashboardPanel) c).refreshDashboard();
                    break;
                }
            }
        }

        CARD_LAYOUT.show(MAIN_PANEL, name);

        MAIN_PANEL.revalidate();
        MAIN_PANEL.repaint();
    }
}