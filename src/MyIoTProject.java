import java.util.Scanner;
import static java.lang.Character.toLowerCase;

public class MyIoTProject {
    enum MenuType {
        MAIN, LOGIN, CONSOLE_SETTING, CONSOLE_SETTING_MODE, RESTART, SHUTDOWN, AC, CAMERA_SETTING_MODE, ANTI_THEFT_SETTING_MODE
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
                    if (user_input == 1 || user_input == 2 || user_input == 3 ||
                            user_input == 4) {
                        switch (user_input) {
                            case 1:
                                currentMenu = MenuType.AC;
                                showACMenu(lcd1);
                                break;
                            case 2:
                                currentMenu = MenuType.CAMERA_SETTING_MODE;
                                showIPCameraSetting(lcd1);
                                break;
                            case 3:
                                currentMenu = MenuType.ANTI_THEFT_SETTING_MODE;
                                showAntiTheft(lcd1);
                                break;
                            case 4:
                                currentMenu = MenuType.MAIN;
                                showMainMenu(lcd1);
                                break;
                            default:
                                lcd1.printInvalidInput();
                        }
                    }
                    else { // input is invalid
                        lcd1.printInvalidInput();
                        break;
                    }
                    break;
                case RESTART:
                case SHUTDOWN:
                    currentMenu = MenuType.MAIN;
                    showMainMenu(lcd1);
                    break;
                case CONSOLE_SETTING:
                    if (user_input == 1 || user_input == 2 || user_input == 3) {
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
                    } else { // input is invalid
                        lcd1.printInvalidInput();
                        break;
                    }
                    break;
                case CONSOLE_SETTING_MODE:
                    if (user_input == 0 || user_input == 1) {
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
                    } else { // input is invalid
                        lcd1.printInvalidInput();
                        break;
                    }
                    break;
                case AC:
                    if (user_input >= 15 && user_input <= 30) {
                        lcd1.setACTemp(user_input);
                        currentMenu = MenuType.MAIN;
                        showMainMenu(lcd1);
                    } else { // input is invalid
                        lcd1.printInvalidACInput();
                        break;
                    }
                    break;
                case CAMERA_SETTING_MODE:
                    if (user_input == 0 || user_input == 1) {
                        switch (user_input) {
                            case 0:
                                lcd1.setCamIPMode("Off");
                                currentMenu = MenuType.MAIN;
                                showMainMenu(lcd1);
                                break;
                            case 1:
                                lcd1.setCamIPMode("On");
                                currentMenu = MenuType.MAIN;
                                showMainMenu(lcd1);
                                break;
                            default:
                                lcd1.printInvalidInput();
                        }
                    } else { // input is invalid
                            lcd1.printInvalidInput();
                            break;
                        }
                    break;
                case ANTI_THEFT_SETTING_MODE:
                    if (user_input == 0 || user_input == 1) {
                        switch (user_input) {
                            case 0:
                                lcd1.setAntiTheftMode("Off");
                                currentMenu = MenuType.MAIN;
                                showMainMenu(lcd1);
                                break;
                            case 1:
                                lcd1.setAntiTheftMode("On");
                                currentMenu = MenuType.MAIN;
                                showMainMenu(lcd1);
                                break;
                            default:
                                lcd1.printInvalidInput();
                        }
                    } else { // input is invalid
                        lcd1.printInvalidInput();
                        break;
                    }
                    break;
                default:
                    lcd1.printInvalidInput();
                    break;
            }
        }
    }

    public static messageBox createFunctionMenu () {
        messageBox msgBox = new messageBox("- Stamford Function Menu - ","ITE221 Project By Naris");
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
        messageBox msgBox = new messageBox ("- Stamford Menu System -","ITE221 Project By Naris");
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
        messageBox msgBox = new messageBox ("- Console Setting - ","ITE221 Project By Naris");
        mBoxLine mainMenu_l1 = new mBoxLine("Change Console mode", mBoxLine.verticalAlignment.LEFT);
        msgBox.addLine(mainMenu_l1);
        mBoxLine mainMenu_l2 = new mBoxLine("Reverse background color", mBoxLine.verticalAlignment.LEFT);
        msgBox.addLine(mainMenu_l2);

        mBoxLine mainMenu_l3 = new mBoxLine("Back", mBoxLine.verticalAlignment.LEFT);
        msgBox.addLine(mainMenu_l3);
        return msgBox;
    }

    public static messageBox createConsoleSettingModeMenu(LCD lcd) {
        messageBox msgBox = new messageBox ("- Console Setting, Mode -","ITE221 Project By Naris");
        String mode = lcd.getMode();
        String final_mode = mode.equals("E") ? "Extended" : "Normal";
        mBoxLine mainMenu_l1 = new mBoxLine("Current Mode is " + final_mode , mBoxLine.verticalAlignment.LEFT);
        msgBox.addLine(mainMenu_l1);
        return msgBox;
    }

    public static messageBox createRestartMenu () {
        messageBox msgBox = new messageBox ("- System Restart - ","ITE221 Project By Naris");
        mBoxLine mainMenu_l1 = new mBoxLine("System is being restarted, please be patient.", mBoxLine.verticalAlignment.LEFT);
        msgBox.addLine(mainMenu_l1);
        return msgBox;
    }

    public static messageBox createShutdownMenu () {
        messageBox msgBox = new messageBox ("- System Shutdown - ","ITE221 Project By Naris");
        mBoxLine mainMenu_l1 = new mBoxLine("System is being shutdown, please be patient.", mBoxLine.verticalAlignment.LEFT);
        msgBox.addLine(mainMenu_l1);
        return msgBox;
    }

    public static messageBox createACMenu(LCD lcd) {
        messageBox msgBox = new messageBox ("- Temperature Setting-","ITE221 Project By Naris");
        int currentTemp = lcd.getACTemp();
        mBoxLine mainMenu_l1 = new mBoxLine("Current Temperature is " + currentTemp , mBoxLine.verticalAlignment.LEFT);
        msgBox.addLine(mainMenu_l1);
        return msgBox;
    }

    public static messageBox createIPCameraSettingMenu(LCD lcd) {
        messageBox msgBox = new messageBox ("- IP Camera Setting-","ITE221 Project By Naris");
        String CamIPMode = lcd.getCamIPMode();
        String final_mode = CamIPMode.equals("On") ? "On" : "Off";
        mBoxLine mainMenu_l1 = new mBoxLine("Current Mode is " + final_mode , mBoxLine.verticalAlignment.LEFT);
        msgBox.addLine(mainMenu_l1);
        return msgBox;
    }

    public static messageBox createAntiTheftSettingMenu(LCD lcd) {
        messageBox msgBox = new messageBox ("- Anti Theft Setting-","ITE221 Project By Naris");
        String antiTheftMode = lcd.getAntiTheftMode();
        String final_mode = antiTheftMode.equals("On") ? "On" : "Off";
        mBoxLine mainMenu_l1 = new mBoxLine("Current Mode is " + final_mode , mBoxLine.verticalAlignment.LEFT);
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

    public static void showACMenu(LCD lcd) {
        messageBox setTempMenu_msgBox = createACMenu(lcd);
        lcd.setPrompt("Choose new temperature: ");
        lcd.setFuncCount(setTempMenu_msgBox.getContent().size());
        lcd.showMessageBox(setTempMenu_msgBox);
    }

    public static void showIPCameraSetting(LCD lcd){
        messageBox IPCameraSettingModeMenu_msgBox = createIPCameraSettingMenu(lcd);
        lcd.setPrompt("Choose console mode: 0 for Off, 1 for On");
        lcd.setFuncCount(IPCameraSettingModeMenu_msgBox.getContent().size());
        lcd.showMessageBox(IPCameraSettingModeMenu_msgBox);
    }

    public static void showAntiTheft(LCD lcd){
        messageBox cameraSettingModeMenu_msgBox = createAntiTheftSettingMenu(lcd);
        lcd.setPrompt("Choose console mode: 0 for Off, 1 for On");
        lcd.setFuncCount(cameraSettingModeMenu_msgBox.getContent().size());
        lcd.showMessageBox(cameraSettingModeMenu_msgBox);
    }
}