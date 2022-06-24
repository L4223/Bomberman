package charactere;

import processing.core.PApplet;
import processing.core.PConstants;

public class CharacterView {

    public void draw (Character character, PApplet pApplet) {
        pApplet.imageMode(PConstants.CORNERS);
        pApplet.image(character.getImage(),character.getCornerLeftUpX(), character.getCornerLeftUpY(), character.getCornerRightDownX(), character.getCornerRightDownY());
    }
}


