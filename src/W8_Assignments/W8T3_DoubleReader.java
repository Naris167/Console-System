package W8_Assignments;// Task 3: Read 5 numbers and prints the sum
//
/* sample.txt file content:
308.2 14.9 7.4
5 2.8
3.9 4.7 -15.4
7 2.8
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class W8T3_DoubleReader {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("W8_sample2.txt"));
        double sum = 0.0;
        for (int i = 1; i <= 5; i++) {
            double next = input.nextDouble();
            System.out.println("number " + i + " = " + next);
            sum += next;
        }
        System.out.println("Sum = " + sum);
    }
}