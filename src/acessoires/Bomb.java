package acessoires;//noch nicht benutzt

import main.Position;
import processing.core.PApplet;
import processing.core.PImage;

public class Bomb extends Position {


    private int bombRadius;



    public void setBombRadius(int bombRadius) {
        this.bombRadius = bombRadius;
    }

    public Bomb(int positionX, int positionY, int bombRadius, PApplet pApplet) {
        super(positionX, positionY);
        setImage(pApplet.loadImage("images/Bomb.png"));
        setpApplet(pApplet);
        setBombRadius(bombRadius);

    }

    PApplet pApplet;

    public PApplet getpApplet() {
        return pApplet;
    }

    public void setpApplet(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    PImage image;

    public PImage getImage() {
        return image;
    }

    public void setImage(PImage image) {
        this.image = image;
    }




}
