package matchfield;

import processing.core.PApplet;
import processing.core.PImage;

public class Field extends Matchfield{
    private int fieldNumber;
    private PImage image;
    private boolean empty;
    private boolean border;

    /*Bilder werden als Final Gesetz und abgerufen falls gebraucht. Sollte eig. in die Matchfield
    * aber irgendwie hat das aus Processing gründen nicht geklappt*/
    private final PImage brick = getpApplet().loadImage("images/Brick.png");
    private final PImage floor = getpApplet().loadImage("images/floor.png");
    private final PImage brocken_brick = getpApplet().loadImage("images/broken_brick.png");
    private final PImage item = getpApplet().loadImage("images/item.png");
    public Field (int fieldNumber, int positionX, int positionY, int width, int height, boolean empty, PApplet pApplet) {
        super(pApplet);
        setPositionXY(positionX,positionY);
        setImageWidth(width);
        setImageHeight(height);
        setFieldNumber(fieldNumber);
        updatePosition();
        setEmpty(empty);
    }


    //Getter und Setter der Variablen
    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }
    public int getFieldNumber() {
        return this.fieldNumber;
    }
    public void setImage(PImage image) {
        this.image = image;
    }
    public PImage getImage() {
        return image;
    }
    //Wenn Bordeer dann ist Empty auch false
    public void setBorder(boolean border) {
        this.border = border;
        if (border) {
            setEmpty(false);
        }
    }
    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
    public boolean isBorder() {return border;}
    public boolean isEmpty() {
        return empty;
    }
    //Getter der Bilder
    public PImage getItem() {
        return item;
    }
    public PImage getBrick() {
        return brick;
    }
    public PImage getFloor() {
        return floor;
    }
    public PImage getBrocken_brick() {
        return brocken_brick;
    }
}