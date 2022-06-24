package acessoires;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class BombView {

    public BombView(PApplet pApplet) {
        setImage(pApplet.loadImage("images/Bomb.png"));
    }
    public void draw (Bomb bomb, PApplet pApplet) {
            pApplet.imageMode(PConstants.CENTER);
            pApplet.image(getImage(),bomb.getMidX(), bomb.getMidY(), bomb.getImageHeight(),bomb.getImageWidth());

//        pApplet.imageMode(PConstants.CORNERS);
//        pApplet.image(getImage(),bomb.getCornerLeftUpX(), bomb.getCornerLeftUpY(), bomb.getCornerRightDownX(), bomb.getCornerRightDownY());


    }

    PImage image;

    public PImage getImage() {
        return image;
    }

    public void setImage(PImage image) {
        this.image = image;
    }
}
