package W4_Assignments;

import java.util.Scanner;
//Add a test condition to calculator example that checks if requested operation is a supported operation
public class W4T2_Calculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the first integer operand: ");
        int first_op = console.nextInt();
        System.out.print("Enter the second integer operand: ");
        int second_op = console.nextInt();
        System.out.print("Enter the operation: ");
        char operation = console.next().charAt(0);

        // Check if operation is supported
        if (operation == '+' || operation == '-' || operation == '/' || operation == '*') {
            System.out.println("Operation supported! I am going to perform the following calculation: " + first_op + " " + operation + " " + second_op);
        } else {
            System.out.println("Operation not supported or unrecognized operation.");
            System.exit(0);
        }

        int answer = 0;
        if (operation == '+') {
            answer = first_op + second_op;
        } else if (operation == '-') {
            answer = first_op - second_op;
        } else if (operation == '/') {
            answer = first_op / second_op;
        } else if (operation == '*') {
            answer = first_op * second_op;
        } else {
            answer = -1;
        }

        System.out.println("The answer is: " + answer);
    }
}