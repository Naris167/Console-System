import java.util.Scanner;
public class W4T1_Calculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the first integer operand: ");
        int first_op = console.nextInt();
        System.out.print("Enter the second integer operand: ");
        int second_op = console.nextInt();
        System.out.print("Enter the operation: ");
        char operation = console.next().charAt(0);
        System.out.print("I am going to perform the following calculation: ");
        System.out.println(first_op + " " + operation + " " + second_op);

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