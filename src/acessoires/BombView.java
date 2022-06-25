package acessoires;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class BombView {


    public void draw (Bomb bomb, PApplet pApplet) {
            pApplet.imageMode(PConstants.CENTER);
            pApplet.image(bomb.getImage(),bomb.getMidX(), bomb.getMidY(), bomb.getImageHeight(),bomb.getImageWidth());



    }

}
