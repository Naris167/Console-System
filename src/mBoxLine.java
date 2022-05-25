/*
mBoxLine class: represents a line in the message box content.
 */

public class mBoxLine {
    enum verticalAlignment {
        LEFT,CENTER,RIGHT
    }
    enum horizontalAlignment {
        TOP,MIDDLE,BOTTOM
    }

    public String text;
    public verticalAlignment alignment;

    public mBoxLine(String text, verticalAlignment alignment) {
        this.text = text;
        this.alignment = alignment;
    }
}
