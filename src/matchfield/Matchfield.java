package matchfield;

import processing.core.PApplet;
import main.Position;

public class Matchfield extends Position {

    public Matchfield (PApplet pApplet) {
        this.fieldSize = 15;
        setHeight(pApplet.height);
        setWidth(pApplet.width);
        setFieldHeight();
        setFieldWidth();
    }

    private boolean visible;
    private boolean taken;


    private int width;
    private int height;


    private int fieldWidth;
    private int fieldHeight;

    private int fieldSize;

    private boolean free;


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        int pixelRestWidth = width % getFieldSize();
        this.width = width - pixelRestWidth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        int pixelRestHeight = height % getFieldSize();
        this.height = height - pixelRestHeight;
    }

    public int getFieldWidth() {
        return fieldWidth;
    }

    public void setFieldWidth() {
        this.fieldWidth = this.width / this.fieldSize;
    }

    public int getFieldHeight() {
        return fieldHeight;
    }

    public void setFieldHeight() {
        this.fieldHeight = this.height / this.fieldSize;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public boolean isTaken() {
        return taken;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setFree (boolean free) {
        this.free = free;
    }

    //checkt ob eine main.Position frei ist
    public boolean isFree(int positionX, int positionY) {
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
        return this.free;
    }
}
