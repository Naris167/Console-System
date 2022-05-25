import java.util.Scanner;
import static java.lang.Character.toLowerCase;

import java.lang.Thread;

public class W6T1_Exam {
    public static void main(String[] args){

        mainMenuLoop();
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

    public static String difficulty = "Easy";

    public static void mainMenuLoop (){
        boolean run = true;

        while (run){
            Scanner console = new Scanner(System.in);
            W6T1_ExamLCD.showMainMenu(); //Show main menu and create input
            W6T1_ExamLCD.GotoXY(7,3);
            System.out.print("Please enter a number (1-3): ");
            String commandS = console.nextLine(); //commandS is short for command string
            char command = ' ';

            if (commandS.length() == 1){ //Check if user input correct choice
                W6T1_ExamLCD.GotoXY(9,3);
                command = commandS.charAt(0);
            } else if (commandS.length() > 1){
                W6T1_ExamLCD.GotoXY(9,3);
                System.out.println("Invalid input. Please try again.");
                sleepTime(2000);
                mainMenuLoop();
            }

            switch (command) { //Calling another menu base on user's choice
                case '1' :
                    System.out.println("Entering New Game");
                    inGameMenuLoop();
                    run = false;
                    break;
                case '2' :
                    System.out.println("Change Difficulty Level");
                    difficultyMenuLoop();
                    run = false;
                    break;
                case '3' :
                    System.out.println("Entering shut down menu");
                    confirmShutdownLoop();
                    run = false;
                    break;
                default :
                    W6T1_ExamLCD.GotoXY(9,3);
                    System.out.println("Invalid input. Please try again.");
                    sleepTime(2000);
            }
        }
    }

    public static void inGameMenuLoop (){
        boolean run = true;

        while (run){
            Scanner console = new Scanner(System.in);
            W6T1_ExamLCD.showInGameMenu(); //Show login menu and create input
            W6T1_ExamLCD.GotoXY(6,3);
            System.out.print("Please enter a character: ");
            String text = console.nextLine();
            W6T1_ExamLCD.GotoXY(8,3);

            switch (text) { //Check if user input correct username
                case "0" :
                    mainMenuLoop();
                    run = false;
                    break;
                default :
                    inGameMenuLoop();
            }
        }
    }

    public static void difficultyMenuLoop (){
        boolean run = true;
        while (run){
            Scanner console = new Scanner(System.in);
            W6T1_ExamLCD.showDifficultyMenu(); //Show system menu and create input
            W6T1_ExamLCD.GotoXY(10,3);
            System.out.print("Please enter a number (0-3): ");
            String commandS = console.nextLine();
            char command = ' ';

            if (commandS.length() == 1){ //Check if user input correct username
                command = commandS.charAt(0);
            } else if (commandS.length() > 1){
                W6T1_ExamLCD.GotoXY(12,3);
                System.out.println("Invalid input. Please try again.");
                sleepTime(2000);
                difficultyMenuLoop();
            }

            switch (command) {
                case '0' :
                    difficulty = "Noob";
                    W6T1_ExamLCD.GotoXY(12,3);
                    System.out.print("Difficulty set to " + difficulty + ". Returning to main menu.");
                    sleepTime(2000);
                    mainMenuLoop();
                    break;
                case '1' :
                    difficulty = "Easy";
                    W6T1_ExamLCD.GotoXY(12,3);
                    System.out.print("Difficulty set to " + difficulty + ". Returning to main menu.");
                    sleepTime(2000);
                    mainMenuLoop();
                    break;
                case '2' :
                    difficulty = "Medium";
                    W6T1_ExamLCD.GotoXY(12,3);
                    System.out.print("Difficulty set to " + difficulty + ". Returning to main menu.");
                    sleepTime(2000);
                    mainMenuLoop();
                    break;
                case '3' :
                    difficulty = "Hard";
                    W6T1_ExamLCD.GotoXY(12,3);
                    System.out.print("Difficulty set to " + difficulty + ". Returning to main menu.");
                    sleepTime(2000);
                    mainMenuLoop();
                    break;
                default :
                    W6T1_ExamLCD.GotoXY(12, 3);
                    System.out.println("Invalid input. Please try again.");
                    sleepTime(2000);

            }
        }
    }

    public static void confirmShutdownLoop (){
        boolean run = true;

        while (run){
            Scanner console = new Scanner(System.in);
            W6T1_ExamLCD.confirmShutdown();
            W6T1_ExamLCD.GotoXY(7,3);
            System.out.print("Your choice: ");
            char command = console.next().charAt(0);
            command = toLowerCase(command);

            switch (command) {
                case 'y' :
                    W6T1_ExamLCD.showShutdown();
                    W6T1_ExamLCD.GotoXY(17,1);
                    System.exit(0);
                    break;
                case 'n' :
                    W6T1_ExamLCD.GotoXY(9,3);
                    System.out.println("Returning to main menu");
                    mainMenuLoop();
                    break;
                default :
                    W6T1_ExamLCD.GotoXY(9,3);
                    System.out.println("Invalid value please try again.");
                    sleepTime(1000);
            }
        }
    }
}