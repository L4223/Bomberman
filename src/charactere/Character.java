package charactere;

import processing.core.PApplet;
import matchfield.Matchfield;
import main.Position;

public class Character extends Position {
    final private int playernumber;
    private int speed;
    private int heart;
    private int bomb;
    private int color;
    private int imageWidth;
    private int imageHeight;
    final private Matchfield matchfield;


    public Matchfield getMatchfield() {
        return matchfield;
    }

    public int getPlayernumber () {
        return playernumber;
    }

    /* erstellt einen Charakter mit
    Geschwindigkeit: 5
    Herzen: 3
    Bomben: 1


    * */
    public Character(int playernumber, Matchfield matchfield, PApplet pApplet) {
        this.playernumber = playernumber;
        this.matchfield = matchfield;
        this.speed = 5;
        this.heart = 3;
        this.bomb = 1;
        this.imageWidth = pApplet.width / matchfield.getFieldSize() - (pApplet.width /100);
        this.imageHeight = pApplet.height / matchfield.getFieldSize() - (pApplet.height /100);




    }





    private int cornerLeftUpX;
    private int cornerLeftUpY;
    private int cornerRightUpX;
    private int cornerRightUpY;
    private int cornerLeftDownX;
    private int cornerLeftDownY;
    private int cornerRightDownX;
    private int cornerRightDownY;



    public void setPositionXY(int positionX, int positionY) {
        setPositionX(positionX);
        setPositionY(positionY);
    }

    public int getCornerLeftUpX() {
        return cornerLeftUpX;
    }

    public void setCornerLeftUpX() {
        this.cornerLeftUpX = getPositionX();
    }

    public int getCornerLeftUpY() {
        return cornerLeftUpY;
    }

    public void setCornerLeftUpY() {
        this.cornerLeftUpY = getPositionY();
    }

    public int getCornerRightUpX() {
        return cornerRightUpX;
    }

    public void setCornerRightUpX() {
        this.cornerRightUpX = getPositionX() + getImageWidth();
    }

    public int getCornerRightUpY() {
        return cornerRightUpY;
    }

    public void setCornerRightUpY() {
        this.cornerRightUpY = getPositionY();
    }

    public int getCornerLeftDownX() {
        return cornerLeftDownX;
    }

    public void setCornerLeftDownX() {
        this.cornerLeftDownX = getPositionX();
    }

    public int getCornerLeftDownY() {
        return cornerLeftDownY;
    }

    public void setCornerLeftDownY() {
        this.cornerLeftDownY = getPositionY() + getImageHeight();
    }

    public int getCornerRightDownX() {
        return cornerRightDownX;
    }

    public void setCornerRightDownX() {
        this.cornerRightDownX = getPositionX() + getImageWidth();
    }

    public int getCornerRightDownY() {
        return cornerRightDownY;
    }

    public void setCornerRightDownY() {
        this.cornerRightDownY = getPositionY() + getImageHeight();
    }






    public int getBomb() {
        return bomb;
    }

    public int getHeart() {
        return heart;
    }

    public int getSpeed() {
        return speed;
    }

    public int getColor() {
        return color;
    }

    public void setBomb(int bomb) {
        this.bomb = bomb;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }




}
