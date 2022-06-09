package W8_Assignments;// Task 2: Count words in a text file.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class W8T2_FileCountWord {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("W8_sample1.txt"));
        int count = 0;
        while (input.hasNext()) {
            String word = input.next();
            count++;
        }
        System.out.println("total words = " + count);
    }
}