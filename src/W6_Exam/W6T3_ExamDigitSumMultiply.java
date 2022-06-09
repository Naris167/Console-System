package W6_Exam;

import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class W6T3_ExamDigitSumMultiply {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int masterSum = digitSumMultiply(console, "Enter an integer number: ");
        Random rand = new Random();
        int ranMultiply = rand.nextInt(10) + 1;
        System.out.println("The randomly generated number is " + ranMultiply + " and the result is : " + (ranMultiply * masterSum) + ".");
    }

    public static int digitSumMultiply(Scanner console, String prompt){
        System.out.print(prompt);
        int sum = 0;
        int num = 0;
        num = Math.abs(console.nextInt());
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }
}
