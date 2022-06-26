package matchfield;

import processing.core.PApplet;
import processing.core.PConstants;


public class FieldView {

    //Die Methode zeichnet die Felder mit Hilfe von Processing
    public void draw(Field[] field, PApplet pApplet) {
        for (Field value : field) {
            pApplet.imageMode(PConstants.CORNER);
            pApplet.image(value.getImage(), value.getCornerLeftUpX(), value.getCornerLeftUpY());
            /*Auskommentieren wenn man die Nummern der Felder sehen möchte */
            //pApplet.text(pApplet.str(i),field[i].getCornerLeftDownX(), field[i].getCornerLeftDownY());
        }
        }
    }


