package hilfsKlassen;

import processing.core.PApplet;

import java.util.Objects;

public class DirectionMovement {
    private String right;
    private String left;
    private String up;
    private String down;
    private String direction;
    private String randomDirection;
    private PApplet pApplet;

    //Hilfsklasse für Richtungen
    public DirectionMovement(PApplet pApplet) {
        setRight();
        setLeft();
        setUp();
        setDown();
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
        if (Objects.equals(randomDirection, except)) getRandomDirection(except);
        return randomDirection;
    }
    //Setter und Getter der Richtungen
    private void setRight() {
        this.right = "right";
    }
    private void setLeft() {
        this.left = "left";
    }
    private void setUp() {
        this.up = "up";
    }
    private void setDown() {
        this.down = "down";
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
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String getDirection() {
        return direction;
    }
}
