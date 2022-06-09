import java.util.Scanner;
import static java.lang.Character.toLowerCase;

public class MyIoTProject {
    enum MenuType {
        MAIN, LOGIN, CONSOLE_SETTING, CONSOLE_SETTING_MODE, RESTART, SHUTDOWN
    }

    public static MenuType currentMenu = MenuType.MAIN;

    public static void main(String[] args) {
        LCD lcd1 = new LCD(80, 25);
//        LCD lcd2 = new LCD(90, 25);
//        LCD lcd3 = new LCD(40, 25);
//        LCD lcd4 = new LCD(100, 10);
//
//        System.out.println(lcd1.compareTo(lcd2));
//        System.out.println(lcd2.compareTo(lcd3));
//        System.out.println(lcd3.compareTo(lcd4));
//    }
            lcd1.hideCursor();
            lcd1.clearScreen();
            showMainMenu(lcd1);

            Scanner console = new Scanner(System.in);

            while (true) {
                int user_input = console.nextInt();

                switch (currentMenu) {
                    case MAIN : // mainMenu
                        if (user_input == 1 || user_input == 2 || user_input == 3 ||
                            user_input == 4 || user_input == 5) {
                        // Input is valid for main menu
                            switch (user_input) {
                                case 1:
                                    currentMenu = MenuType.LOGIN;
                                    showLogin(lcd1);
                                    break;
                                case 2:
                                    currentMenu = MenuType.CONSOLE_SETTING;
                                    showConsoleSetting(lcd1);
                                    break;
                                case 3:
                                    currentMenu = MenuType.RESTART;
                                    showRestart(lcd1);
                                    break;
                                case 4:
                                    currentMenu = MenuType.SHUTDOWN;
                                    showShutdown(lcd1);
                                    break;
                                case 5: lcd1.clearScreen(); /*showQuit();*/ System.exit(0);
                                    break;
                                default: lcd1.printInvalidInput();
                            }
                        } else { // input is invalid
                            lcd1.printInvalidInput();
                            break;
                        }
                        break;
                    case LOGIN: // Input is valid for main menu
                        switch (user_input) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                currentMenu = MenuType.MAIN; showMainMenu(lcd1);
                                break;
                            default:
                                lcd1.printInvalidInput();
                            }
                        break;
                    case RESTART:
                    case SHUTDOWN:
                        currentMenu = MenuType.MAIN;
                        showMainMenu(lcd1);
                        break;
                    case CONSOLE_SETTING:
                        switch (user_input) {
                            case 1:
                                currentMenu = MenuType.CONSOLE_SETTING_MODE;
                                showConsoleSettingMode(lcd1);
                                break;
                            case 2:
                                lcd1.reverseBackgroundMode();
                                currentMenu = MenuType.MAIN;
                                showMainMenu(lcd1);
                                break;
                            case 3:
                                currentMenu = MenuType.MAIN;
                                showMainMenu(lcd1);
                                break;
                            default:
                                lcd1.printInvalidInput();
                        }
                        break;
                    case CONSOLE_SETTING_MODE:
                        switch (user_input) {
                            case 0:
                                lcd1.setMode("N");
                                currentMenu = MenuType.MAIN;
                                showMainMenu(lcd1);
                                break;
                            case 1:
                                lcd1.setMode("E");
                                currentMenu = MenuType.MAIN;
                                showMainMenu(lcd1);
                                break;
                        default:
                            lcd1.printInvalidInput();
                        }
                        break;
                    default:
                        lcd1.printInvalidInput();
                        break;
                }
            }
    }

    public static messageBox createFunctionMenu () {
            messageBox msgBox = new messageBox("- Stamford Function Menu - ");
            mBoxLine mainMenu_l1 = new mBoxLine("Change AC Temperature set point", mBoxLine.verticalAlignment.LEFT);
            msgBox.addLine(mainMenu_l1);

            mBoxLine mainMenu_l2 = new mBoxLine("Enable/Disable IP Camera", mBoxLine.verticalAlignment.LEFT);
            msgBox.addLine(mainMenu_l2);

            mBoxLine mainMenu_l3 = new mBoxLine("Turn anti-theft system on/off", mBoxLine.verticalAlignment.LEFT);
            msgBox.addLine(mainMenu_l3);

            mBoxLine mainMenu_l4 = new mBoxLine("Back", mBoxLine.verticalAlignment.LEFT);
            msgBox.addLine(mainMenu_l4);
            return msgBox;
        }

    public static messageBox createMainMenu () {
            messageBox msgBox = new messageBox ("- Stamford Menu System - ");
            mBoxLine mainMenu_l1 = new mBoxLine("Login", mBoxLine.verticalAlignment.LEFT);
            msgBox.addLine(mainMenu_l1);

            mBoxLine mainMenu_l2 = new mBoxLine("Console Setting", mBoxLine.verticalAlignment.LEFT);
            msgBox.addLine(mainMenu_l2);

            mBoxLine mainMenu_l3 = new mBoxLine("Restart", mBoxLine.verticalAlignment.LEFT);
            msgBox.addLine(mainMenu_l3);

            mBoxLine mainMenu_l4 = new mBoxLine("Shutdown", mBoxLine.verticalAlignment.LEFT);
            msgBox.addLine(mainMenu_l4);

            mBoxLine mainMenu_l5 = new mBoxLine("Exit", mBoxLine.verticalAlignment.LEFT);
            msgBox.addLine(mainMenu_l5);

            return msgBox;
        }

    public static messageBox createConsoleSettingMenu () {
            messageBox msgBox = new messageBox ("- Console Setting - ");
            mBoxLine mainMenu_l1 = new mBoxLine("Change Console mode", mBoxLine.verticalAlignment.LEFT);
            msgBox.addLine(mainMenu_l1);
            mBoxLine mainMenu_l2 = new mBoxLine("Reverse background color", mBoxLine.verticalAlignment.LEFT);
            msgBox.addLine(mainMenu_l2);

            mBoxLine mainMenu_l3 = new mBoxLine("Back", mBoxLine.verticalAlignment.LEFT);
            msgBox.addLine(mainMenu_l3);
            return msgBox;
        }

    public static messageBox createConsoleSettingModeMenu(LCD lcd) {
            messageBox msgBox = new messageBox ("- Console Setting, Mode - ");
            String mode = lcd.getMode();
            String final_mode = mode.equals("E") ? "Extended" : "Normal";
            mBoxLine mainMenu_l1 = new mBoxLine("Current Mode is " + final_mode , mBoxLine.verticalAlignment.LEFT);
            msgBox.addLine(mainMenu_l1);
            return msgBox;
        }

    public static messageBox createRestartMenu () {
            messageBox msgBox = new messageBox ("- System Restart - ");
            mBoxLine mainMenu_l1 = new mBoxLine("System is being restarted, please be patient.", mBoxLine.verticalAlignment.LEFT);
            msgBox.addLine(mainMenu_l1);
            return msgBox;
        }

    public static messageBox createShutdownMenu () {
            messageBox msgBox = new messageBox ("- System Shutdown - ");
            mBoxLine mainMenu_l1 = new mBoxLine("System is being shutdown, please be patient.", mBoxLine.verticalAlignment.LEFT);
            msgBox.addLine(mainMenu_l1);
            return msgBox;
        }

    public static void showMainMenu(LCD lcd) {
            messageBox mainMenu_msgBox = createMainMenu();
            lcd.setPrompt("Select a function");
            lcd.setFuncCount(mainMenu_msgBox.getContent().size());
            lcd.showMessageBox(mainMenu_msgBox);
        }

    public static void showLogin(LCD lcd) {
            messageBox loginMenu_msgBox = createFunctionMenu();
            lcd.setPrompt("Select a function");
            lcd.setFuncCount(loginMenu_msgBox.getContent().size());
            lcd.showMessageBox(loginMenu_msgBox);
        }

    public static void showRestart(LCD lcd) {
            messageBox restartMenu_msgBox = createRestartMenu();
            lcd.setPrompt("Restarting");
            lcd.setFuncCount(restartMenu_msgBox.getContent().size());
            lcd.showMessageBox(restartMenu_msgBox);
            lcd.printProgress();
        }

    public static void showShutdown(LCD lcd) {
            messageBox shutdownMenu_msgBox = createShutdownMenu();
            lcd.setPrompt("Shutting down");
            lcd.setFuncCount(shutdownMenu_msgBox.getContent().size());
            lcd.showMessageBox(shutdownMenu_msgBox);
            lcd.printProgress();
        }

    public static void showConsoleSetting(LCD lcd) {
            messageBox consoleSettingMenu_msgBox = createConsoleSettingMenu();
            lcd.setPrompt("Select a function");
            lcd.setFuncCount(consoleSettingMenu_msgBox.getContent().size());
            lcd.showMessageBox(consoleSettingMenu_msgBox);
        }

    public static void showConsoleSettingMode(LCD lcd){
            messageBox consoleSettingModeMenu_msgBox = createConsoleSettingModeMenu(lcd);
            lcd.setPrompt("Choose console mode: 0 for Normal, 1 for Extended");
            lcd.setFuncCount(consoleSettingModeMenu_msgBox.getContent().size());
            lcd.showMessageBox(consoleSettingModeMenu_msgBox);
        }


//        int i = 42;
//        String s = "hello";
//        LCD lcd1 = new LCD(80,25);
//        LCD lcd2 = new LCD(40,10);
//        System.out.printf("LCD1 dimensions = (%d,%d)\n", lcd1.width, lcd1.height);
//        System.out.printf("LCD2 dimensions = (%d,%d)\n", lcd2.width, lcd2.height);
//        System.out.println("i is " + i);
//        System.out.println("s is " + s);
//        System.out.println("lcd1 is " + lcd1);
//        System.out.printf("LCD1 dimensions = (%d,%d)\n", lcd1.width, lcd1.height);
//        System.out.printf("LCD2 dimensions = (%d,%d)\n", lcd2.width, lcd2.height);

//        mainMenuLoop();
}

//    public static void sleepTime(int ms){
//        try
//        {
//            Thread.sleep(ms);
//        }
//        catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    public static void mainMenuLoop (){
//        boolean run = true;
//
//        while (run){
//            Scanner console = new Scanner(System.in);
//            LCD.showMainMenu(); //Show main menu and create input
//            LCD.GotoXY(12,3);
//            System.out.print("Your choice: ");
//            String commandS = console.nextLine(); //commandS is short for command string
//            char command = ' ';
//
//            if (commandS.length() == 1){ //Check if user input correct choice
//                LCD.GotoXY(14,3);
//                command = commandS.charAt(0);
//            } else if (commandS.length() > 1){
//                LCD.GotoXY(14,3);
//                System.out.println("Invalid choice please try again.");
//                sleepTime(2000);
//                mainMenuLoop();
//            }
//
//            switch (command) { //Calling another menu base on user's choice
//                case '1' :
//                    System.out.println("Entering login menu");
//                    loginMenuLoop();
//                    run = false;
//                    break;
//                case '2' :
//                    System.out.println("Entering restart menu");
//                    confirmRestartLoop();
//                    run = false;
//                    break;
//                case '3' :
//                    System.out.println("Entering shut down menu");
//                    confirmShutdownLoop();
//                    run = false;
//                    break;
//                case '0' :
//                    System.out.println("Exit Immediately");
//                    LCD.GotoXY(17,1);
//                    System.exit(0);
//                    break;
//                default :
//                    LCD.GotoXY(14,3);
//                    System.out.println("Invalid choice please try again.");
//                    sleepTime(2000);
//            }
//        }
//    }
//
//    public static void loginMenuLoop (){
//        boolean run = true;
//
//        while (run){
//            Scanner console = new Scanner(System.in);
//            LCD.showLoginMenu(); //Show login menu and create input
//            LCD.GotoXY(6,3);
//            System.out.print("Enter Username: ");
//            String text = console.nextLine();
//            LCD.GotoXY(8,3);
//
//            switch (text) { //Check if user input correct username
//                case "Naris" :
//                    System.out.println("Successfully Login");
//                    sleepTime(1000);
//                    systemMenuLoop();
//                    run = false;
//                    break;
//                case "0" :
//                    System.out.println("Returning to the previous page");
//                    mainMenuLoop();
//                    run = false;
//                    break;
//                default :
//                    System.out.println("Invalid username please try again.");
//                    sleepTime(2000);
//            }
//        }
//    }
//
//    public static void systemMenuLoop (){
//        boolean run = true;
//        int tempAC = 25;
//
//        while (run){
//            Scanner console = new Scanner(System.in);
//            LCD.showSystemMenu(); //Show system menu and create input
//            LCD.GotoXY(10,3);
//            System.out.print("Your choice: ");
//            String commandS = console.nextLine();
//            char command = ' ';
//
//            if (commandS.length() == 1){ //Check if user input correct username
//                command = commandS.charAt(0);
//            } else if (commandS.length() > 1){
//                LCD.GotoXY(12,3);
//                System.out.println("Invalid choice please try again.");
//                sleepTime(2000);
//                systemMenuLoop();
//            }
//
//            switch (command) {
//                case '1' :
//                    LCD.GotoXY(12,3);
//                    System.out.print("Input the degree of the AC temperature: ");
//                    boolean loopText1 = true;
//
//                    while (loopText1) {
//                        Scanner ans1 = new Scanner(System.in);
//
//                        try //Check if user input INT or not
//                        {
//                            tempAC = ans1.nextInt();
//                        }
//                        catch (Exception e)
//                        {
//                            LCD.GotoXY(14,3);
//                            System.out.println("Please only input the integer");
//                            sleepTime(2000);
//                            systemMenuLoop();
//                        }
//
//                        LCD.GotoXY(13,3);
//                        if (tempAC <= 30 && tempAC >= 15){ //Check if user input a valid temperature or not (between 15-30 °C)
//                            System.out.print("Current AC temperature is: " + tempAC + " °C");
//                        } else if (tempAC == 0){ // Since 0 °C is not available for this AC, number 0 is used to return to the previous page
//                            systemMenuLoop();
//                        } else if (tempAC > 30 || tempAC < 15){
//                            System.out.print("AC only support the temperature between 15 - 30 °C");
//                            LCD.GotoXY(14,3);
//                            System.out.println("Please try again with valid temperature");
//                        } else {
//                            System.out.println("Unknown error! Try again!");
//                        }
//
//                        sleepTime(2000);
//                        loopText1 = false;
//                    }
//                    break;
//                case '2' :
//                    LCD.GotoXY(12,3);
//                    System.out.print("Please type 'Enable' or 'Disable': ");
//                    boolean loopText2 = true;
//
//                    while (loopText2) {
//                        Scanner ans2 = new Scanner(System.in);
//                        String text2 = ans2.next();
//                        switch (text2.toLowerCase()) {
//                            case "enable":
//                                LCD.GotoXY(13,3);
//                                System.out.print("Successfully enabled IP camera.");
//                                sleepTime(2000);
//                                loopText2 = false;
//                                break;
//                            case "disable":
//                                LCD.GotoXY(13,3);
//                                System.out.print("Successfully disabled IP camera.");
//                                sleepTime(2000);
//                                loopText2 = false;
//                                break;
//                            case "0":
//                                systemMenuLoop();
//                                loopText2 = false;
//                                break;
//                            default:
//                                LCD.GotoXY(13,3);
//                                System.out.println("Invalid choice please try again.");
//                                sleepTime(2000);
//                        }
//                        systemMenuLoop();
//                    }
//                    break;
//                case '3' :
//                    LCD.GotoXY(12,3);
//                    System.out.print("Please type 'On' or 'Off': ");
//                    boolean loopText3 = true;
//
//                    while (loopText3) {
//                        Scanner ans3 = new Scanner(System.in);
//                        String text3 = ans3.next();
//                        switch (text3.toLowerCase()){
//                            case "on" :
//                                LCD.GotoXY(13,3);
//                                System.out.print("Successfully turned on anti-theft system.");
//                                sleepTime(2000);
//                                loopText3 = false;
//                                break;
//                            case "off" :
//                                LCD.GotoXY(13,3);
//                                System.out.print("Successfully turned off anti-theft system.");
//                                sleepTime(2000);
//                                loopText3 = false;
//                                break;
//                            case "0":
//                                systemMenuLoop();
//                                loopText3 = false;
//                                break;
//                            default:
//                                LCD.GotoXY(13,3);
//                                System.out.println("Invalid choice please try again.");
//                                sleepTime(2000);
//                        }
//                        systemMenuLoop();
//                    }
//                    break;
//                default :
//                    if (command == '0' || command == '4'){
//                        LCD.GotoXY(12,3);
//                        System.out.println("Returning to the main menu");
//                        mainMenuLoop();
//                    } else {
//                        LCD.GotoXY(12, 3);
//                        System.out.println("Invalid choice please try again.");
//                        sleepTime(2000);
//                    }
//            }
//        }
//    }
//
//    public static void confirmRestartLoop (){
//        boolean run = true;
//
//        while (run){
//            Scanner console = new Scanner(System.in);
//            LCD.confirmRestart();
//            LCD.GotoXY(7,3);
//            System.out.print("Your choice: ");
//            char command = console.next().charAt(0);
//            command = toLowerCase(command);
//
//            switch (command) {
//                case 'y' :
//                    LCD.showRestart();
//                    mainMenuLoop();
//                    break;
//                case 'n' :
//                    LCD.GotoXY(9,3);
//                    System.out.println("Returning to main menu");
//                    sleepTime(1000);
//                    mainMenuLoop();
//                    break;
//                default :
//                    LCD.GotoXY(9,3);
//                    System.out.println("Invalid value please try again.");
//                    sleepTime(1000);
//            }
//        }
//    }
//
//    public static void confirmShutdownLoop (){
//        boolean run = true;
//
//        while (run){
//            Scanner console = new Scanner(System.in);
//            LCD.confirmShutdown();
//            LCD.GotoXY(7,3);
//            System.out.print("Your choice: ");
//            char command = console.next().charAt(0);
//            command = toLowerCase(command);
//
//            switch (command) {
//                case 'y' :
//                    LCD.showShutdown();
//                    LCD.GotoXY(17,1);
//                    System.exit(0);
//                    break;
//                case 'n' :
//                    LCD.GotoXY(9,3);
//                    System.out.println("Returning to main menu");
//                    mainMenuLoop();
//                    break;
//                default :
//                    LCD.GotoXY(9,3);
//                    System.out.println("Invalid value please try again.");
//                    sleepTime(1000);
//            }
//        }
//    }
//}