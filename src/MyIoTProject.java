import java.util.Scanner;
import static java.lang.Character.toLowerCase;
import java.io.*;
import java.lang.Thread;

public class MyIoTProject {
    //public static Scanner console = new Scanner(System.in);

    public static void main(String[] args){
        mainMenuLoop();
//        LCD.clearScreen();
//        LCD.showLoginMenu();
//        LCD.showSystemMenu();
//        LCD.confirmRestart();
//        LCD.confirmShutdown();
//        LCD.showRestart();
//        LCD.showShutdown();

    }

    public static void mainMenuLoop (){
        boolean run = true;
        Scanner console = new Scanner(System.in);

        while (run){
            LCD.showMainMenu();
            System.out.print("Your choice: ");
            char command = console.next().charAt(0);

            switch (command) {
                case '1' :
                    System.out.println("1 selected");
                    loginMenuLoop();
                    run = false;
                    break;
                case '2' :
                    System.out.println("2 selected");
                    confirmRestartLoop();
                    run = false;
                    break;
                case '3' :
                    System.out.println("3 selected");
                    confirmShutdownLoop();
                    run = false;
                    break;
                default :
                    System.out.println("Please select a valid choice.");
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
            }
        }
        run = false;
    }

    public static void loginMenuLoop (){
        boolean run = true;
        Scanner console = new Scanner(System.in);

        while (run){
            LCD.showLoginMenu();
            System.out.print("Your answer: ");
            String text = console.nextLine();

            switch (text) {
                case "Naris" :
                    System.out.println("Successfully Login");
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
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
            }
        }
        run = false;
    }

    public static void systemMenuLoop (){
        boolean run = true;
        int tempAC = 25;

        while (run){
            Scanner console = new Scanner(System.in);
            LCD.showSystemMenu();
            System.out.print("Your choice: ");
            char command = console.next().charAt(0);

            switch (command) {
                case '1' :
                    boolean loopText1 = true;
                    while (loopText1) {
                        Scanner ans1 = new Scanner(System.in);
                        System.out.print("Input the degree of the AC temperature: ");
                        try
                        {
                            tempAC = ans1.nextInt();
                        }
                        catch (Exception e)
                        {
                            System.out.println("\nPlease only input the integer");
                        }
                        System.out.print("\nCurrent AC temperature is: " + tempAC);
                        try
                        {
                            Thread.sleep(2000);
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                        loopText1 = false;
                    }
                    break;
                case '2' :
                    Scanner ans2 = new Scanner(System.in);
                    System.out.print("Please type 'Enable' or 'Disable': ");
                    boolean loopText2 = true;

                    while (loopText2) {
                        String text2 = ans2.next();
                        switch (text2.toLowerCase()) {
                            case "enable":
                                System.out.print("\nSuccessfully enabled IP camera.");
                                try
                                {
                                    Thread.sleep(2000);
                                }
                                catch (InterruptedException e)
                                {
                                    e.printStackTrace();
                                }
                                loopText2 = false;
                                break;
                            case "disable":
                                System.out.print("\nSuccessfully disabled IP camera.");
                                try
                                {
                                    Thread.sleep(2000);
                                }
                                catch (InterruptedException e)
                                {
                                    e.printStackTrace();
                                }
                                loopText2 = false;
                                break;
                            case "0":
                                systemMenuLoop();
                                loopText2 = false;
                                break;
                            default:
                                System.out.println("Invalid choice please try again.");
                                try
                                {
                                    Thread.sleep(2000);
                                }
                                catch (InterruptedException e)
                                {
                                    e.printStackTrace();
                                }
                        }
                        systemMenuLoop();
                    }
                    break;
                case '3' :
                    Scanner ans3 = new Scanner(System.in);
                    System.out.print("Please type 'On' or 'Off': ");
                    boolean loopText3 = true;

                    while (loopText3) {
                        String text3 = ans3.next();
                        switch (text3.toLowerCase()){
                            case "on" :
                                System.out.print("\nSuccessfully turned on anti-theft system.");
                                try
                                {
                                    Thread.sleep(2000);
                                }
                                catch (InterruptedException e)
                                {
                                    e.printStackTrace();
                                }
                                loopText3 = false;
                                break;
                            case "off" :
                                System.out.print("\nSuccessfully turned off anti-theft system.");
                                try
                                {
                                    Thread.sleep(2000);
                                }
                                catch (InterruptedException e)
                                {
                                    e.printStackTrace();
                                }
                                loopText3 = false;
                                break;
                            case "0":
                                systemMenuLoop();
                                loopText3 = false;
                                break;
                            default:
                                System.out.println("Invalid choice please try again.");
                                try
                                {
                                    Thread.sleep(2000);
                                }
                                catch (InterruptedException e)
                                {
                                    e.printStackTrace();
                                }
                                System.out.println(" ");
                        }
                        systemMenuLoop();
                    }
                    break;
                case '4' :
                    System.out.println("Returning to the main menu");
                    mainMenuLoop();
                    break;
                default :
                    System.out.println("Invalid choice please try again.");
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
            }
        }
        run = false;
    }

    public static void confirmRestartLoop (){
        boolean run = true;

        while (run){
            Scanner console = new Scanner(System.in);
            LCD.confirmRestart();
            System.out.print("Your answer: ");
            char command = console.next().charAt(0);
            command = toLowerCase(command);

            switch (command) {
                case 'y' :
                    LCD.showRestart();
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    mainMenuLoop();
                    break;
                case 'n' :
                    System.out.println("Returning to main menu");
                    mainMenuLoop();
                    break;
                default :
                    System.out.println("Invalid value please try again.");
            }
        }
        run = false;
    }

    public static void confirmShutdownLoop (){
        boolean run = true;

        while (run){
            Scanner console = new Scanner(System.in);
            LCD.confirmShutdown();
            System.out.print("Your answer: ");
            char command = console.next().charAt(0);
            command = toLowerCase(command);

            switch (command) {
                case 'y' :
                    LCD.showShutdown();
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    System.exit(0);
                    break;
                case 'n' :
                    System.out.println("Returning to main menu");
                    mainMenuLoop();
                    break;
                default :
                    System.out.println("Invalid value please try again.");
            }
        }
        run = false;
    }
}