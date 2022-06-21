package main;

import matchfield.*;
import charactere.*;
import processing.core.PApplet;

public class NewGame {

    private int numberOfPlayers;
    private int numberOfOpponents;
    private AutoCharacter [] autoCharacters;
    private AutoCharacterController [] autoCharacterControllers;
    private AutoCharacterView autoCharacterView;
    private Bomberman [] bombermans;
    private BombermanController [] bombermanControllers;
    private BombermanView bombermanView;
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

        setBombermanView();
        setBombermanControllers();

        setAutoCharacterView();
        setAutoCharacterControllers();

        setFieldView();
        setFieldController();

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

    public void setField() {
        field = new Field[(int) Math.pow(matchfield.getFieldSize(),2)];
        int i = 0;
        for (int x = 0; x < getMatchfield().getWidth(); x += getMatchfield().getFieldWidth()) {
            for (int y = 0; y < getMatchfield().getHeight(); y += getMatchfield().getFieldHeight()) {
                field[i] = new Field(x, y, getMatchfield().getFieldWidth(), getMatchfield().getFieldHeight(), true, getpApplet());
                if (x == 0
                        || x == getMatchfield().getWidth() - getMatchfield().getFieldWidth()
                        || y == 0
                        || y == getMatchfield().getHeight() - getMatchfield().getFieldHeight()
                        || x % (getMatchfield().getFieldWidth() * 2) == 0 && y % (getMatchfield().getFieldHeight() * 2) == 0) {
                    field[i].setBorder(true);
                } else {
                    field[i].setBorder(false);
                    for (int j = 0; j < matchfield.getStartObstacle().length; j++) {
                        if(matchfield.getStartObstacle()[j] - 1 == i) field[i].setEmpty(false);
                    }
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

    private void setBombermanView () {
        bombermanView = new BombermanView();
    }

    //Die Getter von charactere.Bomberman-MVC
    public Bomberman getBomberman(int playernumber) {
        return bombermans[playernumber];
    }

    public BombermanController getBombermanController(int playernumber) {
        return bombermanControllers[playernumber];
    }

    public BombermanView getBombermanView() {
        return bombermanView;
    }

    //Die Setter von charactere.AutoCharacter-MVC
    private void setAutoCharacters() {
        this.autoCharacters = new AutoCharacter[numberOfOpponents];
    }

    private void setAutoCharacterControllers() {
        this.autoCharacterControllers = new AutoCharacterController[numberOfOpponents];
    }

    private void setAutoCharacterView() {
        this.autoCharacterView = new AutoCharacterView();
    }

    //Die Getter von charactere.AutoCharacter-MVC
    public AutoCharacter getAutoCharacter(int playernumber) {
        return autoCharacters[playernumber];
    }

    public AutoCharacterController getAutoCharacterController(int playernumber) {
        return autoCharacterControllers[playernumber];
    }

    public AutoCharacterView getAutoCharacterView() {
        return autoCharacterView;
    }


    //erstellt ein neues Spiel mit Standardwerten
    public void newGame () {
        if (getNumberOfPlayers() >= 0) {
            try {
                for (int i = 0; i < getNumberOfPlayers(); i++) {
                    bombermans[i] = new Bomberman(i, getMatchfield(), getpApplet());
                    bombermanControllers[i] = new BombermanController(getBomberman(i), getBombermanView(), getMatchfield(), getField(), getpApplet());
                }
                for (int i = 0; i < getNumberOfOpponents(); i++) {
                    autoCharacters[i] = new AutoCharacter(i,getMatchfield(),getpApplet());
                    autoCharacterControllers[i] = new AutoCharacterController(getAutoCharacter(i), getAutoCharacterView(), getMatchfield(), getField(), getpApplet());
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
