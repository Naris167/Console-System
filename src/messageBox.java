/*
messageBox class: represent a message box with a header and a content.
 */

import java.util.ArrayList;

// A messageBox object represents a message box that can be drawn on LCD.
// A message box has a header and a content.
// Content consist of several lines that can be added by calling
// addLine() method.
public class messageBox {
    String header;
    String subHeader;
    ArrayList <mBoxLine> content;

    // default constructor
    public messageBox () {
        header = "No header";
        subHeader = "No sub header";
        //content = new ArrayList <> ();
    }

    // constructor
    public messageBox (String header, String subHeader) {
        this.header = header;
        this.subHeader = subHeader;
        content = new ArrayList <> (); //Empty Line!!
    }
    public void setHeader(String text) {
        header = text;
    }
    public String getHeader() {
        return header;
    }
    public void setSubHeader(String text) {
        subHeader = text;
    }
    public String getSubHeader() {
        return subHeader;
    }

    //Normal instant method
    public void addLine(mBoxLine line) {
        content.add(line);
    }
    public void clearContent() {
        content.clear();
    }
    public ArrayList <mBoxLine> getContent() {
        return content;
    }
}
