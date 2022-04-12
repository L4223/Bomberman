public class Character extends Position{
    private int speed;
    private int heart;
    private int bomb;
    private int color;

    private int cornerLeftUpX;
    private int cornerLeftUpY;
    private int cornerRightUpX;
    private int cornerRightUpY;
    private int cornerLeftDownX;
    private int cornerLeftDownY;
    private int cornerRightDownX;
    private int cornerRightDownY;

    private int imageWidth;
    private int imageHeight;

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

    public int getCornerLeftUpX() {
        return cornerLeftUpX;
    }

    public void setCornerLeftUpX() {
        this.cornerLeftUpX = this.positionX;
    }

    public int getCornerLeftUpY() {
        return cornerLeftUpY;
    }

    public void setCornerLeftUpY() {
        this.cornerLeftUpY = this.positionY;
    }

    public int getCornerRightUpX() {
        return cornerRightUpX;
    }

    public void setCornerRightUpX() {
        this.cornerRightUpX = this.positionX + this.imageWidth;
    }

    public int getCornerRightUpY() {
        return cornerRightUpY;
    }

    public void setCornerRightUpY() {
        this.cornerRightUpY = this.positionY;
    }

    public int getCornerLeftDownX() {
        return cornerLeftDownX;
    }

    public void setCornerLeftDownX() {
        this.cornerLeftDownX = this.positionX;
    }

    public int getCornerLeftDownY() {
        return cornerLeftDownY;
    }

    public void setCornerLeftDownY() {
        this.cornerLeftDownY = this.positionY + this.imageHeight;
    }

    public int getCornerRightDownX() {
        return cornerRightDownX;
    }

    public void setCornerRightDownX() {
        this.cornerRightDownX = this.positionX + this.imageWidth;
    }

    public int getCornerRightDownY() {
        return cornerRightDownY;
    }

    public void setCornerRightDownY() {
        this.cornerRightDownY = this.positionY + this.imageHeight;
    }

    public int[] getColorSelection() {
        return colorSelection;
    }


    //Farbe des Spielers, {rot, grün, blau, gelb}
    private final int [] colorSelection = {0xFFED3833, 0xFF6DED8A, 0xFF1645F5, 0xFFF0F14E};

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


    //läuft in die gegebene Richtung
    public void left(int speed) {
        this.positionX = this.positionX - speed;
    }
    public void right(int speed) {
        this.positionX = this.positionX + speed;
    }
    public void down(int speed) {
        this.positionY = this.positionY + speed;
    }
    public void up(int speed) {
        this.positionY = this.positionY - speed;
    }

}
