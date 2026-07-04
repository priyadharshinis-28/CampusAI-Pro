import java.io.FileWriter;
import java.io.IOException;

public class PDFExporter {

    private PDFExporter() {
    }

    public static void exportChat(String content) {

        try {

            FileWriter writer = new FileWriter("CampusAI_Chat.txt");

            writer.write("========== CampusAI Chat ==========\n\n");
            writer.write(content);

            writer.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}