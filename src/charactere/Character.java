package charactere;

import processing.core.PApplet;
import matchfield.*;
import main.Position;

public class Character extends Position {
    final private int playernumber;
    private int speed;
    private int heart;
    private int bomb;
    private int color;

    final private Matchfield matchfield;





    public Matchfield getMatchfield() {
        return matchfield;
    }

    public int getPlayernumber () {
        return playernumber;
    }

    /* erstellt einen Charakter mit
    Geschwindigkeit: 5
    Herzen: 3
    Bomben: 1


    * */
    public Character(int playernumber, Matchfield matchfield, PApplet pApplet) {
        super(0,0);
        this.playernumber = playernumber;
        this.matchfield = matchfield;
        this.speed = 5;
        this.heart = 3;
        this.bomb = 1;
        setImageWidth(pApplet.width / matchfield.getFieldSize() - (pApplet.width /100));
        setImageHeight( pApplet.height / matchfield.getFieldSize() - (pApplet.height /100));




    }














    public int getBomb() {
        return bomb;
    }

    public int getHeart() {
        return heart;
    }

    public int getSpeed() {
        return speed;
    }

    public int getColor() {
        return color;
    }

    public void setBomb(int bomb) {
        this.bomb = bomb;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setColor(int color) {
        this.color = color;
    }






}
