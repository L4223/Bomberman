package matchfield;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;




public class FieldView extends MatchfieldView{

    public void draw(Field[] field, PApplet pApplet) {


        for (int i = 0; i < field.length; i++) {
            pApplet.imageMode(PConstants.CORNER);




            pApplet.image(field[i].getImage(), field[i].getCornerLeftUpX(), field[i].getCornerLeftUpY());

            pApplet.text(pApplet.str(i),field[i].getCornerLeftDownX(), field[i].getCornerLeftDownY());
            }
        }
    }


