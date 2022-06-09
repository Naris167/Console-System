package W8_Assignments;// Task 9: This program removes coding comments in an input file.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class W8T9_stripCodingComment {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("W8_coding1.txt"));
        stripCodingComment(input);
    }
    public static void stripCodingComment(Scanner input) {
        while (input.hasNextLine()){
            String text = input.nextLine(); ///* My program

            if (text.contains("/*") && text.contains("*/ ")){// For the /*...*/
                text = text.substring(0, text.indexOf("/*")) + text.substring(text.indexOf("*/") + 3);
            } else if (text.contains("/*")){ // For the /*
                text = "";
            } else if (text.contains("*/")){ // For the */
                text = "";
            } else if (text.contains("//")){ // For the //
                text = text.substring(0, text.indexOf(";")+1);
            }

            if (text.equals("")) System.out.print("");
            else System.out.println(text);

        }

    }
}
