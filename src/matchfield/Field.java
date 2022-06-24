package matchfield;

import processing.core.PApplet;

public class Field extends Matchfield{

    public Field (int positionX, int positionY, int width, int height, boolean empty, PApplet pApplet) {
        super(pApplet);

        setPositionXY(positionX,positionY);
        setImageWidth(width);
        setImageHeight(height);
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