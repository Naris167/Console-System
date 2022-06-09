package W8_Assignments;// Task 6: print file content in uppercase
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class W8T6_Uppercase {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("W8_poem.txt"));
        while (input.hasNextLine()) {
            String text = input.nextLine();
            System.out.println(text.toUpperCase());
            }
        }
}