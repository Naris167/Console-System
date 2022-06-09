/*
LCD Class: represent a message box with a header and a content.
 */

import java.util.Iterator;

public class LCD implements Comparable<LCD> {
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

    public interface Comparable<T> {
        public int compareTo(T other_lcd);
    }

    public int compareTo(LCD other_lcd) {
        int dimension = width * height;
        int other_dimension = other_lcd.width * other_lcd.height;
        if (dimension < other_dimension) {
            return -1;
        } else if (dimension == other_dimension) {
            return 0;
        } else { // (dimension > other_dimension)
            return 1;
        }
    }

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

}