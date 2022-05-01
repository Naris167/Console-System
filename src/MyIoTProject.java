import java.util.Scanner;
import static java.lang.Character.toLowerCase;
import java.io.*;
import java.lang.Thread;

public class MyIoTProject {
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

    public static void mainMenuLoop (){
        boolean run = true;

        while (run){
            Scanner console = new Scanner(System.in);
            LCD.showMainMenu(); //Show main menu and create input
            LCD.GotoXY(12,3);
            System.out.print("Your choice: ");
            String commandS = console.nextLine(); //commandS is short for command string
            char command = ' ';
            LCD.GotoXY(14,3);

            if (commandS.length() == 1){ //Check if user input correct choice
                command = commandS.charAt(0);
            } else if (commandS.length() > 1){
                LCD.GotoXY(14,3);
                System.out.println("Invalid choice please try again.");
                sleepTime(2000);
                mainMenuLoop();
            }

            switch (command) { //Calling another menu base on user's choice
                case '1' :
                    System.out.println("Entering login menu");
                    loginMenuLoop();
                    run = false;
                    break;
                case '2' :
                    System.out.println("Entering restart menu");
                    confirmRestartLoop();
                    run = false;
                    break;
                case '3' :
                    System.out.println("Entering shut down menu");
                    confirmShutdownLoop();
                    run = false;
                    break;
                case '0' :
                    LCD.GotoXY(13,3);
                    System.out.println("Exit Immediately");
                    LCD.GotoXY(17,1);
                    System.exit(0);
                    break;
                default :
                    System.out.println("Invalid choice please try again.");
                    sleepTime(2000);
            }
        }
    }

    public static void loginMenuLoop (){
        boolean run = true;

        while (run){
            Scanner console = new Scanner(System.in);
            LCD.showLoginMenu(); //Show login menu and create input
            LCD.GotoXY(6,3);
            System.out.print("Enter Username: ");
            String text = console.nextLine();
            LCD.GotoXY(8,3);

            switch (text) { //Check if user input correct username
                case "Naris" :
                    System.out.println("Successfully Login");
                    sleepTime(1000);
                    systemMenuLoop();
                    run = false;
                    break;
                case "0" :
                    System.out.println("Returning to the previous page");
                    mainMenuLoop();
                    run = false;
                    break;
                default :
                    System.out.println("Invalid username please try again.");
                    sleepTime(2000);
            }
        }
    }

    public static void systemMenuLoop (){
        boolean run = true;
        int tempAC = 25;

        while (run){
            Scanner console = new Scanner(System.in);
            LCD.showSystemMenu(); //Show system menu and create input
            LCD.GotoXY(10,3);
            System.out.print("Your choice: ");
            String commandS = console.nextLine();
            char command = ' ';

            if (commandS.length() == 1){ //Check if user input correct username
                command = commandS.charAt(0);
            } else if (commandS.length() > 1){
                LCD.GotoXY(11,3);
                System.out.println("Invalid choice please try again.");
                sleepTime(2000);
                systemMenuLoop();
            }

            switch (command) {
                case '1' :
                    LCD.GotoXY(11,3);
                    System.out.print("Input the degree of the AC temperature: ");
                    boolean loopText1 = true;

                    while (loopText1) {
                        Scanner ans1 = new Scanner(System.in);

                        try //Check if user input INT or not
                        {
                            tempAC = ans1.nextInt();
                        }
                        catch (Exception e)
                        {
                            LCD.GotoXY(13,3);
                            System.out.println("Please only input the integer");
                            sleepTime(2000);
                            systemMenuLoop();
                        }

                        LCD.GotoXY(13,3);
                        if (tempAC <= 30 && tempAC >= 15){ //Check if user input a valid temperature or not (between 15-30 °C)
                            System.out.print("Current AC temperature is: " + tempAC + " °C");
                        } else if (tempAC == 0){ // Since 0 °C is not available for this AC, number 0 is used to return to the previous page
                            systemMenuLoop();
                        } else if (tempAC > 30 || tempAC < 15){
                            System.out.print("AC only support the temperature between 15 - 30 °C");
                            LCD.GotoXY(14,3);
                            System.out.println("Please try again with valid temperature");
                        } else {
                            System.out.println("Unknown error! Try again!");
                        }

                        sleepTime(2000);
                        loopText1 = false;
                    }
                    break;
                case '2' :
                    LCD.GotoXY(11,3);
                    System.out.print("Please type 'Enable' or 'Disable': ");
                    boolean loopText2 = true;

                    while (loopText2) {
                        Scanner ans2 = new Scanner(System.in);
                        String text2 = ans2.next();
                        switch (text2.toLowerCase()) {
                            case "enable":
                                LCD.GotoXY(13,3);
                                System.out.print("Successfully enabled IP camera.");
                                sleepTime(2000);
                                loopText2 = false;
                                break;
                            case "disable":
                                LCD.GotoXY(13,3);
                                System.out.print("Successfully disabled IP camera.");
                                sleepTime(2000);
                                loopText2 = false;
                                break;
                            case "0":
                                systemMenuLoop();
                                loopText2 = false;
                                break;
                            default:
                                LCD.GotoXY(13,3);
                                System.out.println("Invalid choice please try again.");
                                sleepTime(2000);
                        }
                        systemMenuLoop();
                    }
                    break;
                case '3' :
                    LCD.GotoXY(11,3);
                    System.out.print("Please type 'On' or 'Off': ");
                    boolean loopText3 = true;

                    while (loopText3) {
                        Scanner ans3 = new Scanner(System.in);
                        String text3 = ans3.next();
                        switch (text3.toLowerCase()){
                            case "on" :
                                LCD.GotoXY(13,3);
                                System.out.print("Successfully turned on anti-theft system.");
                                sleepTime(2000);
                                loopText3 = false;
                                break;
                            case "off" :
                                LCD.GotoXY(13,3);
                                System.out.print("Successfully turned off anti-theft system.");
                                sleepTime(2000);
                                loopText3 = false;
                                break;
                            case "0":
                                systemMenuLoop();
                                loopText3 = false;
                                break;
                            default:
                                LCD.GotoXY(13,3);
                                System.out.println("Invalid choice please try again.");
                                sleepTime(2000);
                        }
                        systemMenuLoop();
                    }
                    break;
                default :
                    if (command == '0' || command == '4'){
                        LCD.GotoXY(11,3);
                        System.out.println("Returning to the main menu");
                        mainMenuLoop();
                    } else {
                        LCD.GotoXY(11, 3);
                        System.out.println("Invalid choice please try again.");
                        sleepTime(2000);
                    }
            }
        }
    }

    public static void confirmRestartLoop (){
        boolean run = true;

        while (run){
            Scanner console = new Scanner(System.in);
            LCD.confirmRestart();
            LCD.GotoXY(7,3);
            System.out.print("Your choice: ");
            char command = console.next().charAt(0);
            command = toLowerCase(command);

            switch (command) {
                case 'y' :
                    LCD.showRestart();
                    mainMenuLoop();
                    break;
                case 'n' :
                    LCD.GotoXY(9,3);
                    System.out.println("Returning to main menu");
                    sleepTime(1000);
                    mainMenuLoop();
                    break;
                default :
                    LCD.GotoXY(9,3);
                    System.out.println("Invalid value please try again.");
                    sleepTime(1000);
            }
        }
    }

    public static void confirmShutdownLoop (){
        boolean run = true;

        while (run){
            Scanner console = new Scanner(System.in);
            LCD.confirmShutdown();
            LCD.GotoXY(7,3);
            System.out.print("Your choice: ");
            char command = console.next().charAt(0);
            command = toLowerCase(command);

            switch (command) {
                case 'y' :
                    LCD.showShutdown();
                    LCD.GotoXY(17,1);
                    System.exit(0);
                    break;
                case 'n' :
                    LCD.GotoXY(9,3);
                    System.out.println("Returning to main menu");
                    mainMenuLoop();
                    break;
                default :
                    LCD.GotoXY(9,3);
                    System.out.println("Invalid value please try again.");
                    sleepTime(1000);
            }
        }
    }
}