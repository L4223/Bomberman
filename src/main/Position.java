package main;

public class Position {
    private int positionX;
    private int positionY;

    private int imageWidth;
    private int imageHeight;

    public Position (int positionX, int positionY) {
        setPositionXY(positionX,positionY);
        updatePosition();
    }


    public int getPositionX (){
        return positionX;
    }

    public int getPositionY () {
        return positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setPositionXY(int positionX, int positionY) {
        setPositionX(positionX);
        setPositionY(positionY);
    }

    private int cornerLeftUpX;
    private int cornerLeftUpY;
    private int cornerRightUpX;
    private int cornerRightUpY;
    private int cornerLeftDownX;
    private int cornerLeftDownY;
    private int cornerRightDownX;
    private int cornerRightDownY;

    private int midX;
    private int midY;

    public int getMidX() {
        return midX;
    }

    public void setMidX() {
        this.midX = getPositionX() + getImageWidth()/2;
    }

    public int getMidY() {
        return midY;
    }

    public void setMidY() {
        this.midY = getPositionY() + getImageHeight()/2;
    }

    public void updatePosition() {
        setCornerLeftUpX();
        setCornerLeftUpY();
        setCornerLeftDownX();
        setCornerLeftDownY();
        setCornerRightUpX();
        setCornerRightUpY();
        setCornerRightDownX();
        setCornerRightDownY();
        setMidX();
        setMidY();
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
