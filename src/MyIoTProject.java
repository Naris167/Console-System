import java.util.Scanner;
import static java.lang.Character.toLowerCase;
import java.io.*;
import java.lang.Thread;

public class MyIoTProject {
    public static void main(String[] args){
        mainMenuLoop();
    }

    public static void mainMenuLoop (){
        boolean run = true;
        Scanner console = new Scanner(System.in);

        while (run){
            LCD.showMainMenu();
            LCD.GotoXY(11,3);
            System.out.print("Your choice: ");
            char command = console.next().charAt(0);
            LCD.GotoXY(13,3);

            switch (command) {
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
    }

    public static void loginMenuLoop (){
        boolean run = true;
        Scanner console = new Scanner(System.in);

        while (run){
            LCD.showLoginMenu();
            LCD.GotoXY(6,3);
            System.out.print("Enter Username: ");
            String text = console.nextLine();
            LCD.GotoXY(8,3);

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
    }

    public static void systemMenuLoop (){
        boolean run = true;
        int tempAC = 25;

        while (run){
            Scanner console = new Scanner(System.in);
            LCD.showSystemMenu();
            LCD.GotoXY(10,3);
            System.out.print("Your choice: ");
            String commandS = console.nextLine();
            char command = ' ';

            if (commandS.length() == 1){
                command = commandS.charAt(0);
            } else if (commandS.length() > 1){
                LCD.GotoXY(11,3);
                System.out.println("Invalid choice please try again.");
                try
                {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                systemMenuLoop();
            }

            switch (command) {
                case '1' :
                    boolean loopText1 = true;
                    while (loopText1) {
                        Scanner ans1 = new Scanner(System.in);
                        LCD.GotoXY(11,3);
                        System.out.print("Input the degree of the AC temperature: ");

                        try
                        {
                            tempAC = ans1.nextInt();
                        }
                        catch (Exception e)
                        {
                            LCD.GotoXY(13,3);
                            System.out.println("Please only input the integer");
                            try
                            {
                                Thread.sleep(3000);
                            }
                            catch (InterruptedException t)
                            {
                                e.printStackTrace();
                            }
                            systemMenuLoop();
                        }

                        LCD.GotoXY(13,3);
                        if (tempAC <= 30 && tempAC >= 15){
                            System.out.print("Current AC temperature is: " + tempAC);
                        } else if (tempAC == 0){
                            systemMenuLoop();
                        } else if (tempAC > 30 || tempAC < 15){
                            System.out.print("AC only support the temperature between 15 - 30 degrees Celsius");
                            LCD.GotoXY(14,3);
                            System.out.println("Please try again with valid temperature");
                        } else {
                            System.out.println("Unknown error! Try again!");
                        }

                        try
                        {
                            Thread.sleep(3000);
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
                    LCD.GotoXY(11,3);
                    System.out.print("Please type 'Enable' or 'Disable': ");
                    boolean loopText2 = true;

                    while (loopText2) {
                        String text2 = ans2.next();
                        switch (text2.toLowerCase()) {
                            case "enable":
                                LCD.GotoXY(13,3);
                                System.out.print("Successfully enabled IP camera.");
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
                                LCD.GotoXY(13,3);
                                System.out.print("Successfully disabled IP camera.");
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
                                LCD.GotoXY(13,3);
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
                    LCD.GotoXY(11,3);
                    System.out.print("Please type 'On' or 'Off': ");
                    boolean loopText3 = true;

                    while (loopText3) {
                        String text3 = ans3.next();
                        switch (text3.toLowerCase()){
                            case "on" :
                                LCD.GotoXY(13,3);
                                System.out.print("Successfully turned on anti-theft system.");
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
                                LCD.GotoXY(13,3);
                                System.out.print("Successfully turned off anti-theft system.");
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
                                LCD.GotoXY(13,3);
                                System.out.println("Invalid choice please try again.");
                                try
                                {
                                    Thread.sleep(2000);
                                }
                                catch (InterruptedException e)
                                {
                                    e.printStackTrace();
                                }
                                System.out.println(" "); //Just to wake a system to continue
                        }
                        systemMenuLoop();
                    }
                    break;
                case '4' :
                    LCD.GotoXY(11,3);
                    System.out.println("Returning to the main menu");
                    mainMenuLoop();
                    break;
                case '0' :
                    LCD.GotoXY(11,3);
                    System.out.println("Returning to the main menu");
                    mainMenuLoop();
                    break;
                default :
                    LCD.GotoXY(11,3);
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
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    mainMenuLoop();
                    break;
                default :
                    LCD.GotoXY(9,3);
                    System.out.println("Invalid value please try again.");
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
            }
        }
        run = false;
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
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
            }
        }
        run = false;
    }
}