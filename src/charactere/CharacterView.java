package charactere;

import processing.core.PApplet;
import processing.core.PConstants;

public class CharacterView {
    //Zeichnet die Charactere
    public void draw (Character character, PApplet pApplet) {
        pApplet.imageMode(PConstants.CORNERS);
        pApplet.image(character.getImage(),character.getCornerLeftUpX(), character.getCornerLeftUpY(), character.getCornerRightDownX(), character.getCornerRightDownY());
    }
}


