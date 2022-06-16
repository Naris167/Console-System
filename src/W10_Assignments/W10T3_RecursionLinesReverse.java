package W10_Assignments;

import java.util.*;
import java.io.*;
import java.util.Arrays;

public class W10T3_RecursionLinesReverse {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);

        System.out.print("file #1 name? "); // W10_File.txt
        Scanner input = new Scanner(new File(console.nextLine()));
        reverse(input);
        System.out.println("DOne");
    }

    public static void reverse(Scanner input) {

        System.out.println();

        if (input.hasNextLine()) {
            // recursive case (nonempty file)
            String line = input.nextLine();
            reverse(input);
            System.out.println(line);
            System.out.println();
        }
    }
}
