package charactere;

import acessoires.Bomb;
import acessoires.Obstacle;
import processing.core.PApplet;
import matchfield.*;
import main.Position;
import processing.core.PImage;

public class Character extends Position {
    final private int playernumber;
    private int speed;
    private int heart;

    public int getHeart() {
        return heart;
    }

    public void addHeart() {
        this.heart++;
    }

    public void subHeart() {
        this.heart--;
    }



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
        setpApplet(pApplet);
        this.playernumber = playernumber;
        this.matchfield = matchfield;
        this.speed = 5;
        this.heart = 3;
        this.numberOfBombs = 5;
        this.bombCounter = 0;
        this.maxNumberOfBombs = 5;
        this.bombRadius = 2;
        setBombs();

        setBombSet();
        setImageWidth(pApplet.width / matchfield.getFieldSize());
        setImageHeight( pApplet.height / matchfield.getFieldSize());






    }

    public int getMaxNumberOfBombs() {
        return maxNumberOfBombs;
    }

    PApplet pApplet;

    public void setpApplet(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public PApplet getpApplet() {
        return pApplet;
    }

    private final int maxNumberOfBombs;

    private Bomb[] bombs;

    public void setBombs() {
        this.bombs = new Bomb[maxNumberOfBombs];
        for (int i = 0; i < maxNumberOfBombs; i++) {
            bombs[i] = new Bomb(getpApplet());
        }
    }

    public Bomb getBombs(int bombNumber) {
        return bombs[bombNumber];
    }

    public void setBomb(int numberOfBomb, int positionX, int positionY, int bombRadius, int fieldNumber, Field [] field, Obstacle [] obstacles, PApplet pApplet) {
        bombs[numberOfBomb].setPositionXY(positionX, positionY);
        bombs[numberOfBomb].updatePosition();
        bombs[numberOfBomb].setBombRadius(bombRadius);
        bombs[numberOfBomb].setFieldNumber(fieldNumber);
        bombs[numberOfBomb].setField(field);
        bombs[numberOfBomb].setObstacles(obstacles);
        bombs[numberOfBomb].setPlaced();
        bombs[numberOfBomb].setpApplet(pApplet);
        bombs[numberOfBomb].setCharacter(this);
        bombs[numberOfBomb].setBombView();
        bombs[numberOfBomb].setBombController();




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
