public class Character extends Position{
    private int speed;
    private int heart;
    private int bomb;
    private int color;
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




}
