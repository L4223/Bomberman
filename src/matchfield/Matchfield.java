package matchfield;

import processing.core.PApplet;
import main.Position;
import processing.core.PImage;

public class Matchfield extends Position {

    public Matchfield (PApplet pApplet) {
        super(0,0);
        this.fieldSize = 15;
        setHeight(pApplet.height);
        setWidth(pApplet.width);
        setFieldHeight();
        setFieldWidth();
        setpApplet(pApplet);
    }

    private PApplet pApplet;

    public void setpApplet(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public PApplet getpApplet() {
        return pApplet;
    }

    final private int[] startObstacle = {21,22,23,24,25,33,35,37,41,47,49,50,51,52,53,54,55,57,61,63,65,67,69,71,73,77,79,80,81,82,83,84,85,86,88,95,97,99,103,106,107,108,109,110,111,112,113,114,116,118,121,123,125,127,129,136,137,139,140,141,142,144,145,146,147,148,151,153,155,157,159,163,167,168,169,171,172,173,174,175,176,177,185,187,189,191,199,200,201,202,203,204,205};
//    final private int[] startObstacle = {17,22};

    final private int[] itemsFields = {22,23,18};

    public int[] getItemsFields() {
        return itemsFields;
    }

    public int[] getStartObstacle() {
        return startObstacle;
    }

    private boolean visible;
    private boolean taken;


    private int width;
    private int height;


    private int fieldWidth;
    private int fieldHeight;

    final private int fieldSize;

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

    public void setFree(boolean free) {
        this.free = free;
    }

    public int getFieldNumber(int positionX, int positionY) {
        int result = 0;
        int i = 0;
        for (int x = 0; x < getWidth(); x += getFieldWidth()) {
            for (int y = 0; y < getHeight(); y += getFieldHeight()) {
                    if (positionX >= x
                            && positionX <= x + getFieldWidth()
                            && positionY >= y
                            && positionY <= y + getFieldHeight() ) {
                        result = i;
                    }
                i++;
            }

        }
        return result;
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
