import java.util.Scanner;

public class LCD {

    final static char escCode = 0x1B;

    public static int WIDTH = 80;
    public static int HEIGHT = 25;
    public static int LEFT = 1;
    public static int CENTER = 2;
    public static int RIGHT = 3;
    public static int TOP = 1;
    public static int MIDDLE = 2;
    public static int BOTTOM = 3;

    public static void hideCursor () {
        System.out.printf("%c[?25l", escCode);
    }

    public static void showCursor () {
        System.out.printf("%c[?25h", escCode);
    }

    public static void GotoXY (int x, int y) {
        System.out.printf("%c[%d;%df", escCode, x, y);
    }

    public static void printHorizontalBorder(int alignment) {
        //ALT + 218 = ┌ , ALT + 191 = ┐ , ALT + 179 = │ , ALT + 196 = ─ , ALT + 192 = └ , ALT + 217 = ┘
        if (alignment == 1) { //left alignment
            System.out.print("┌");
            for (int i = 1; i <= (WIDTH - 2); i++) {
                System.out.print("─");
            }
            System.out.println("┐");
        } else if (alignment == 2){ //middle alignment
            System.out.print("├");
            for (int i = 1; i <= (WIDTH - 2); i++) {
                System.out.print("─");
            }
            System.out.println("┤");
        } else if (alignment == 3){ //bottom alignment
            System.out.print("└");
            for (int i = 1; i <= (WIDTH - 2); i++) {
                System.out.print("─");
            }
            System.out.println("┘");
        }
    }

    public static void printMessage(String message, int alignment) {
        if (alignment == 1){ //left alignment
            System.out.print("│ " + message);
            int spaceLeft = WIDTH - 4 - message.length();
            for (int i = 1; i <= spaceLeft; i++) {
                System.out.print(" ");
            }
            System.out.println(" │");

        } else if (alignment == 2){ //center alignment
            int halfScreen = (WIDTH - 4) / 2;
            int halfMessageLength = message.length() / 2;
            int compensate = 0; // this value used to compensate the loss and over in printing space when there are difference in odd and even of width and message.
            if (WIDTH % 2 == 1 && message.length() % 2 == 0){
                compensate = 1;
            } else if (WIDTH % 2 == 0 && message.length() % 2 == 1){
                compensate = -1;
            }

            System.out.print("│ ");
            if ((WIDTH % 2 == 1 && message.length() % 2 == 0) || (WIDTH % 2 == 0 && message.length() % 2 == 1)) { //When width and message are difference in odd and even
                for (int i = 1; i <= (halfScreen - halfMessageLength); i++) {
                    System.out.print(" ");
                }
                System.out.print(message);
                for (int i = 1; i <= (halfScreen - halfMessageLength) + compensate; i++) {
                    System.out.print(" ");
                }
            } else if ((WIDTH % 2 == 1 && message.length() % 2 == 1) || (WIDTH % 2 == 0 && message.length() % 2 == 0)){ //When both width and message is odd or even
                for (int i = 1; i <= (halfScreen - halfMessageLength); i++) {
                    System.out.print(" ");
                }
                System.out.print(message);
                for (int i = 1; i <= (halfScreen - halfMessageLength); i++) {
                    System.out.print(" ");
                }
            }
            System.out.println(" │");

        } else if (alignment == 3){ //right alignment
            System.out.print("│ ");
            int spaceLeft = WIDTH - 4 - message.length();
            for (int i = 1; i <= spaceLeft; i++) {
                System.out.print(" ");
            }
            System.out.println(message + " │");
        } else {
            System.out.print("Invalid text alignment");
        }
    }

    public static void printMessageProgressAnimation(String message, int alignment, int speed, int duration, int line, int position) {
        char[] animationChars = new char[]{'|', '/', '-', '\\'};

        if (alignment == 1){ //left alignment
            for (int i = 0; i <= duration; i++) {
                //Start to print animation with message
                GotoXY(line,position);
                System.out.print("│ [ " + animationChars[i % 4] + " ] " + message);

                //Calculate space left and print space
                int spaceLeft = WIDTH - 10 - message.length();
                for (int j = 1; j <= spaceLeft; j++) {
                    System.out.print(" ");
                }
                System.out.println(" │");

                //Slow time to make animation looks good
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (alignment == 2){ //center alignment
            int extra = 6;
            int halfScreen = (WIDTH - 4) / 2;
            int halfMessageLength = (message.length() + extra) / 2;
            int compensate = 0; // this value used to compensate the loss and over in printing space when there are difference in odd and even of width and message.
            if (WIDTH % 2 == 1 && (message.length() + extra) % 2 == 0){
                compensate = 1;
            } else if (WIDTH % 2 == 0 && (message.length() + extra) % 2 == 1){
                compensate = -1;
            }


            for (int i = 0; i <= duration; i++) {
                //Start to print animation with message
                GotoXY(line,position);

                //Calculate space left and print space
                System.out.print("│ ");
                if ((WIDTH % 2 == 1 && (message.length() + extra) % 2 == 0) || (WIDTH % 2 == 0 && (message.length() + extra) % 2 == 1)) { //When width and message are difference in odd and even
                    for (int j = 1; j <= (halfScreen - halfMessageLength); j++) {
                        System.out.print(" ");
                    }
                    //System.out.print(message);
                    System.out.print("[ " + animationChars[i % 4] + " ] " + message);
                    for (int j = 1; j <= (halfScreen - halfMessageLength) + compensate; j++) {
                        System.out.print(" ");
                    }
                } else if ((WIDTH % 2 == 1 && (message.length() + extra) % 2 == 1) || (WIDTH % 2 == 0 && (message.length() + extra) % 2 == 0)){ //When both width and message is odd or even
                    for (int j = 1; j <= (halfScreen - halfMessageLength); j++) {
                        System.out.print(" ");
                    }
                    //System.out.print(message);
                    System.out.print("[ " + animationChars[i % 4] + " ] " + message);
                    for (int j = 1; j <= (halfScreen - halfMessageLength); j++) {
                        System.out.print(" ");
                    }
                }
                System.out.println(" │");

                //Slow time to make animation looks good
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (alignment == 3){ //right alignment
            for (int i = 0; i <= duration; i++) {
                //Start to print blank space
                GotoXY(line,position);
                System.out.print("│ ");
                int spaceLeft = WIDTH - 10 - message.length();
                for (int j = 1; j <= spaceLeft; j++) {
                    System.out.print(" ");
                }

                //Followed by animation and message
                System.out.print("[ " + animationChars[i % 4] + " ] " + message + " │");

                //Slow time to make animation looks good
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.print("Invalid text alignment");
        }
    }

    public static void progressAnimation (String message, int speed, int duration){
        char[] animationChars = new char[]{'|', '/', '-', '\\'};

        for (int i = 0; i <= duration; i++) {
            System.out.print("[ " + animationChars[i % 4] + " ]" + message + "\r");
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void clearScreen() {
        hideCursor ();
        for (int i = 1; i <= HEIGHT; i++) {
            for (int j = 1; j <= WIDTH; j++) {
                GotoXY(i,j);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static void insertBlankLine() {
        System.out.print("│");
        for (int i = 1; i <= (WIDTH - 2); i++) {
            System.out.print(" ");
        }
        System.out.println("│");
    }

    public static void showMainMenu() {
        clearScreen();
        GotoXY(1,1);
        printHorizontalBorder(TOP);
        printMessage("Welcome to Stamford LCD Library Demo", CENTER);
        insertBlankLine();
        printMessage("Select a Function (1-3)", CENTER);
        printHorizontalBorder(MIDDLE);
        insertBlankLine();
        printMessage("1. Login", LEFT);
        printMessage("2. Restart", LEFT);
        printMessage("3. Shutdown", LEFT);
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        printHorizontalBorder(BOTTOM);
    }

    public static void showLoginMenu() {
        clearScreen();
        GotoXY(1,1);
        printHorizontalBorder(TOP);
        printMessage("Login Menu. Press F1 for more information", CENTER);
        printMessage("Press 0 to go back", CENTER);
        printHorizontalBorder(MIDDLE);
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        printHorizontalBorder(BOTTOM);
    }

    public static void showSystemMenu() {
        clearScreen();
        GotoXY(1,1);
        printHorizontalBorder(TOP);
        printMessage("Select a Function (1-4)", CENTER);
        printHorizontalBorder(MIDDLE);
        insertBlankLine();
        printMessage("1. Change AC Temperature set point", LEFT);
        printMessage("2. Enable/Disable IP Camera", LEFT);
        printMessage("3. Turn anti-theft system on/off.", LEFT);
        printMessage("4. Exit", LEFT);
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        printHorizontalBorder(BOTTOM);
    }

    public static void confirmRestart() {
        clearScreen();
        GotoXY(1,1);
        printHorizontalBorder(TOP);
        printMessage("Restart Confirmation", CENTER);
        printHorizontalBorder(MIDDLE);
        insertBlankLine();
        printMessage("Are you sure that you want to restart the system? (Y/N)", LEFT);
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        printHorizontalBorder(BOTTOM);
    }

    public static void confirmShutdown() {
        clearScreen();
        GotoXY(1,1);
        printHorizontalBorder(TOP);
        printMessage("Shutdown Confirmation", CENTER);
        printHorizontalBorder(MIDDLE);
        insertBlankLine();
        printMessage("Are you sure that you want to shutdown the system? (Y/N)", LEFT);
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        printHorizontalBorder(BOTTOM);
    }

    public static void showRestart() {
        clearScreen();
        GotoXY(1,1);
        printHorizontalBorder(TOP);
        printMessage("Restarting ....", CENTER);
        printHorizontalBorder(MIDDLE);
        insertBlankLine();
        insertBlankLine();
        printMessage("[ | ] Please wait while the system is preparing for a restart", CENTER);
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        printHorizontalBorder(BOTTOM);
        printMessageProgressAnimation("Please wait while the system is preparing for a restart", CENTER, 50,80, 6, 1);

    }

    public static void showShutdown() {
        clearScreen();
        GotoXY(1,1);
        printHorizontalBorder(TOP);
        printMessage("Shutting down ....", CENTER);
        printHorizontalBorder(MIDDLE);
        insertBlankLine();
        insertBlankLine();
        printMessage("[ | ] Please wait while the system is preparing for a shutdown", CENTER);
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        printHorizontalBorder(BOTTOM);
        printMessageProgressAnimation("Please wait while the system is preparing for a shutdown", CENTER, 50,60, 6, 1);
    }
}