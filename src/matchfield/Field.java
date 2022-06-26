package matchfield;

import processing.core.PApplet;
import processing.core.PImage;

public class Field extends Matchfield{

    public Field (int fieldNumber, int positionX, int positionY, int width, int height, boolean empty, PApplet pApplet) {
        super(pApplet);

        setPositionXY(positionX,positionY);
        setImageWidth(width);
        setImageHeight(height);
        setFieldNumber(fieldNumber);
        updatePosition();
        setEmpty(empty);
    }

    private int fieldNumber;

    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }


    public int getFieldNumber() {
        return this.fieldNumber;
    }


    private final PImage brick = getpApplet().loadImage("images/Brick.png");
    private final PImage floor = getpApplet().loadImage("images/floor.png");
    private final PImage brocken_brick = getpApplet().loadImage("images/broken_brick.png");

    private final PImage item = getpApplet().loadImage("images/item.png");

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

    private PImage image;

    public PImage getImage() {
        return image;
    }

    public void setImage(PImage image) {
        this.image = image;
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