/*
LCD Class: represent a message box with a header and a content.
 */

import java.util.Iterator;

public class LCD {
    //These are called class field (which are BASICALLY DATA)
    int width;
    int height;
    int funcCount;
    String prompt;
    String mode;
    boolean reverseBackground;

    final static char escCode = 0x1B;

    final static char topLeft = 9484;
    final static char topRight = 9488;
    final static char bottomLeft = 9492;
    final static char bottomRight = 9496;
    final static char dash = 9472;
    final static char midLeft = 9500;
    final static char midRight = 9508;
    final static char bar = 9474;

    // Default constructor
    public LCD () {
        this.width = 80;
        this.height = 25;
        this.funcCount = 0;
        this.prompt = "Select a function";
        this.mode = "E"; // N = Normal, E = Extended
        reverseBackground = false;
    }

    // Constructor
    public LCD (int width, int height) {
        this.width = width;
        this.height = height;
        this.funcCount = 0;
        this.prompt = "Select a function";
        this.mode = "E"; // N = Normal, E = Extended
        reverseBackground = false;
    }



    // Mutators:
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setPrompt (String prompt) {
        this.prompt = prompt;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    public void setFuncCount(int funcCount) {
        this.funcCount = funcCount;
    }
    public void reverseBackgroundMode () {
        this.reverseBackground = !this.reverseBackground;
    }

    // Accessors:
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getResolution () {
        return width * height;
    }
    public String getPrompt () {
        return this.prompt;
    }
    public String getMode() {
        return this.mode;
    }
    public boolean getBackgroundMode () {
        return this.reverseBackground;
    }
    public String toString() {
        return "LCD object with dimension = (" + width + "," + height + ")";
    }


    // instance methods working on data:
    public void showMessageBox (messageBox mBox) {
        clearScreen();
        GotoXY(1, 1);
        System.out.printf("%c", topLeft);
        for (int i = 0; i < width - 2 ; i++) {
            System.out.print(dash);
        }
        System.out.print(topRight);

        GotoXY(2, 0);
        printBoxLine(mBox.getHeader(), mBoxLine.verticalAlignment.CENTER);
        GotoXY(3, 0);
        printBoxLine(" ", mBoxLine.verticalAlignment.LEFT);

        GotoXY(4, 0);
        System.out.print(midLeft);
        for (int i = 0; i < 78; i++) {
            System.out.print(dash);
        }
        System.out.print(midRight);
        GotoXY(5, 0);
        printBoxLine(" ", mBoxLine.verticalAlignment.LEFT);

        Iterator<mBoxLine> lines_iterator = mBox.getContent().iterator();

        Integer n = 1;
        while (lines_iterator.hasNext()) {
            GotoXY(5 + n, 0);
            mBoxLine line = lines_iterator.next();
            printBoxLine(n.toString() + ") " + line.text, line.alignment);
            n++;
        }

        for (int i = n + 5; i < 23; i++) {
            GotoXY(i, 0);
            printBoxLine(" ", mBoxLine.verticalAlignment.LEFT);
        }
        GotoXY(22, 0);
        System.out.print(midLeft);
        for (int i = 0; i < 78; i++) {
            System.out.print(dash);
        }
        System.out.print(midRight);

        GotoXY(23, 0);
        printStatusBar();
        GotoXY(24, 0);
        System.out.print(bottomLeft);
        for (int i = 0; i < 78; i++) {
            System.out.print(dash);
        }
        System.out.print(bottomRight);

        int prompt_size = prompt.length() + 11;
        GotoXY(23, prompt_size);
    }
    /*
    public void printMessage(String message, mBoxLine.verticalAlignment alignment) {
        int spaceLeft = width - 4 - message.length();
        switch (alignment){
            case LEFT :
                System.out.print("│ " + message);
                for (int i = 1; i <= spaceLeft; i++) {
                    System.out.print(" ");
                }
                System.out.println(" │");
                break;
            case CENTER :
                int halfScreen = (width - 4) / 2;
                int halfMessageLength = message.length() / 2;

                int compensate = 0; // this value used to compensate the loss and over in printing space when there are difference in odd and even of width and message.
                if (width % 2 == 1 && message.length() % 2 == 0){
                    compensate = 1;
                } else if (width % 2 == 0 && message.length() % 2 == 1){
                    compensate = -1;
                }

                System.out.print("│ ");
                if ((width % 2 == 1 && message.length() % 2 == 0) || (width % 2 == 0 && message.length() % 2 == 1)) { //When width and message are difference in odd and even
                    for (int i = 1; i <= (halfScreen - halfMessageLength); i++) {
                        System.out.print(" ");
                    }
                    System.out.print(message);
                    for (int i = 1; i <= (halfScreen - halfMessageLength) + compensate; i++) {
                        System.out.print(" ");
                    }
                } else if ((width % 2 == 1 && message.length() % 2 == 1) || (width % 2 == 0 && message.length() % 2 == 0)){ //When both width and message is odd or even
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
    */

    private void printBoxLine(String text, mBoxLine.verticalAlignment alignment) {
        if (reverseBackground){
            invertColor();
        }
        else {
            normalColor();
        }
        int textLength = text.length();
        int padding;
        boolean isEven;
        if(textLength % 2 == 0) { // 21 % 2 = 1 20 / 2 = 10
            // length is even
            padding = (80 - (6 + textLength)) / 2;
            isEven = true;
        }
        else {
        // length is odd
            padding = (80 - (6 + textLength + 1)) / 2;
            isEven = false;
        }
        switch (alignment) {
            case RIGHT: // alignment right
                System.out.print(bar + " ");
                printSpace(75 - textLength); // 79 - 2 - 2 - textlength
                System.out.print(text);
                System.out.print(" " + bar);
                break;
            case CENTER: // alignment center
                if (isEven) {
                    System.out.print(bar + " ");
                    printSpace(padding);
                    System.out.print(text);
                    printSpace(padding);
                    System.out.print(" " + bar);
                    break;
                }
                else { // odd
                    System.out.print(bar + " ");
                    printSpace(padding);
                    System.out.print(text);
                    printSpace(padding + 1);
                    System.out.print(" "+ bar);
                    break;
                }
            default: // 0: alignment left
                System.out.print(bar + " ");
                System.out.print(text);
                printSpace(75 - textLength); // 79 - 2 - 2 - textlength
                System.out.print(" " + bar);
                break;
        }
    }

    public void clearScreen() { //Outputs 25 empty lines.
        hideCursor ();
        if (reverseBackground) {
            invertColor();
        }
        else {
            normalColor();
        }
        GotoXY(1,1);
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                System.out.print(" ");
            }
            System.out.println(" ");
        }
        GotoXY(1,1);
    }

    public void printInvalidInput() {
        GotoXY(23, 0);
        System.out.print(bar + " ");
        System.out.print(prompt + "(1-" + funcCount + ") Invalid input. Please try again. >");
        GotoXY(23, 78);
        System.out.print(mode + " " + bar);
        int prompt_size = prompt.length() + 11 + 33;
        GotoXY(23, prompt_size);
    }

    public void printSpace(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.print(" ");
        }
    }

    private void printStatusBar() {
        System.out.print(bar + " ");
        System.out.print(prompt + "(1-" + funcCount + ") >");
        GotoXY(23, 78);
        System.out.print(mode + " " + bar);
    }

    public void printProgress() {
    // clear row 23
        for (int j = 1; j <= width - 1; j++) {
            GotoXY(23, j);
            System.out.print(' ');
        }

        GotoXY(23, 0);
        System.out.print(bar + " ");
        System.out.print(prompt + " #");

    // faking a restart that takes 5 seconds
        for (int i =0; i < 6; i++) {
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            System.out.print("#");
        }
        System.out.print(" Done! Press any integer to back to main menu.");
    }

    public void GotoXY (int x, int y) {
        System.out.printf("%c[%d;%df", escCode, x, y);
    }

    public void hideCursor () {
        System.out.printf("%c[?25l", escCode);
    }

    public void showCursor () {
        System.out.printf("%c[?25h", escCode);
    }

    public void invertColor () {
        System.out.printf("%c[7m", escCode);
    }

    public void normalColor () {
        System.out.printf("%c[0m", escCode);
    }


//    public void printHorizontalBorder(horizontalAlignment alignment) {
//        //ALT + 218 = ┌ , ALT + 191 = ┐ , ALT + 179 = │ , ALT + 196 = ─ , ALT + 192 = └ , ALT + 217 = ┘
//        switch (alignment){
//            case TOP :
//                System.out.print("┌");
//                for (int i = 1; i <= (width - 2); i++) {
//                    System.out.print("─");
//                }
//                System.out.println("┐");
//                break;
//            case MIDDLE :
//                System.out.print("├");
//                for (int i = 1; i <= (width - 2); i++) {
//                    System.out.print("─");
//                }
//                System.out.println("┤");
//                break;
//            case BOTTOM :
//                System.out.print("└");
//                for (int i = 1; i <= (width - 2); i++) {
//                    System.out.print("─");
//                }
//                System.out.println("┘");
//                break;
//            default:
//                System.out.println("Invalid alignment");
//        }
//    }
//
//    public void printMessage(String message, verticalAlignment alignment) {
//        int spaceLeft = width - 4 - message.length();
//        switch (alignment){
//            case LEFT :
//                System.out.print("│ " + message);
//                for (int i = 1; i <= spaceLeft; i++) {
//                    System.out.print(" ");
//                }
//                System.out.println(" │");
//                break;
//            case CENTER :
//                int halfScreen = (width - 4) / 2;
//                int halfMessageLength = message.length() / 2;
//
//                int compensate = 0; // this value used to compensate the loss and over in printing space when there are difference in odd and even of width and message.
//                if (width % 2 == 1 && message.length() % 2 == 0){
//                    compensate = 1;
//                } else if (width % 2 == 0 && message.length() % 2 == 1){
//                    compensate = -1;
//                }
//
//                System.out.print("│ ");
//                if ((width % 2 == 1 && message.length() % 2 == 0) || (width % 2 == 0 && message.length() % 2 == 1)) { //When width and message are difference in odd and even
//                    for (int i = 1; i <= (halfScreen - halfMessageLength); i++) {
//                        System.out.print(" ");
//                    }
//                    System.out.print(message);
//                    for (int i = 1; i <= (halfScreen - halfMessageLength) + compensate; i++) {
//                        System.out.print(" ");
//                    }
//                } else if ((width % 2 == 1 && message.length() % 2 == 1) || (width % 2 == 0 && message.length() % 2 == 0)){ //When both width and message is odd or even
//                    for (int i = 1; i <= (halfScreen - halfMessageLength); i++) {
//                        System.out.print(" ");
//                    }
//                    System.out.print(message);
//                    for (int i = 1; i <= (halfScreen - halfMessageLength); i++) {
//                        System.out.print(" ");
//                    }
//                }
//                System.out.println(" │");
//                break;
//            case RIGHT :
//                System.out.print("│ ");
//                for (int i = 1; i <= spaceLeft; i++) {
//                    System.out.print(" ");
//                }
//                System.out.println(message + " │");
//                break;
//            default:
//                System.out.println("Invalid alignment");
//        }
//    }
//
//    public void printMessageProgressAnimation(String message, verticalAlignment alignment, int speed, int duration, int line, int position) {
//        char[] animationChars = new char[]{'|', '/', '-', '\\'};
//        int extra = 6; // number of extra character of animation that will be print
//        int spaceLeft = width - 4 - message.length() - extra;
//        switch (alignment){
//            case LEFT :
//                for (int i = 0; i <= duration; i++) {
//                    //Start to print animation with message
//                    GotoXY(line,position);
//                    System.out.print("│ [ " + animationChars[i % 4] + " ] " + message);
//
//                    //Calculate space left and print space
//                    for (int j = 1; j <= spaceLeft; j++) {
//                        System.out.print(" ");
//                    }
//                    System.out.println(" │");
//
//                    //Slow time to make animation looks good
//                    try {
//                        Thread.sleep(speed);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                break;
//            case CENTER :
//                int halfScreen = (width - 4) / 2;
//                int halfMessageLength = (message.length() + extra) / 2;
//                int compensate = 0; // this value used to compensate the loss and over in printing space when there are difference in odd and even of width and message.
//                if (width % 2 == 1 && (message.length() + extra) % 2 == 0){
//                    compensate = 1;
//                } else if (width % 2 == 0 && (message.length() + extra) % 2 == 1){
//                    compensate = -1;
//                }
//                //This loop will print the message at center alignment based on above calculation
//                for (int i = 0; i <= duration; i++) {
//                    GotoXY(line,position); //Tells program to stay the same line and always repeat it
//
//                    System.out.print("│ ");
//                    if ((width % 2 == 1 && (message.length() + extra) % 2 == 0) || (width % 2 == 0 && (message.length() + extra) % 2 == 1)) { //When screen width and message are difference in odd and even
//                        for (int j = 1; j <= (halfScreen - halfMessageLength); j++) //Print blank space at left side
//                        {
//                            System.out.print(" ");
//                        }
//                        System.out.print("[ " + animationChars[i % 4] + " ] " + message); //Print animation followed by input message
//                        for (int j = 1; j <= (halfScreen - halfMessageLength) + compensate; j++) //Print blank space at right side
//                        {
//                            System.out.print(" ");
//                        }
//                    } else if ((width % 2 == 1 && (message.length() + extra) % 2 == 1) || (width % 2 == 0 && (message.length() + extra) % 2 == 0)){ //When both screen width and message is odd or even
//                        for (int j = 1; j <= (halfScreen - halfMessageLength); j++) //Print blank space at left side
//                        {
//                            System.out.print(" ");
//                        }
//                        System.out.print("[ " + animationChars[i % 4] + " ] " + message);//Print animation followed by input message
//                        for (int j = 1; j <= (halfScreen - halfMessageLength); j++) //Print blank space at right side
//                        {
//                            System.out.print(" ");
//                        }
//                    }
//                    System.out.println(" │");
//
//                    //Slow time to make animation looks good
//                    try {
//                        Thread.sleep(speed);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                break;
//            case RIGHT :
//                for (int i = 0; i <= duration; i++) {
//                    //Start to print blank space
//                    GotoXY(line,position);
//                    System.out.print("│ ");
//                    for (int j = 1; j <= spaceLeft; j++) {
//                        System.out.print(" ");
//                    }
//
//                    //Followed by animation and message
//                    System.out.print("[ " + animationChars[i % 4] + " ] " + message + " │");
//
//                    //Slow time to make animation looks good
//                    try {
//                        Thread.sleep(speed);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                break;
//            default:
//                System.out.println("Invalid alignment");
//        }
//    }
//
//    public void progressAnimation (String message, int speed, int duration){
//        char[] animationChars = new char[]{'|', '/', '-', '\\'};
//
//        for (int i = 0; i <= duration; i++) {
//            System.out.print("[ " + animationChars[i % 4] + " ]" + message + "\r");
//            try {
//                Thread.sleep(speed);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void clearScreen() {
//        hideCursor ();
//        GotoXY(1,1);
//        for (int i = 1; i <= height; i++) {
//            for (int j = 1; j <= width; j++) {
//                System.out.print(" ");
//            }
//            System.out.println(" ");
//        }
//        GotoXY(1,1);
//    }
//
//    public void insertBlankLine() {
//        System.out.print("│");
//        for (int i = 1; i <= (width - 2); i++) {
//            System.out.print(" ");
//        }
//        System.out.println("│");
//    }
//
//    public void showMainMenu() {
//        clearScreen();
//        printHorizontalBorder(horizontalAlignment.TOP);
//        printMessage("Welcome to Stamford LCD Library Demo", verticalAlignment.CENTER);
//        insertBlankLine();
//        printMessage("Select a Function (1-3)", verticalAlignment.CENTER);
//        printHorizontalBorder(horizontalAlignment.MIDDLE);
//        insertBlankLine();
//        printMessage("1. Login", verticalAlignment.LEFT);
//        printMessage("2. Restart", verticalAlignment.LEFT);
//        printMessage("3. Shutdown", verticalAlignment.LEFT);
//        printMessage("0. Exit Immediately", verticalAlignment.LEFT);
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        printHorizontalBorder(horizontalAlignment.BOTTOM);
//    }
//
//    public void showLoginMenu() {
//        clearScreen();
//        printHorizontalBorder(horizontalAlignment.TOP);
//        printMessage("Login Menu. Press F1 for more information", verticalAlignment.CENTER);
//        printMessage("Press 0 to go back", verticalAlignment.CENTER);
//        printHorizontalBorder(horizontalAlignment.MIDDLE);
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        printHorizontalBorder(horizontalAlignment.BOTTOM);
//    }
//
//    public void showSystemMenu() {
//        clearScreen();
//        printHorizontalBorder(horizontalAlignment.TOP);
//        printMessage("Select a Function (1-4)", verticalAlignment.CENTER);
//        printHorizontalBorder(horizontalAlignment.MIDDLE);
//        insertBlankLine();
//        printMessage("1. Change AC Temperature set point", verticalAlignment.LEFT);
//        printMessage("2. Enable/Disable IP Camera", verticalAlignment.LEFT);
//        printMessage("3. Turn anti-theft system on/off.", verticalAlignment.LEFT);
//        printMessage("4. Exit", verticalAlignment.LEFT);
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        printHorizontalBorder(horizontalAlignment.BOTTOM);
//    }
//
//    public void confirmRestart() {
//        clearScreen();
//        printHorizontalBorder(horizontalAlignment.TOP);
//        printMessage("Restart Confirmation", verticalAlignment.CENTER);
//        printHorizontalBorder(horizontalAlignment.MIDDLE);
//        insertBlankLine();
//        printMessage("Are you sure that you want to restart the system? (Y/N)", verticalAlignment.LEFT);
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        printHorizontalBorder(horizontalAlignment.BOTTOM);
//    }
//
//    public void confirmShutdown() {
//        clearScreen();
//        printHorizontalBorder(horizontalAlignment.TOP);
//        printMessage("Shutdown Confirmation", verticalAlignment.CENTER);
//        printHorizontalBorder(horizontalAlignment.MIDDLE);
//        insertBlankLine();
//        printMessage("Are you sure that you want to shutdown the system? (Y/N)", verticalAlignment.LEFT);
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        printHorizontalBorder(horizontalAlignment.BOTTOM);
//    }
//
//    public void showRestart() {
//        clearScreen();
//        printHorizontalBorder(horizontalAlignment.TOP);
//        printMessage("Restarting ....", verticalAlignment.CENTER);
//        printHorizontalBorder(horizontalAlignment.MIDDLE);
//        insertBlankLine();
//        insertBlankLine();
//        printMessage("[ | ] Please wait while the system is preparing for a restart", verticalAlignment.CENTER);
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        printHorizontalBorder(horizontalAlignment.BOTTOM);
//        printMessageProgressAnimation("Please wait while the system is preparing for a restart", verticalAlignment.CENTER, 50,80, 6, 1);
//
//    }
//
//    public void showShutdown() {
//        clearScreen();
//        printHorizontalBorder(horizontalAlignment.TOP);
//        printMessage("Shutting down ....", verticalAlignment.CENTER);
//        printHorizontalBorder(horizontalAlignment.MIDDLE);
//        insertBlankLine();
//        insertBlankLine();
//        printMessage("[ | ] Please wait while the system is preparing for a shutdown", verticalAlignment.CENTER);
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        insertBlankLine();
//        printHorizontalBorder(horizontalAlignment.BOTTOM);
//        printMessageProgressAnimation("Please wait while the system is preparing for a shutdown", verticalAlignment.CENTER, 50,60, 6, 1);
//    }
}