

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

    //läuft in die gegebene Richtung
    public void left(int speed) {
        this.positionX = positionX - speed;
    }
    public void right(int speed) {
        this.positionX = positionX + speed;
    }
    public void down(int speed) {
        this.positionY = positionY + speed;
    }
    public void up(int speed) {
        this.positionY = positionY - speed;
    }



}
