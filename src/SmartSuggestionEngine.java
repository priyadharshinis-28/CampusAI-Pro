import java.util.ArrayList;
import java.util.List;

public class SmartSuggestionEngine {

    private SmartSuggestionEngine() {
    }

    public static List<String> getSuggestions(String text) {

        text = text.toLowerCase();

        List<String> suggestions = new ArrayList<>();

        if (text.contains("java")) {

            suggestions.add("Learn Collections Framework");
            suggestions.add("Practice Multithreading");
            suggestions.add("Build JDBC Project");

        }

        if (text.contains("python")) {

            suggestions.add("Practice Pandas");
            suggestions.add("Learn NumPy");
            suggestions.add("Try Machine Learning");

        }

        if (text.contains("ai")) {

            suggestions.add("Learn Neural Networks");
            suggestions.add("Study Deep Learning");
            suggestions.add("Explore TensorFlow");

        }

        if (text.contains("japan")) {

            suggestions.add("Practice JLPT N3");
            suggestions.add("Improve Spoken Japanese");
            suggestions.add("Prepare Japanese Resume");

        }

        if (suggestions.isEmpty()) {

            suggestions.add("Continue Learning Daily");
            suggestions.add("Solve Coding Problems");
            suggestions.add("Stay Consistent");

        }

        return suggestions;
    }
}