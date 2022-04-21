import processing.core.PApplet;

public class Character extends Position{
    private int playernumber;
    private int speed;
    private int heart;
    private int bomb;
    private int color;
    private int imageWidth;
    private int imageHeight;
    private Matchfield matchfield;


    public Matchfield getMatchfield() {
        return matchfield;
    }

    public int getPlayernumber () {
        return playernumber;
    }

    public Character(int playernumber, Matchfield matchfield, PApplet pApplet) {
        this.playernumber = playernumber;
        this.matchfield = matchfield;
        this.speed = 20;
        this.heart = 3;
        this.bomb = 1;
        this.imageWidth = 20;
        this.imageHeight = 20;
        this.color = colorSelection[playernumber];
        if (playernumber == 0) {
            setPositionXY(matchfield.getFieldWidth(), matchfield.getFieldHeight());
        }
        if (playernumber == 1) {
            setPositionXY(pApplet.width - matchfield.getFieldWidth() - this.imageWidth, pApplet.height - matchfield.getFieldHeight() - this.imageHeight);
        }
        if (playernumber == 2) {
            setPositionXY(pApplet.width - matchfield.getFieldWidth() - this.imageWidth, matchfield.getFieldHeight());
        }
        if (playernumber == 3) {
            setPositionXY(matchfield.getFieldWidth(), pApplet.height - matchfield.getFieldHeight() -this.imageHeight);
        }

    }

    //Farbe des Spielers, {rot, grün, blau, gelb}
    private final int [] colorSelection = {0xFFED3833, 0xFF6DED8A, 0xFF1645F5, 0xFFF0F14E};



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

    public int[] getColorSelection() {
        return colorSelection;
    }




    public int getColorSelection(int whichNumber) {
        return colorSelection [whichNumber];
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
