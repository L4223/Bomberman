package main;

import acessoires.Bomb;
import acessoires.BombController;
import acessoires.BombView;
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
                        if(matchfield.getStartObstacle()[j] == i) field[i].setEmpty(false);
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

    private Bomb bomb;

    private BombController bombController;

    private BombView bombView;

    public Bomb getBomb() {
        return bomb;
    }

    private boolean bombPlaced;

    public boolean isBombPlaced() {
        return bombPlaced;
    }

    public void setBombPlaced() {
        this.bombPlaced = false;
    }

    public void setBombPlaced(boolean bombPlaced) {
        this.bombPlaced = bombPlaced;
    }

//    public void setNumberOfbombs() {
//        int positionX = 0;
//        int positionY = 0;
//        int bombRadius = 0;
//        for (int i = 0; i < getNumberOfPlayers(); i++) {
//            if (getBomberman(i).isBombSet()) {
//                setBombPlaced(getBomberman(i).isBombSet());
//                positionX = getField()[getMatchfield().getFieldNumber(getBomberman(i).getPositionX(), getBomberman(i).getPositionY())].getMidX();
//                positionY = getField()[getMatchfield().getFieldNumber(getBomberman(i).getPositionX(), getBomberman(i).getPositionY())].getMidY();
//                bombRadius = getBomberman(i).getBombRadius();
//                getBomberman(i).setBombSet();
//
//
//            }
//
//        }
//        for (int i = 0; i < getNumberOfPlayers(); i++) {
//            if (autoCharacters[i].isBombSet()) {
//                setBombPlaced(autoCharacters[i].isBombSet());
//                positionX = autoCharacters[i].getMidX();
//                positionY = autoCharacters[i].getMidY();
//                bombRadius = autoCharacters[i].getBombRadius();
//            }
//            if (isBombPlaced()) {
//                setShowBomb(true);
//                this.bomb = new Bomb(positionX, positionY, bombRadius, getpApplet());
//                this.bombView = new BombView();
//                this.bombController = new BombController(getBomb(), getBombView(), getpApplet());
//                setBombPlaced(false);
////                pApplet.println(isBombPlaced());
//            }
//        }
//    }

    boolean showBomb;

    public boolean isShowBomb() {
        return showBomb;
    }

    public void setShowBomb(boolean showBomb) {
        this.showBomb = showBomb;
    }

    public BombController getBombController() {
        return bombController;
    }

//    public void setBombController() {
//        this.bombController = new BombController();
//    }

    public BombView getBombView() {
        return bombView;
    }

//    public void setBombView() {
//        this.bombView = new BombView();
//    }
}
