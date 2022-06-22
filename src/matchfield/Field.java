package matchfield;

import processing.core.PApplet;

public class Field extends Matchfield{

    public Field (int positionX, int positionY, int width, int height, boolean empty, PApplet pApplet) {
        super(pApplet);
        setPositionXY(positionX,positionY);
        setImageWidth(width);
        setImageHeight(height);
        setCornerLeftUpX();
        setCornerLeftUpY();
        setCornerLeftDownX();
        setCornerLeftDownY();
        setCornerRightUpX();
        setCornerRightUpY();
        setCornerRightDownX();
        setCornerRightDownY();
        setEmpty(empty);
    }


    private PApplet pApplet;


    private boolean destroyable;
    private boolean empty;

    private boolean border;
    private String theme;


    public boolean isEmpty() {
        return empty;
    }
    public boolean isBorder() {return border;}

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }


    public void setBorder(boolean border) {
        this.border = border;
        if (border) {
            setEmpty(false);
        }
    }


    private boolean clear;


}