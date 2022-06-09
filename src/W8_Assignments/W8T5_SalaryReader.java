package W8_Assignments;// Task 5: Read salary information from a file and prints total salary
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class W8T5_SalaryReader {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("W8_salary.dat"));
        process(input);
    }

    public static void process(Scanner input) {
        System.out.printf("%-15s %-15s %-12s\n", "Employee Name", "Total hours", "Total Salary");
        while (input.hasNext()) {
            String name = input.next();
            double wage_per_hour = input.nextDouble();
            double sum = 0.0;
            while (input.hasNextDouble()) {
                sum += input.nextDouble();
            }

            System.out.printf("%-15s %-15.2f %-12.2f THB\n", name, sum , (sum * wage_per_hour));
        }
    }
}