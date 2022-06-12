package matchfield;

import main.Position;
import processing.core.PApplet;
import hilfsKlassen.Colour;

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

    public PApplet getpApplet() {
        return pApplet;
    }

    public void setpApplet(PApplet pApplet) {
        this.pApplet = pApplet;
    }





    private Field[] field;



    private boolean destroyable;
    private boolean empty;

    private boolean border;
    private String theme;

    private Colour colour;


    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }




    public boolean isDestroyable() {
        return destroyable;
    }

    public boolean isEmpty() {
        return empty;
    }
    public boolean isBorder() {return border;}

    public String getTheme() {
        return theme;
    }

    public void setDestroyable(boolean destroyable) {
        this.destroyable = destroyable;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
        if (!empty && !(getBorder())) setColour(colourNotEmpty);
        if (empty) setColour(colourFree);
    }

    public boolean getBorder() {
        return border;
    }



    public void setBorder(boolean border) {
        this.border = border;
        if (border) {
            setEmpty(false);
            setColour(colourBorder);
        }
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    final private Colour colourFree = new Colour(0,0,255);
    final private Colour colourBorder = new Colour(255,255,255);
    final private Colour colourNotEmpty = new Colour(255,125,125);

    private boolean clear;

    public void setClear(boolean clear) {
        this.clear = clear;
    }

    //checkt ob eine main.Position frei ist
    public boolean isClear(int positionX, int positionY) {
        //schneller check ob der Rand betroffen ist
        if (positionX < getFieldWidth()
                || positionX > getWidth() - getFieldWidth()
                || positionY < getFieldHeight()
                || positionY > getHeight() - getFieldHeight()) {
            setFree(false);
        } else {
            //check ob die Felder in der Mitte getroffen werden mit Hilfe einer for-Schleife, gleich wie beim zeichnen
            forSchleife:
            for (int x = getFieldWidth(); x < getWidth() - getFieldWidth(); x += getFieldWidth()) {
                for (int y = getFieldHeight(); y < getHeight() - getFieldHeight(); y += getFieldHeight()) {

                    if (x % (getFieldWidth() * 2) == 0 && y % (getFieldHeight() * 2) == 0) {
                        if (positionX > x
                                && positionX < x + getFieldWidth()
                                && positionY > y
                                && positionY < y + getFieldHeight() ) {
                            setFree(false);
                            break forSchleife;
                        } else {
                            setFree(true);
                        }
                    }
                }
            }
        }
        return this.clear;
    }








}