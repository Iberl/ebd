package de.ibw.tms.ma.positioned.elements;

public class Line extends LinearElement {
    public static final String CLASS_IDENTIFIER = "Line";

    private int lineNumber;
    private int length;


    public Line() {
        super(CLASS_IDENTIFIER);
    }


    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
