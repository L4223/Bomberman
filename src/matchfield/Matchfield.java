package matchfield;

import processing.core.PApplet;
import main.Position;

public class Matchfield extends Position {

    public Matchfield (PApplet pApplet) {
        super(0,0);
        this.fieldSize = 15;
        setHeight(pApplet.height);
        setWidth(pApplet.width);
        setFieldHeight();
        setFieldWidth();
    }

//    final private int[] startObstacle = {22,23,24,25,26,34,36,38,42,48,50,51,52,53,54,55,56,58,62,64,66,68,69,70,72,74,78,80,81,82,83,84,85,86,87,89,96,98,100,104,107,108,109,110,111,112,113,114,115,117,119,122,124,126,128,130,137,138,140,141,142,143,145,146,147,148,149,152,154,156,158,160,164,168,170,172,173,174,175,176,177,178,186,188,190,192,200,201,202,203,204,205,206};
    final private int[] startObstacle = {17,22};

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
