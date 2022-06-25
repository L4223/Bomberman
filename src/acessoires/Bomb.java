package acessoires;//noch nicht benutzt

import main.Position;
import processing.core.PApplet;
import processing.core.PImage;

public class Bomb extends Position {


    private int bombRadius;



    public void setBombRadius(int bombRadius) {
        this.bombRadius = bombRadius;

    }

    public Bomb(PApplet pApplet) {
        super(0,0);
        setpApplet(pApplet);
        setImageHeight(60);
        setImageWidth(60);
        setPlaced(false);
//        PImage image;
//        image = pApplet.loadImage("images/Bomb.png");
        setImage(pApplet.loadImage("images/Bomb.png"));

    }

    PImage image;

    public PImage getImage() {
        return image;
    }

    public void setImage(PImage image) {
        this.image = image;
    }

    PApplet pApplet;

    public void setpApplet(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public PApplet getpApplet() {
        return pApplet;
    }

    boolean placed;

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }

    public void setPlaced() {
        placed = true;
    }

    private BombController bombController;

    private BombView bombView;

    public void setBombController() {
        this.bombController = new BombController(getBomb(),getBombView(), getpApplet() );
    }

    public BombView getBombView() {
        return bombView;
    }

    public Bomb getBomb() {
        return this;
    }

    public void setBombView() {
        this.bombView = new BombView(getpApplet());
    }

    public BombController getBombController() {
        return bombController;
    }

}
