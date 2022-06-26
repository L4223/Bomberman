package main;

//Hauptklasse, Alles hat eine Position und eine Weite und Höhe
public class Position {
    private int positionX;
    private int positionY;
    private int imageWidth;
    private int imageHeight;

    //contructor der Position, Position muss immer der Pixel links oben sein, damit die Berechnungen und die updatePosition Funktion stimmen
    public Position (int positionX, int positionY) {
        setPositionXY(positionX,positionY);
        //Position wird anhand der gegebenen Infos für verschiedene Ecken gesetzt
        updatePosition();
    }

    //Getter und Setter der Position X und Y
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionX (){
        return positionX;
    }

    public int getPositionY () {
        return positionY;
    }

    public void setPositionXY(int positionX, int positionY) {
        setPositionX(positionX);
        setPositionY(positionY);
    }
    //Getter und Setter der Image Größe
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

    //Funktion damit die vier Ecken der Character berechnet werden können
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
    //Setter und Getter der vier verschiedenen Ecken und deren X und Y Positionen
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
}
