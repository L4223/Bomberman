package matchfield;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;




public class FieldView extends MatchfieldView{

    public void field(Field[] field, PApplet pApplet) {
        PImage brick;
        brick = pApplet.loadImage("images/brick.png");

        PImage broken_brick;
        broken_brick = pApplet.loadImage("images/broken_brick.png");

        PImage floor;
        floor = pApplet.loadImage("images/floor.png");

        for (int i = 0; i < field.length; i++) {
            pApplet.imageMode(PConstants.CORNER);



            if (field[i].isBorder()) {
                pApplet.image(brick, field[i].getCornerLeftUpX(), field[i].getCornerLeftUpY());
            }

            if (!field[i].isEmpty() && !field[i].isBorder()) {
                pApplet.image(broken_brick, field[i].getCornerLeftUpX(), field[i].getCornerLeftUpY());
            }

            if (field[i].isEmpty()) {
                pApplet.image(floor, field[i].getCornerLeftUpX(), field[i].getCornerLeftUpY());
            }
            pApplet.text(pApplet.str(i),field[i].getCornerLeftDownX(), field[i].getCornerLeftDownY());
            }
        }
    }


