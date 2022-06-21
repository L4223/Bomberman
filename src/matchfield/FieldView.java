package matchfield;

import processing.core.PApplet;

public class FieldView extends MatchfieldView{

    public void field(Field[] field, PApplet pApplet) {
        for (int i = 0; i < field.length; i++) {
            pApplet.noStroke();
            pApplet.fill(field[i].getColour().getRed(),field[i].getColour().getGreen(),field[i].getColour().getBlue() );
            pApplet.rect(field[i].getCornerLeftUpX(), field[i].getCornerLeftUpY(), field[i].getCornerRightDownX(), field[i].getCornerRightDownY());
            pApplet.fill(0);
            pApplet.text(pApplet.str(i),field[i].getCornerLeftUpX(), field[i].getCornerLeftUpY());
            }
        }
    }


