package hilfsKlassen;

import processing.core.PApplet;
public class Direction {
    String right;
    String left;
    String up;
    String down;
    String randomDirection;

    public Direction () {
        this.right = "right";
        this.left = "left";
        this.up = "up";
        this.down = "down";
    }

    public String getRandomDirection (int randomNumber) {
        if (randomNumber == 0) randomDirection = getDown();
        if (randomNumber == 1) randomDirection = getUp();
        if (randomNumber == 2) randomDirection = getLeft();
        if (randomNumber == 3) randomDirection = getRight();
        return randomDirection;
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
