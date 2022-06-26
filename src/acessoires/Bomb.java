package acessoires;//noch nicht benutzt

import charactere.Character;
import main.Position;
import matchfield.Field;
import processing.core.PApplet;
import processing.core.PImage;

public class Bomb extends Position {

    Field [] field;

    public Field [] getField() {
        return field;
    }

    public void setField(Field [] field) {
        this.field = field;
    }

    Obstacle[] obstacles;

    public Obstacle[] getObstacles() {
        return obstacles;
    }

    public void setObstacles(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    Character character;

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    private int bombRadius;

    public int getBombRadius() {
        return bombRadius;
    }

    public void setBombRadius(int bombRadius) {
        this.bombRadius = bombRadius;

    }

    public Bomb(PApplet pApplet) {
        super(0,0);
        setpApplet(pApplet);
        setImageHeight(60);
        setImageWidth(60);
        setPlaced(false);
        setImage(pApplet.loadImage("images/Bomb.png"));

    }

    private boolean exploded;

    public void setExploded(boolean exploded) {
        this.exploded = exploded;
    }

    public boolean isExploded() {
        return exploded;
    }

    private int fieldNumber;

    public int getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
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
        this.bombView = new BombView();
    }

    public BombController getBombController() {
        return bombController;
    }

}
