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
//        setCornerLeftUpX();
//        setCornerLeftUpY();
//        setCornerLeftDownX();
//        setCornerLeftDownY();
//        setCornerRightUpX();
//        setCornerRightUpY();
//        setCornerRightDownX();
//        setCornerRightDownY();
        setEmpty(empty);
    }

    private int fieldNumber;

    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }


    public int getFieldNumber() {
        return this.fieldNumber;
    }

    //    public int getFieldNumber(int positionX, int positionY) {
//        int result = 0;
//        int i = 0;
//        forSchleife:
//        for (int x = getFieldWidth(); x < getWidth() - getFieldWidth(); x += getFieldWidth()) {
//            for (int y = getFieldHeight(); y < getHeight() - getFieldHeight(); y += getFieldHeight()) {
//                if (x % (getFieldWidth() * 2) == 0 && y % (getFieldHeight() * 2) == 0) {
//                    if (positionX > x
//                            && positionX < x + getFieldWidth()
//                            && positionY > y
//                            && positionY < y + getFieldHeight()) {
//                        result =  i;
//                        break forSchleife;
//                    } else {
//                        result = i;
//                    }
//                    i++;
//                }
//            }
//        }
//        return result;
//    }

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
        if (empty = true) setImage(getFloor());
    }


    public void setBorder(boolean border) {
        this.border = border;
        if (border) {
            setEmpty(false);
        }
    }




    private boolean clear;


}