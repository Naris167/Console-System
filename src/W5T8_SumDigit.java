import java.util.Scanner;
import java.lang.Math;

public class W5T8_SumDigit {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int masterSum = digitSum(console, "Please enter a number: ");
        System.out.println("Sum of all digit is: " + masterSum);
    }
    public static int digitSum(Scanner console, String prompt){
        System.out.print(prompt);
        int sum = 0;
        int num = Math.abs(console.nextInt());

        while (num > 0) {
            sum = sum + num % 10;
            //System.out.println("num mod " + (num % 10));
            num = num / 10;
            //System.out.println("num divide " + num);
        }
        return sum;
    }
}
