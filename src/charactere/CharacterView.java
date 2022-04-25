package charactere;

import processing.core.PApplet;

public class CharacterView {

    public void draw (Character bomberman, PApplet pApplet) {
        pApplet.rectMode(pApplet.CORNERS);
        pApplet.noStroke();
        pApplet.fill(bomberman.getColor());
        pApplet.rect(bomberman.getCornerLeftUpX(), bomberman.getCornerLeftUpY(), bomberman.getCornerRightDownX(), bomberman.getCornerRightDownY());
    }
}
