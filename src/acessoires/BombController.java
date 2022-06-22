package acessoires;

import processing.core.PApplet;

public class BombController {
    public BombController(Bomb bomb, BombView view, PApplet pApplet) {
        this.bomb = bomb;
        this.view = view;
        this.pApplet = pApplet;
        setView();
    }

    final private Bomb bomb;
    final private BombView view;
    final private  PApplet pApplet;

    public Bomb getBomb() {
        return bomb;
    }

    public PApplet getpApplet() {
        return pApplet;
    }

    public void setView () {
        view.draw(getBomb(),getpApplet());
    }

}
