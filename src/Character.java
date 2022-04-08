public class Character extends Position{
    private int speed;
    private int heart;
    private int bomb;
    private String color;

    public int getBomb() {
        return bomb;
    }

    public int getHeart() {
        return heart;
    }

    public int getSpeed() {
        return speed;
    }

    public String getColor() {
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

    public void setColor(String color) {
        this.color = color;
    }


}
