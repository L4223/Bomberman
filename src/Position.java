

public class Position {
    private int positionX;
    private int positionY;

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void left() {
        this.positionX = positionX - 10;
    }
    public void right() {
        this.positionX = positionX + 10;
    }
    public void down() {
        this.positionY = positionY + 10;
    }
    public void up() {
        this.positionY = positionY - 10;
    }



}
