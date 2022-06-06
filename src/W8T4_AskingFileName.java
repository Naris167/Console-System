// Task 4: Asks for a filename and then reads 5 numbers and prints the sum
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class W8T4_AskingFileName {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("This program will add a series");
        System.out.println("of numbers from a file.");
        System.out.println();
        Scanner console = new Scanner(System.in);
        System.out.print("What is the file name? ");
        String name = console.nextLine();
        Scanner input = new Scanner(new File(name));
        System.out.println();
        double sum = 0.0;
        int count = 0;
        while (input.hasNextDouble()) {
            double next = input.nextDouble();
            count++;
            System.out.println("number " + count + " = " + next);
            sum += next;
        }
        System.out.println("Sum = " + sum);
    }
}