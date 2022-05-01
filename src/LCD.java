public class LCD {

    public static int WIDTH = 80;
    public static int HEIGHT = 25;
    public static int LEFT = 1;
    public static int CENTER = 2;
    public static int RIGHT = 3;

    public static void clearScreen() {

        for (int i = 1; i <= HEIGHT; i++) {
            for (int j = 1; j <= WIDTH; j++) {
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static void printHorizontalBorder() {
        //ALT + 218 = ┌ , ALT + 191 = ┐ , ALT + 179 = │ , ALT + 196 = ─ , ALT + 192 = └ , ALT + 217 = ┘
        for (int i = 1; i <= (WIDTH - 2); i++) {
            System.out.print("─");
        }
    }

    public static void insertBlankLine() {
        System.out.print("│");
        for (int i = 1; i <= (WIDTH - 2); i++) {
            System.out.print(" ");
        }
        System.out.println("│");
    }

    public static void printMessage(String message, int alignment) {
        System.out.println(message);
    }

//    System.out.print("┌");
//    System.out.println("┐");
//    System.out.print("├");
//    System.out.println("┤");
//    System.out.print("└");
//    System.out.println("┘");


    public static void showMainMenu() {
        System.out.print("┌");
        printHorizontalBorder();
        System.out.println("┐");
        printMessage("Welcome to Stamford LCD Library Demo",CENTER);
        insertBlankLine();
        printMessage("Select a Function (1-3)",CENTER);
        System.out.print("├");
        printHorizontalBorder();
        System.out.println("┤");
        insertBlankLine();
        printMessage("1. Login",LEFT);
        printMessage("2. Restart",LEFT);
        printMessage("3. Shutdown",LEFT);
        System.out.print("└");
        printHorizontalBorder();
        System.out.println("┘");
    }

    public static void showLoginMenu() {
        System.out.print("┌");
        printHorizontalBorder();
        System.out.println("┐");
        printMessage("Login Menu. Press F1 for more information",CENTER);
        System.out.print("├");
        printHorizontalBorder();
        System.out.println("┤");
        insertBlankLine();
        printMessage("Enter Username:",LEFT);
        System.out.print("└");
        printHorizontalBorder();
        System.out.println("┘");
    }

    public static void showSystemMenu() {
        System.out.print("┌");
        printHorizontalBorder();
        System.out.println("┐");
        printMessage("Select a Function (1-4)",CENTER);
        System.out.print("├");
        printHorizontalBorder();
        System.out.println("┤");
        insertBlankLine();
        printMessage("1. Change AC Temperature set point",LEFT);
        printMessage("2. Enable/Disable IP Camera",LEFT);
        printMessage("3. Turn anti-theft system on/off.",LEFT);
        printMessage("4. Exit",LEFT);
        System.out.print("└");
        printHorizontalBorder();
        System.out.println("┘");
    }

    public static void confirmRestart() {
        System.out.print("┌");
        printHorizontalBorder();
        System.out.println("┐");
        printMessage("Restart Confirmation",CENTER);
        System.out.print("├");
        printHorizontalBorder();
        System.out.println("┤");
        insertBlankLine();
        printMessage("Are you sure that you want to restart the system? (Y/N)",LEFT);
        System.out.print("└");
        printHorizontalBorder();
        System.out.println("┘");
    }

    public static void confirmShutdown() {
        System.out.print("┌");
        printHorizontalBorder();
        System.out.println("┐");
        printMessage("Shutdown Confirmation",CENTER);
        System.out.print("├");
        printHorizontalBorder();
        System.out.println("┤");
        insertBlankLine();
        printMessage("Are you sure that you want to shutdown the system? (Y/N)",LEFT);
        System.out.print("└");
        printHorizontalBorder();
        System.out.println("┘");
    }

    public static void showRestart() {
        System.out.print("┌");
        printHorizontalBorder();
        System.out.println("┐");
        printMessage("Restarting ....",CENTER);
        System.out.print("├");
        printHorizontalBorder();
        System.out.println("┤");
        insertBlankLine();
        printMessage("Please wait while the system is preparing for a restart.",LEFT);
        System.out.print("└");
        printHorizontalBorder();
        System.out.println("┘");
    }

    public static void showShutdown() {
        System.out.print("┌");
        printHorizontalBorder();
        System.out.println("┐");
        printMessage("Shutting down ....",CENTER);
        System.out.print("├");
        printHorizontalBorder();
        System.out.println("┤");
        insertBlankLine();
        printMessage("Please wait while the system is preparing for a shutdown.",LEFT);
        System.out.print("└");
        printHorizontalBorder();
        System.out.println("┘");
    }
}