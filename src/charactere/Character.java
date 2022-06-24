package charactere;

import acessoires.Bomb;
import processing.core.PApplet;
import matchfield.*;
import main.Position;
import processing.core.PImage;

public class Character extends Position {
    final private int playernumber;
    private int speed;
    private int heart;
    private int numberOfBombs;


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
        this.numberOfBombs = 1;
        this.bombCounter = 0;
        this.maxNumberOfBombs = 5;
        this.bombRadius = 2;
        setBombs();

        setBombSet();
        setImageWidth(pApplet.width / matchfield.getFieldSize());
        setImageHeight( pApplet.height / matchfield.getFieldSize());






    }

    private int maxNumberOfBombs;

    private Bomb[] bombs;

    public void setBombs() {
        this.bombs = new Bomb[maxNumberOfBombs];
        for (int i = 0; i < maxNumberOfBombs; i++) {
            bombs[i] = new Bomb(0, 0);
        }
    }

    public Bomb getBombs(int bombNumber) {
        return bombs[bombNumber];
    }

    public void setBomb(int numberOfBomb, int positionX, int positionY, int bombRadius, PApplet pApplet) {
        bombs[numberOfBomb].setPositionXY(positionX, positionY);
        bombs[numberOfBomb].updatePosition();
        bombs[numberOfBomb].setBombRadius(bombRadius);
        bombs[numberOfBomb].setPlaced();
        bombs[numberOfBomb].setpApplet(pApplet);
        bombs[numberOfBomb].setBombView();
        bombs[numberOfBomb].setBombController();
        pApplet.println(bombs[numberOfBomb].getCornerLeftUpX());



    }

    private int bombCounter;

    public int getBombCounter() {
        return bombCounter;
    }

//    public void setBombCounter(int bombCounter) {
//        this.bombCounter = bombCounter;
//    }

    public void addBombCounter() {
        this.bombCounter++;
    }

    public void subBombCounter() {
        this.bombCounter--;
    }

    private boolean bombSet;

    public boolean isBombSet() {
        return bombSet;
    }

    public void setBombSet() {
        this.bombSet = false;
    }

    public void setBombSet(boolean bombSet) {
        this.bombSet = bombSet;
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



    public void addNumberOfBombs() {
        this.numberOfBombs++;
    }

    public int getNumberOfBombs() {
        return numberOfBombs;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }








}
