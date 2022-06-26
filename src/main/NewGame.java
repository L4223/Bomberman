package main;

import acessoires.*;
import matchfield.*;
import charactere.*;

import processing.core.PApplet;

public class NewGame {

    private int numberOfPlayers;
    private int numberOfOpponents;
    private AutoCharacter [] autoCharacters;
    private AutoCharacterController [] autoCharacterControllers;
    private CharacterView characterView;
    private Bomberman [] bombermans;
    private BombermanController [] bombermanControllers;

    private Matchfield matchfield;
    private MatchfieldController matchfieldController;
    private MatchfieldView matchfieldView;







    private FieldController fieldController;

    private FieldView fieldView;
    private PApplet pApplet;

    public NewGame (int numberOfPlayers, PApplet pApplet) {
        setNumberOfPlayers(numberOfPlayers);
        setNumberOfOpponents(4 - numberOfPlayers);
        setpApplet(pApplet);

        setBomberman();
        setAutoCharacters();
        setMatchfield();
        setField();



        setCharacterView();
        setBombermanControllers();
        setAutoCharacterControllers();



        setFieldView();
        setFieldController();

        setItemView();
        setItemController();

        setObstacleView();
        setObstacleController();

        setMatchfieldView();
        setMatchfieldController();











        newGame();
    }

    private Field[] field;

    private void setpApplet(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public PApplet getpApplet() {
        return pApplet;
    }

    private void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getNumberOfOpponents() {
        return numberOfOpponents;
    }

    private void setNumberOfOpponents(int numberOfOpponents) {
        this.numberOfOpponents = numberOfOpponents;
    }

    // Die Setter von Matchfield.Matchfield-MVC
    private void setMatchfield () {
        matchfield = new Matchfield(getpApplet());
    }

    private void setMatchfieldController () {
        matchfieldController =  new MatchfieldController(getMatchfield(), getMatchfieldView(), getpApplet());
    }

    private void setMatchfieldView () {
        matchfieldView = new MatchfieldView();
    }

    //Die Getter von Matchfield.Matchfield-MVC
    public Matchfield getMatchfield() {
        return matchfield;
    }

    public MatchfieldController getMatchfieldController() {
        return matchfieldController;
    }

    public MatchfieldView getMatchfieldView() {
        return matchfieldView;
    }

    public Field[] getField() {
        return field;
    }

    private Item[] items;

    public Item[] getItems() {
        return items;
    }

    private Obstacle[] obstacles;

    public Obstacle[] getObstacles() {
        return obstacles;
    }

    public void setField() {
        field = new Field[(int) Math.pow(matchfield.getFieldSize(),2)];
        items = new Item[matchfield.getItemsFields().length];
        obstacles = new Obstacle[matchfield.getStartObstacle().length];
        int i = 0;
        for (int x = 0; x < getMatchfield().getWidth(); x += getMatchfield().getFieldWidth()) {
            for (int y = 0; y < getMatchfield().getHeight(); y += getMatchfield().getFieldHeight()) {
                field[i] = new Field(i, x, y, getMatchfield().getFieldWidth(), getMatchfield().getFieldHeight(), true, getpApplet());
                for (int k = 0; k < matchfield.getItemsFields().length; k++) {
                    if(matchfield.getItemsFields()[k] == i) {
                        items[k] = new Item(field[i]);
                        items[k].setImage(field[i].getItem());
                        items[k].setEmpty(false);
                    }
                }
                for (int j = 0; j < matchfield.getStartObstacle().length; j++) {
                    if(matchfield.getStartObstacle()[j] == i) {
                        field[i].setEmpty(false);
                        field[i].setImage(field[i].getFloor());
                        obstacles[j] = new Obstacle(field[i]);
                        obstacles[j].setImage(field[i].getBrocken_brick());
                    }
                }
                if (x == 0
                        || x == getMatchfield().getWidth() - getMatchfield().getFieldWidth()
                        || y == 0
                        || y == getMatchfield().getHeight() - getMatchfield().getFieldHeight()
                        || x % (getMatchfield().getFieldWidth() * 2) == 0 && y % (getMatchfield().getFieldHeight() * 2) == 0) {
                    field[i].setBorder(true);
                    field[i].setImage(field[i].getBrick());
                } else {
                    field[i].setBorder(false);


                }
                i++;
            }
        }
    }

    public FieldController getFieldController() {
        return fieldController;
    }

    public void setFieldController() {
        this.fieldController = new FieldController(getMatchfield(), getFieldView(), getField(), getpApplet());
    }

    private ObstacleView obstacleView;

    public ObstacleView getObstacleView() {
        return obstacleView;
    }

    public void setObstacleView() {
        this.obstacleView = new ObstacleView();
    }

    private ObstacleController obstacleController;

    public ObstacleController getObstacleController() {
        return obstacleController;
    }

    public void setObstacleController() {
        this.obstacleController = new ObstacleController(getMatchfield(), getObstacleView(), getObstacles(), getpApplet());
    }

    private ItemView itemView;

    public ItemView getItemView() {
        return itemView;
    }

    public void setItemView() {
        this.itemView = new ItemView();
    }

    private ItemController itemController;

    public void setItemController() {
        this.itemController = new ItemController(getMatchfield(), getItemView(), getItems(), getpApplet());
    }

    public void setItems(Item[] items) {
        this.items = items;
    }



    public ItemController getItemController() {
        return itemController;
    }

    public FieldView getFieldView() {
        return fieldView;
    }

    public void setFieldView() {
        this.fieldView = new FieldView();
    }

    //Die Setter von charactere.Bomberman-MVC
    private void setBomberman () {
        bombermans = new Bomberman[getNumberOfPlayers()];
    }

    private void setBombermanControllers () {
       bombermanControllers = new BombermanController[getNumberOfPlayers()];
    }



    //Die Getter von charactere.Bomberman-MVC
    public Bomberman getBomberman(int playernumber) {
        return bombermans[playernumber];
    }

    public BombermanController getBombermanController(int playernumber) {
        return bombermanControllers[playernumber];
    }



    //Die Setter von charactere.AutoCharacter-MVC
    private void setAutoCharacters() {
        this.autoCharacters = new AutoCharacter[getNumberOfOpponents()];
    }

    private void setAutoCharacterControllers() {
        this.autoCharacterControllers = new AutoCharacterController[getNumberOfOpponents()];
    }

    private void setCharacterView() {
        this.characterView = new CharacterView();
    }

    //Die Getter von charactere.AutoCharacter-MVC
    public AutoCharacter getAutoCharacter(int playernumber) {
        return autoCharacters[playernumber];
    }

    public AutoCharacterController getAutoCharacterController(int playernumber) {
        return autoCharacterControllers[playernumber];
    }

    public CharacterView getCharacterView() {
        return characterView;
    }


    //erstellt ein neues Spiel mit Standardwerten
    public void newGame () {
        if (getNumberOfPlayers() >= 0) {
            try {
                for (int i = 0; i < getNumberOfPlayers(); i++) {
                    bombermans[i] = new Bomberman(i, getMatchfield(), getpApplet());
                    bombermanControllers[i] = new BombermanController(getBomberman(i), getCharacterView(), getMatchfield(), getField(), getpApplet());
                }
                for (int i = 0; i < getNumberOfOpponents(); i++) {
                    autoCharacters[i] = new AutoCharacter(i,getMatchfield(),getpApplet());
                    autoCharacterControllers[i] = new AutoCharacterController(getAutoCharacter(i), getCharacterView(), getMatchfield(), getField(), getpApplet());
                }
            } catch (Exception exception) {
                pApplet.println("Fehler! Zwischen 1 - 4 Spieler zugelassen");
                numberOfPlayers = 0;
            }
        } else {
            PApplet.println("Fehler! Spieleranzahl muss positiv sein");
            numberOfPlayers = 0;
            newGame();
        }
    }




}
