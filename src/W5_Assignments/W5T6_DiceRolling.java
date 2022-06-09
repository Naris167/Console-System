package W5_Assignments;

import java.util.Random;
import java.util.Scanner;

public class W5T6_DiceRolling {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int diceRoll = diceSum(console);
        System.out.println("\nI had to roll the dices for " + diceRoll + " times ! So tiring!");
        System.out.println("But it is OK as I am just a program and I can roll dices forever");
        System.out.println("as long as the computer I am running on is on.");
    }
    public static void sleepTime(int ms){
        try
        {
            Thread.sleep(ms);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static int diceSum(Scanner console){
        Random rand = new Random();
        int dice1;
        int dice2;
        int sum = 0;
        int tryNum = 0;
        int desired = getGuess(console);
        while(desired != sum){
            dice1 = rand.nextInt(6) + 1;
            dice2 = rand.nextInt(6) + 1;
            sum = dice1 + dice2;
            System.out.println(dice1 + " and " + dice2 + " = " + sum);
            tryNum++;
            //sleepTime(10);
        }
        return tryNum;
    }
    public static int getGuess(Scanner console) {
        int guess = getInt(console, "Desired dice sum: ");
        while (guess <= 1 || guess >= 13) {
            System.out.println("Out of range; try again.");
            guess = getInt(console, "Desired dice sum: ");
        }
        return guess;
    }

    public static int getInt(Scanner console, String prompt) {
        System.out.print(prompt);
        while (!console.hasNextInt()) {
            console.next(); // to discard the input
            System.out.println("Not an integer; try again.");
            System.out.print(prompt);
        }
        return console.nextInt();
    }
}
