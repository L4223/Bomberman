package acessoires;

import matchfield.Field;
import processing.core.PApplet;

public class Item extends Field {

    public Item(Field field) {
        super(field.getFieldNumber(),field.getPositionX(), field.getPositionY(), field.getWidth(), field.getHeight(), field.isEmpty(), field.getpApplet());
    }

    public int moreHeart (int heart) {
        return heart + 1;
    }

    public int speedIncreaser (int speed) {
        return speed + 10;
    }

    public int bombIncreaser (int bombRadius) {
        return bombRadius + 5;
    }

    public int lessHeart (int heart) {
        return heart - 1;
    }

}
