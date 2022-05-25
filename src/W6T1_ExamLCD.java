public class W6T1_ExamLCD {

    final static char escCode = 0x1B;
    public static int WIDTH = 80;
    public static int HEIGHT = 25;
    enum verticalAlignment {
        LEFT,CENTER,RIGHT
    }
    enum horizontalAlignment {
        TOP,MIDDLE,BOTTOM
    }

    public static void hideCursor () {
        System.out.printf("%c[?25l", escCode);
    }

    public static void showCursor () {
        System.out.printf("%c[?25h", escCode);
    }

    public static void invertColor () {
        System.out.printf("%c[7m", escCode);
    }

    public static void normalColor () {
        System.out.printf("%c[0m", escCode);
    }

    public static void GotoXY (int x, int y) {
        System.out.printf("%c[%d;%df", escCode, x, y);
    }

    public static void printHorizontalBorder(horizontalAlignment alignment) {
        //ALT + 218 = ┌ , ALT + 191 = ┐ , ALT + 179 = │ , ALT + 196 = ─ , ALT + 192 = └ , ALT + 217 = ┘
        switch (alignment){
            case TOP :
                System.out.print("┌");
                for (int i = 1; i <= (WIDTH - 2); i++) {
                    System.out.print("─");
                }
                System.out.println("┐");
                break;
            case MIDDLE :
                System.out.print("├");
                for (int i = 1; i <= (WIDTH - 2); i++) {
                    System.out.print("─");
                }
                System.out.println("┤");
                break;
            case BOTTOM :
                System.out.print("└");
                for (int i = 1; i <= (WIDTH - 2); i++) {
                    System.out.print("─");
                }
                System.out.println("┘");
                break;
            default:
                System.out.println("Invalid alignment");
        }
    }

    public static void printMessage(String message, verticalAlignment alignment) {
        int spaceLeft = WIDTH - 4 - message.length();
        switch (alignment){
            case LEFT :
                System.out.print("│ " + message);
                for (int i = 1; i <= spaceLeft; i++) {
                    System.out.print(" ");
                }
                System.out.println(" │");
                break;
            case CENTER :
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
                break;
            case RIGHT :
                System.out.print("│ ");
                for (int i = 1; i <= spaceLeft; i++) {
                    System.out.print(" ");
                }
                System.out.println(message + " │");
                break;
            default:
                System.out.println("Invalid alignment");
        }
    }

    public static void printMessageProgressAnimation(String message, verticalAlignment alignment, int speed, int duration, int line, int position) {
        char[] animationChars = new char[]{'|', '/', '-', '\\'};
        int extra = 6; // number of extra character of animation that will be print
        int spaceLeft = WIDTH - 4 - message.length() - extra;
        switch (alignment){
            case LEFT :
                for (int i = 0; i <= duration; i++) {
                    //Start to print animation with message
                    GotoXY(line,position);
                    System.out.print("│ [ " + animationChars[i % 4] + " ] " + message);

                    //Calculate space left and print space
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
                break;
            case CENTER :
                int halfScreen = (WIDTH - 4) / 2;
                int halfMessageLength = (message.length() + extra) / 2;
                int compensate = 0; // this value used to compensate the loss and over in printing space when there are difference in odd and even of width and message.
                if (WIDTH % 2 == 1 && (message.length() + extra) % 2 == 0){
                    compensate = 1;
                } else if (WIDTH % 2 == 0 && (message.length() + extra) % 2 == 1){
                    compensate = -1;
                }
                //This loop will print the message at center alignment based on above calculation
                for (int i = 0; i <= duration; i++) {
                    GotoXY(line,position); //Tells program to stay the same line and always repeat it

                    System.out.print("│ ");
                    if ((WIDTH % 2 == 1 && (message.length() + extra) % 2 == 0) || (WIDTH % 2 == 0 && (message.length() + extra) % 2 == 1)) { //When screen width and message are difference in odd and even
                        for (int j = 1; j <= (halfScreen - halfMessageLength); j++) //Print blank space at left side
                        {
                            System.out.print(" ");
                        }
                        System.out.print("[ " + animationChars[i % 4] + " ] " + message); //Print animation followed by input message
                        for (int j = 1; j <= (halfScreen - halfMessageLength) + compensate; j++) //Print blank space at right side
                        {
                            System.out.print(" ");
                        }
                    } else if ((WIDTH % 2 == 1 && (message.length() + extra) % 2 == 1) || (WIDTH % 2 == 0 && (message.length() + extra) % 2 == 0)){ //When both screen width and message is odd or even
                        for (int j = 1; j <= (halfScreen - halfMessageLength); j++) //Print blank space at left side
                        {
                            System.out.print(" ");
                        }
                        System.out.print("[ " + animationChars[i % 4] + " ] " + message);//Print animation followed by input message
                        for (int j = 1; j <= (halfScreen - halfMessageLength); j++) //Print blank space at right side
                        {
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
                break;
            case RIGHT :
                for (int i = 0; i <= duration; i++) {
                    //Start to print blank space
                    GotoXY(line,position);
                    System.out.print("│ ");
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
                break;
            default:
                System.out.println("Invalid alignment");
        }
    }

    public static void clearScreen() {
        hideCursor ();
        GotoXY(1,1);
        for (int i = 1; i <= HEIGHT; i++) {
            for (int j = 1; j <= WIDTH; j++) {
                System.out.print(" ");
            }
            System.out.println(" ");
        }
        GotoXY(1,1);
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
        printHorizontalBorder(horizontalAlignment.TOP);
        insertBlankLine();
        printMessage("1) New Game", verticalAlignment.LEFT);
        printMessage("2) Change Difficulty Level", verticalAlignment.LEFT);
        printMessage("3) Quit", verticalAlignment.LEFT);
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        printHorizontalBorder(horizontalAlignment.BOTTOM);
    }

    public static void showInGameMenu() {
        clearScreen();
        printHorizontalBorder(horizontalAlignment.TOP);
        insertBlankLine();
        printMessage("We are in the game ! Enter 0 to go back to main menu.", verticalAlignment.LEFT);
        printMessage("Difficulty level = " + W6T1_Exam.difficulty, verticalAlignment.LEFT);
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        printHorizontalBorder(horizontalAlignment.BOTTOM);
    }

    public static void showDifficultyMenu() {
        clearScreen();
        printHorizontalBorder(horizontalAlignment.TOP);
        insertBlankLine();
        printMessage("Select a difficulty level:", verticalAlignment.LEFT);
        insertBlankLine();
        printMessage("0 = Noob", verticalAlignment.LEFT);
        printMessage("1 = Easy", verticalAlignment.LEFT);
        printMessage("2 = Medium", verticalAlignment.LEFT);
        printMessage("3 = Hard", verticalAlignment.LEFT);
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        printHorizontalBorder(horizontalAlignment.BOTTOM);
    }

    public static void confirmShutdown() {
        clearScreen();
        printHorizontalBorder(horizontalAlignment.TOP);
        printMessage("Shutdown Confirmation", verticalAlignment.CENTER);
        printHorizontalBorder(horizontalAlignment.MIDDLE);
        insertBlankLine();
        printMessage("Are you sure that you want to shutdown the system? (Y/N)", verticalAlignment.LEFT);
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
        printHorizontalBorder(horizontalAlignment.BOTTOM);
    }

    public static void showShutdown() {
        clearScreen();
        printHorizontalBorder(horizontalAlignment.TOP);
        printMessage("Shutting down ....", verticalAlignment.CENTER);
        printHorizontalBorder(horizontalAlignment.MIDDLE);
        insertBlankLine();
        insertBlankLine();
        printMessage("[ | ] Sad to see you leave, bye!", verticalAlignment.CENTER);
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        insertBlankLine();
        printHorizontalBorder(horizontalAlignment.BOTTOM);
        printMessageProgressAnimation("Sad to see you leave, bye!", verticalAlignment.CENTER, 50,60, 6, 1);
    }
}