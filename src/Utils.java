import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    private Utils() {
    }

    public static String getCurrentTime() {

        return new SimpleDateFormat("hh:mm a")
                .format(new Date());

    }

    public static String getCurrentDate() {

        return new SimpleDateFormat("dd-MM-yyyy")
                .format(new Date());

    }

    public static String capitalize(String text) {

        if (text == null || text.isEmpty()) {
            return "";
        }

        return text.substring(0, 1).toUpperCase()
                + text.substring(1).toLowerCase();

    }

    public static String getGreeting() {

        int hour = Integer.parseInt(
                new SimpleDateFormat("HH").format(new Date()));

        if (hour < 12)
            return "Good Morning";

        if (hour < 17)
            return "Good Afternoon";

        return "Good Evening";
    }

    public static String divider() {

        return "========================================";

    }

}