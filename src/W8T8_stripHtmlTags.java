// Task 8: This program removes HTML Tags in an input file.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class W8T8_stripHtmlTags {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("W8_html1.txt"));
        stripHtmlTags(file);
    }

    public static void stripHtmlTags(Scanner fileInput) {
        while (fileInput.hasNextLine()) {
            String text = fileInput.nextLine();

            while (text.contains("<") || text.contains(">")) {
                text = text.substring(0, text.indexOf("<")) + text.substring(text.indexOf(">") + 1);
            }

            if (text.equals("")) System.out.print("");
            else System.out.println(text);
        }
    }
}
