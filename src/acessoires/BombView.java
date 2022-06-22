package acessoires;

import processing.core.PApplet;

public class BombView {
    public void draw (Bomb bomb, PApplet pApplet) {

            pApplet.image(bomb.getImage(),bomb.getPositionX() - 20, bomb.getPositionY() - 20, 100,100);


    }
}
