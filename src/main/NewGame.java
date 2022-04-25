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
    private PApplet pApplet;

    public NewGame (int numberOfPlayers, PApplet pApplet) {
        setNumberOfPlayers(numberOfPlayers);
        setNumberOfOpponents(4 - numberOfPlayers);
        setpApplet(pApplet);

        setBomberman();
        setAutoCharacters();
        setMatchfield();

        setBombermanView();
        setBombermanControllers();

        setAutoCharacterView();
        setAutoCharacterControllers();

        setMatchfieldView();
        setMatchfieldController();

        newGame();
    }

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
                    bombermanControllers[i] = new BombermanController(getBomberman(i), getBombermanView(), getpApplet());
                }
                for (int i = 0; i < getNumberOfOpponents(); i++) {
                    autoCharacters[i] = new AutoCharacter(i,getMatchfield(),getpApplet());
                    autoCharacterControllers[i] = new AutoCharacterController(getAutoCharacter(i), getAutoCharacterView(), getpApplet());
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
