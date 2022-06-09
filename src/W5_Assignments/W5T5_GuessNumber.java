package W5_Assignments;

import java.util.Random;
import java.util.Scanner;

public class W5T5_GuessNumber {
    public static void main(String[] args) {
        giveIntro();
        Scanner console = new Scanner(System.in);
        Random rand = new Random(); // pick a random number from 0 to 99 inclusive
        int number = rand.nextInt(100);
        //System.out.println("<DEBUG> randomly generated number is = " + number);

        // get first guess
        int guess = getGuess(console);
        int numGuesses = 1;
        // give hints until correct guess is reached
        while (guess != number) {
            int numMatches = matches(number, guess);
            System.out.println("Incorrect (hint: " + numMatches + " digits match)");
            guess = getGuess(console);
            numGuesses++;
        }
        System.out.println("You got it right in " + numGuesses + " tries.");
    }

    public static void giveIntro() {
        System.out.println("\nTry to guess my two-digit number, and I’ll tell you how many digits from your guess appear in my number.");
        System.out.println();
    }

// returns # of matching digits between the two numbers
// pre: number and guess are unique two-digit numbers
    public static int matches(int number, int guess) {
        int numMatches = 0;
        if (guess / 10 == number / 10 || guess / 10 == number % 10){
            numMatches++;
        }
        if (guess / 10 != guess % 10 && (guess % 10 == number / 10 || guess % 10 == number % 10)) {
            numMatches++;
        }
        return numMatches;
    }

// prompts until a number in proper range is entered
// post: guess is between 0 and 99
    public static int getGuess(Scanner console) {
        int guess = getInt(console, "Your guess? ");
        while (guess < 0 || guess >= 100) {
            System.out.println("Out of range; try again with integer between 0 until 99.\n");
            guess = getInt(console, "Your guess? ");
            }
        return guess;
        }
// prompts until a valid number is entered
    public static int getInt(Scanner console, String prompt) {
        System.out.print(prompt);
        while (!console.hasNextInt()) {
            console.next(); // to discard the input
            System.out.println("Not an integer; try again with integer between 0 until 99.\n");
            System.out.print(prompt);
        }
        return console.nextInt();
    }
}
