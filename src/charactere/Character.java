package charactere;

import processing.core.PApplet;
import matchfield.*;
import main.Position;
import processing.core.PImage;

public class Character extends Position {
    final private int playernumber;
    private int speed;
    private int heart;
    private int bomb;


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
        this.bombRadius = 2;
        setImageWidth(pApplet.width / matchfield.getFieldSize() - (pApplet.width /100));
        setImageHeight( pApplet.height / matchfield.getFieldSize() - (pApplet.height /100));




    }






    PImage image;


    public PImage getImage() {
        return image;
    }

    public void setImage(PImage image) {
        this.image = image;
    }



    public int getBombRadius ( ) {
        return bombRadius;
    }

    private int bombRadius;




    public int getSpeed() {
        return speed;
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








}
