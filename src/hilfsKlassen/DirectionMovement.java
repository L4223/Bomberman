package hilfsKlassen;

import processing.core.PApplet;

public class DirectionMovement {
    String right;
    String left;
    String up;
    String down;
    String direction;
    String randomDirection;
    PApplet pApplet;

    //Hilfsklasse für Richtungen
    public DirectionMovement(PApplet pApplet) {
        setRight("right");
        setLeft("left");
        setUp("up");
        setDown("down");
        setpApplet(pApplet);
    }

    public DirectionMovement (String direction){
        setDirection(direction);
    }

    private void setpApplet(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    //gibt eine random Richtung zurück
    public String getRandomDirection () {
        int randomNumber = (int) pApplet.random(4);
        if (randomNumber == 0) randomDirection = getDown();
        if (randomNumber == 1) randomDirection = getUp();
        if (randomNumber == 2) randomDirection = getLeft();
        if (randomNumber == 3) randomDirection = getRight();
        return randomDirection;
    }

    //gibt eine randomRichtung zurück außer die eingegebene Richtung
    public String getRandomDirection (String except) {
        int randomNumber = (int) pApplet.random(4);
        if (randomNumber == 0) randomDirection = getDown();
        if (randomNumber == 1) randomDirection = getUp();
        if (randomNumber == 2) randomDirection = getLeft();
        if (randomNumber == 3) randomDirection = getRight();
        if (randomDirection == except) getRandomDirection(except);
        return randomDirection;
    }

    private void setRight(String right) {
        this.right = right;
    }

    private void setLeft(String left) {
        this.left = left;
    }

    private void setUp(String up) {
        this.up = up;
    }

    private void setDown(String down) {
        this.down = down;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }



    public String getRight() {
        return right;
    }

    public String getLeft() {
        return left;
    }

    public String getUp() {
        return up;
    }

    public String getDown() {
        return down;
    }
}
