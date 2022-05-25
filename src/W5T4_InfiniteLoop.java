import java.util.Scanner;

public class W5T4_InfiniteLoop {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int sum = 0;
        int number = 0;
        System.out.println("\nGive any integer to me, and I will add all of them!");
        while (number <= 0){ // the first loop will ask user to input for the first integer
            System.out.print("\nFirst integer (-1 to quit)? ");

            try {//Check if user input INT or not
                number = console.nextInt();
                if (number == -1){
                    System.out.println("sum = " + sum);
                    System.out.println("Exit the program!");
                    System.exit(0);
                } else if (number < 1){
                    System.out.println("Only positive integer is allowed!");
                } else {
                    sum += number;
                }
            } catch (Exception e) {
                System.out.println("Please only input the integer!");
                console = new Scanner(System.in); // this line is to reset the scanner, otherwise, we will be stuck in this loop forever
            }
        }

        number = 0; // to rest the value so that next loop will be activated

        while (number <= 0) { //this loop will ask for next integer
            System.out.print("\nnext integer (-1 to quit)? ");

            try {//Check if user input INT or not
                number = console.nextInt();
                if (number == -1){ // to exit the program
                    System.out.println("\nsum = " + sum);
                    System.out.println("Exit the program!");
                    System.exit(0);
                } else if (number < 1){ // when number is less than 1
                    System.out.println("Only positive integer is allowed!");
                } else {
                    sum += number;
                }
                number = 0;
            } catch (Exception e) {
                System.out.println("Please only input the integer!");
                console = new Scanner(System.in); // this line is to reset the scanner, otherwise, we will be stuck in this loop forever
            }
        }
    }
}
