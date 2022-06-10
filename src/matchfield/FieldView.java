package matchfield;

import processing.core.PApplet;

public class FieldView {

    public void field(Matchfield matchfield, PApplet pApplet) {
        for (int i = 0; i < 225; i++) {
            pApplet.noStroke();
            pApplet.fill(0,0,0);
            if (i == 16) pApplet.fill(255,0,0);
            if (i == 1) pApplet.fill(0,255,0);
            if (i == 2) pApplet.fill(0,0,255);
            if (i == 3) pApplet.fill(125,0,0);
            if (i == 4) pApplet.fill(0,125,0);
            if (i == 5) pApplet.fill(0,0,125);
            if (i == 6) pApplet.fill(255,255,255);
            if (i == 7) pApplet.fill(125,125,125);
            if (i == 8) pApplet.fill(1,50,60);
            if (i == 9) pApplet.fill(1,80,90);
            if (i == 10) pApplet.fill(100,80,90);

            pApplet.rect(matchfield.getField()[i].getStartPositionX(), matchfield.getField()[i].getStartPositionY(), matchfield.getField()[i].getEndPositionX(), matchfield.getField()[i].getEndPositionY());

        }
    }
}
