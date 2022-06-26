package acessoires;//noch nicht benutzt

import charactere.Character;
import main.Position;
import matchfield.Field;
import processing.core.PApplet;
import processing.core.PImage;

public class Bomb extends Position {
    private BombController bombController;
    private BombView bombView;
    private Character character;
    private Field [] field;
    private Obstacle[] obstacles;
    private PImage image;
    private int fieldNumber;
    private int bombRadius;
    boolean placed;
    private boolean exploded;
    private PApplet pApplet;



    public Bomb(PApplet pApplet) {
        super(0,0);
        setpApplet(pApplet);
        setImageHeight(60);
        setImageWidth(60);
        setPlaced(false);
        setImage(pApplet.loadImage("images/Bomb.png"));
    }

    public Bomb getBomb() {
        return this;
    }

    //Getter und Setter der Controller und View
    public void setBombController() {
        this.bombController = new BombController(getBomb(),getBombView(), getpApplet() );
    }
    public void setBombView() {
        this.bombView = new BombView();
    }
    public BombController getBombController() {
        return bombController;
    }
    public BombView getBombView() {
        return bombView;
    }

    //Getter und Setter der restlichen Variablen
    public Character getCharacter() {
        return character;
    }
    public void setCharacter(Character character) {
        this.character = character;
    }
    public void setField(Field [] field) {
        this.field = field;
    }
    public Field [] getField() {
        return field;
    }
    public void setObstacles(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }
    public Obstacle[] getObstacles() {
        return obstacles;
    }
    public PImage getImage() {
        return image;
    }
    public void setImage(PImage image) {
        this.image = image;
    }
    public int getFieldNumber() {
        return fieldNumber;
    }
    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }
    public void setBombRadius(int bombRadius) {
        this.bombRadius = bombRadius;

    }
    public int getBombRadius() {
        return bombRadius;
    }
    public void setExploded(boolean exploded) {
        this.exploded = exploded;
    }
    public boolean isExploded() {
        return exploded;
    }
    public void setPlaced(boolean placed) {
        this.placed = placed;
    }
    public void setPlaced() {
        placed = true;
    }
    public boolean isPlaced() {
        return placed;
    }
    public void setpApplet(PApplet pApplet) {
        this.pApplet = pApplet;
    }
    public PApplet getpApplet() {
        return pApplet;
    }
}
