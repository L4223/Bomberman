package charactere;

import acessoires.Bomb;
import acessoires.Obstacle;
import processing.core.PApplet;
import matchfield.*;
import main.Position;
import processing.core.PImage;

public class Character extends Position {
    private Bomb[] bombs;
    final private Matchfield matchfield;
    final private int playernumber;
    private int speed;
    private int heart;
    private int numberOfBombs;
    private int bombRadius;
    private int bombCounter;
    private final int maxNumberOfBombs;
    private boolean bombSet;
    private PImage image;
    private PApplet pApplet;



    /* erstellt einen Charakter mit
    Geschwindigkeit: 5
    Herzen: 3
    Bomben: 2
    Bombenradius: 2
    Tasche mit bis zu 5 Bomben
    */
    public Character(int playernumber, Matchfield matchfield, PApplet pApplet) {
        super(0,0);
        setpApplet(pApplet);
        this.playernumber = playernumber;
        this.matchfield = matchfield;
        this.speed = 5;
        this.heart = 3;
        this.numberOfBombs = 2;
        this.bombRadius = 2;
        this.bombCounter = 0;
        this.maxNumberOfBombs = 5;
        setBombs();
        setBombSet();
        setImageWidth(pApplet.width / matchfield.getFieldSize());
        setImageHeight( pApplet.height / matchfield.getFieldSize());
    }

    //Es wird für jeden Character eine neues BombenArray erstelt in welches bis zu fünf Bomben rein passen
    public void setBombs() {
        this.bombs = new Bomb[maxNumberOfBombs];
        for (int i = 0; i < maxNumberOfBombs; i++) {
            bombs[i] = new Bomb(getpApplet());
        }
    }
    public Bomb getBombs(int bombNumber) {
        return bombs[bombNumber];
    }
    //Eine Bombe wird erstellt mit allen nötigen Informationen
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
    public int getBombCounter() {
        return bombCounter;
    }
    //Es wird eine Zahl zum Counter dazugezählt, eine Bombe wird genutzt
    public void addBombCounter() {
        this.bombCounter++;
    }
    //Es wird eine Zahl vom Counter genommen, eine Bombe ist explodiert
    public void subBombCounter() {
        this.bombCounter--;
    }

    //Getter und Setter der Variablen
    public void setBombSet() {
        this.bombSet = false;
    }
    public void setBombSet(boolean bombSet) {
        this.bombSet = bombSet;
    }
    public boolean isBombSet() {
        return bombSet;
    }
    public Matchfield getMatchfield() {
        return matchfield;
    }
    public int getPlayernumber () {
        return playernumber;
    }
    //Ein Herz wird verloren
    public void subHeart() {
        this.heart--;
    }
    public int getHeart() {
        return heart;
    }
    public int getSpeed() {
        return speed;
    }
    public int getBombRadius ( ) {
        return bombRadius;
    }
    public int getMaxNumberOfBombs() {
        return maxNumberOfBombs;
    }
    public int getNumberOfBombs() {
        return numberOfBombs;
    }
    public void setpApplet(PApplet pApplet) {
        this.pApplet = pApplet;
    }
    public PApplet getpApplet() {
        return pApplet;
    }
    public PImage getImage() {
        return image;
    }
    public void setImage(PImage image) {
        this.image = image;
    }
}
