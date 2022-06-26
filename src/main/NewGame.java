package main;

import acessoires.*;
import matchfield.*;
import charactere.*;

import processing.core.PApplet;

public class NewGame {
    private int numberOfPlayers;
    private int numberOfOpponents;
    private PApplet pApplet;
    private Bomberman[] bombermans;
    private AutoCharacter[] autoCharacters;
    private Matchfield matchfield;
    private Field[] field;
    private Item[] items;
    private Obstacle[] obstacles;
    private CharacterView characterView;
    private BombermanController[] bombermanControllers;
    private AutoCharacterController[] autoCharacterControllers;
    private FieldView fieldView;
    private FieldController fieldController;
    private ItemController itemController;
    private ObstacleController obstacleController;


    public NewGame(int numberOfPlayers, PApplet pApplet) {
        //Die Spieleranzahl wird gesetzt
        setNumberOfPlayers(numberOfPlayers);
        setNumberOfOpponents(4 - numberOfPlayers);

        setpApplet(pApplet);

        //Die Arrays für Spieler und Gegner werden erstellt
        setBomberman();
        setAutoCharacters();

        //Das Spielfeld wird erstellt
        setMatchfield();
        //Die einzelnen Felder werden erstellt und die Items und Obstacles
        setField();

        //Die Arrays für die Controller und die View der Charactere werden erstellt
        setCharacterView();
        setBombermanControllers();
        setAutoCharacterControllers();

        //Controller und View der Felder werden erstellt
        setFieldView();
        setFieldController();
        setItemController();
        setObstacleController();

        //Die Character und Character Controller Arrays werden befüllt
        newGame();
    }

    //erstellt ein neues Spiel mit Standardwerten, Fehler bei falscher Spieleranzahl
    public void newGame() {
        if (getNumberOfPlayers() >= 0) {
            try {
                //erstellt je nach Spieleranzahl die Anzahl der Spieler
                for (int i = 0; i < getNumberOfPlayers(); i++) {
                    bombermans[i] = new Bomberman(i, getMatchfield(), getpApplet());
                    bombermanControllers[i] = new BombermanController(getBomberman(i), getCharacterView(), getMatchfield(), getField(), getObstacles(), getpApplet());
                }
                //erstellt je nach Spieleramzahl die Anzahl der Gegner
                for (int i = 0; i < getNumberOfOpponents(); i++) {
                    autoCharacters[i] = new AutoCharacter(i, getMatchfield(), getpApplet());
                    autoCharacterControllers[i] = new AutoCharacterController(getAutoCharacter(i), getCharacterView(), getMatchfield(), getField(), getObstacles(), getpApplet());
                }
                //Falls die Spieleranzahl zu groß oder zu klein ist
            } catch (Exception exception) {
                PApplet.println("Fehler! Zwischen 1 - 4 Spieler zugelassen");
                numberOfPlayers = 0;
            }
        } else {
            PApplet.println("Fehler! Spieleranzahl muss positiv sein");
            numberOfPlayers = 0;
            newGame();
        }
    }

    /*Das Spielfeld wird erstellt. Items und Obstacles werden anhand von Array Listen aus der Klasse Matchfield erstellt*/
    public void setField() {
        //Die Arrays werden erstellt
        field = new Field[(int) Math.pow(matchfield.getFieldSize(), 2)];
        items = new Item[matchfield.getItemsFields().length];
        obstacles = new Obstacle[matchfield.getStartObstacle().length];
        int i = 0;
        for (int x = 0; x < getMatchfield().getWidth(); x += getMatchfield().getFieldWidth()) {
            for (int y = 0; y < getMatchfield().getHeight(); y += getMatchfield().getFieldHeight()) {
                // Ein Feld wird erstellt
                field[i] = new Field(i, x, y, getMatchfield().getFieldWidth(), getMatchfield().getFieldHeight(), true, getpApplet());
                field[i].setImage(field[i].getFloor());
                //Aus der Nummer der Liste wird das Feld mit der Nummer nochmal als Item erstellt
                for (int k = 0; k < matchfield.getItemsFields().length; k++) {
                    if (matchfield.getItemsFields()[k] == i) {
                        items[k] = new Item(field[i]);
                        items[k].setEmpty(false);
                        items[k].setImage(field[i].getItem());
                    }
                }
                //Aus der Nummer der Liste wird das Feld mit der Nummer nochmal als Hindernis erstellt
                for (int j = 0; j < matchfield.getStartObstacle().length; j++) {
                    if (matchfield.getStartObstacle()[j] == i) {
                        field[i].setEmpty(false);
                        field[i].setImage(field[i].getFloor());
                        obstacles[j] = new Obstacle(field[i]);
                        obstacles[j].setImage(field[i].getBrocken_brick());
                    }
                }
                //falls das Feld eine Wand ist, wird es Wand deklariert
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
    //Sonstige Getter und Setter der Matchfield/Field/Item/Obstacle Variablen
    public void setFieldController() {
        this.fieldController = new FieldController(getMatchfield(), getFieldView(), getField(), getpApplet());
    }
    public Field[] getField() {
        return field;
    }
    public FieldController getFieldController() {
        return fieldController;
    }
    public void setItemController() {
        this.itemController = new ItemController(getMatchfield(), getFieldView(), getItems(), getpApplet());
    }
    public void setObstacleController() {
        this.obstacleController = new ObstacleController(getMatchfield(), getFieldView(), getObstacles(), getpApplet());
    }
    public Item[] getItems() {
        return items;
    }
    public ItemController getItemController() {
        return itemController;
    }
    public Obstacle[] getObstacles() {
        return obstacles;
    }
    public ObstacleController getObstacleController() {
        return obstacleController;
    }
    public void setFieldView() {
        this.fieldView = new FieldView();
    }
    public FieldView getFieldView() {
        return fieldView;
    }
    private void setMatchfield() {
        matchfield = new Matchfield(getpApplet());
    }
    public Matchfield getMatchfield() {
        return matchfield;
    }


    //Getter und Setter der Processing und der Spieler bzw Gegneranzahl
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

    //Die Getter und Setter vom Character MVC
    private void setBomberman() {
        bombermans = new Bomberman[getNumberOfPlayers()];
    }
    private void setBombermanControllers() {
        bombermanControllers = new BombermanController[getNumberOfPlayers()];
    }
    public Bomberman getBomberman(int playernumber) {
        return bombermans[playernumber];
    }
    public BombermanController getBombermanController(int playernumber) {
        return bombermanControllers[playernumber];
    }
    private void setAutoCharacters() {
        this.autoCharacters = new AutoCharacter[getNumberOfOpponents()];
    }
    private void setAutoCharacterControllers() {
        this.autoCharacterControllers = new AutoCharacterController[getNumberOfOpponents()];
    }
    public AutoCharacter getAutoCharacter(int playernumber) {
        return autoCharacters[playernumber];
    }
    public AutoCharacterController getAutoCharacterController(int playernumber) {
        return autoCharacterControllers[playernumber];
    }
    private void setCharacterView() {
        this.characterView = new CharacterView();
    }
    public CharacterView getCharacterView() {
        return characterView;
    }
}
