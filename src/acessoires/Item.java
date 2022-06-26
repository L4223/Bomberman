package acessoires;

import matchfield.Field;
import processing.core.PApplet;

public class Item extends Field {

    //Das Field wird erstellt, hat aber noch keine Funktion
    public Item(Field field) {
        super(field.getFieldNumber(),field.getPositionX(), field.getPositionY(), field.getWidth(), field.getHeight(), field.isEmpty(), field.getpApplet());
    }
}
