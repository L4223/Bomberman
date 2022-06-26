package acessoires;

import matchfield.Field;
import processing.core.PApplet;

public class Obstacle extends Field {
    public Obstacle(Field field) {
        super(field.getFieldNumber(), field.getPositionX(), field.getPositionY(), field.getWidth(), field.getHeight(), field.isEmpty(), field.getpApplet());
    }
}
