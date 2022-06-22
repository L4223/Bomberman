package charactere;

import processing.core.PApplet;

public class CharacterView {

    public void draw (Character character, PApplet pApplet) {
        pApplet.image(character.getImage(),character.getCornerLeftUpX() - 20, character.getCornerLeftUpY() - 20, 100,100);
    }
}


