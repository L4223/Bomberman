package main;

import charactere.Character;
import processing.core.PApplet;

public class Main extends PApplet {


    public static void main(String[] args) {
        PApplet.main("main.Main");
    }

    //Größe der Anzeige und Einstellung des Renderers
    public void settings() {
        // fullScreen funktioniert noch nicht
        size(900, 900, P2D);
    }

    //Variable neues Spiel
    private NewGame game;

    public void setup() {
        //Spieleranzahl wird bestimmt
        //Anzahl der Spieler
        int numberOfPlayers = 1;
        //Neues Spiel wird erstellt
        game = new NewGame(numberOfPlayers, this);
    }

    public void draw() {
        //zeichnet das Spielfeld
        game.getFieldController().setView();
        game.getItemController().setView();
        game.getObstacleController().setView();

        //updatet die Bewegung der Spieler und zeichnet sie
        for (int i = 0; i < game.getNumberOfPlayers(); i++) {
            int positionX = game.getBomberman(i).getPositionX();
            int positionY = game.getBomberman(i).getPositionY();
            int fieldNumber = game.getBomberman(i).getMatchfield().getFieldNumber(positionX, positionY);

            if (i == 0) {
                setFieldNumberBombermanOne(fieldNumber);
            }
            if (i == 1) {
                setFieldNumberBombermanTwo(fieldNumber);
            }
            if (getFieldHit()[i] == 1) {
                game.getBomberman(i).subHeart();
                getFieldHit()[i] = 0;
            }


            game.getBombermanController(i).movement();
            game.getBombermanController(i).updateView();
            if (game.getBomberman(i).isBombSet()) {
                for (int j = 0; j < game.getBomberman(i).getMaxNumberOfBombs(); j++) {
                    if (game.getBomberman(i).getBombs(j).getBomb().isPlaced()) {

                        game.getBomberman(i).getBombs(j).getBombController().setView();

                    }
                    if (game.getBomberman(i).getBombs(j).getBomb().isExploded()) {
                        setFieldHit((game.getBomberman(i).getBombs(j).getBombController().explosion(getFieldNumberBombermanOne(), getFieldNumberBombermanTwo(), getFieldNumberAutoCharacterOne(), getFieldNumberAutoCharacterTwo(), getFieldNumberAutoCharacterThree())));


                    }

                }
            }
        }


//      updatet die Bewegung der Bots und zeichnet sie
        for (int i = 0; i < game.getNumberOfOpponents(); i++) {
            int positionX = game.getAutoCharacter(i).getPositionX();
            int positionY = game.getAutoCharacter(i).getPositionY();
            int fieldNumber = game.getAutoCharacter(i).getMatchfield().getFieldNumber(positionX, positionY);

            if (i == 0) {
                setFieldNumberAutoCharacterOne(fieldNumber);
            }
            if (i == 1) {
                setFieldNumberAutoCharacterTwo(fieldNumber);
            }
            if (i == 2) {
                setFieldNumberAutoCharacterThree(fieldNumber);
            }

            if (getFieldHit()[i + 2] == 1) {
                game.getBomberman(i).subHeart();
                getFieldHit()[i + 2] = 0;
            }

            game.getAutoCharacterController(i).movement();
            game.getAutoCharacterController(i).updateView();
        }


    }


    //Funktion damit das Spiel per Punkt und nicht per ESC beendet wird
    public void keyPressed() {
        //ESC geht wird umgeschrieben und bricht nicht das Spiel ab
        if (key == ESC) {
            key = 0;
        }
        //Der Punkt bricht das Spiel ab
        if (key == '.') {
            key = ESC;
        }

    }

    //fieldHit ist ein Hilfsarray, was Informationen über die Spieler speichert ob sie getroffen worden sind
    private int[] fieldHit = new int[5];
    //Getter und Setter dazu
    public int[] getFieldHit() {
        return fieldHit;
    }

    public void setFieldHit(int[] fieldHit) {
        this.fieldHit = fieldHit;
    }

    //Hilfsvariablen die die FieldNummern auf denen sie gerade stehen der einzelnen Charaktere zwischenspeichern
    private int fieldNumberBombermanOne;
    private int fieldNumberBombermanTwo;
    private int fieldNumberAutoCharacterOne;
    private int fieldNumberAutoCharacterTwo;
    private int fieldNumberAutoCharacterThree;

    //Getter und Setter dazu
    public int getFieldNumberBombermanOne() {
        return fieldNumberBombermanOne;
    }

    public void setFieldNumberBombermanOne(int fieldNumberBombermanOne) {
        this.fieldNumberBombermanOne = fieldNumberBombermanOne;
    }

    public int getFieldNumberBombermanTwo() {
        return fieldNumberBombermanTwo;
    }

    public void setFieldNumberBombermanTwo(int fieldNumberBombermanTwo) {
        this.fieldNumberBombermanTwo = fieldNumberBombermanTwo;
    }

    public int getFieldNumberAutoCharacterOne() {
        return fieldNumberAutoCharacterOne;
    }

    public void setFieldNumberAutoCharacterOne(int fieldNumberAutoCharacterOne) {
        this.fieldNumberAutoCharacterOne = fieldNumberAutoCharacterOne;
    }

    public int getFieldNumberAutoCharacterTwo() {
        return fieldNumberAutoCharacterTwo;
    }

    public void setFieldNumberAutoCharacterTwo(int fieldNumberAutoCharacterTwo) {
        this.fieldNumberAutoCharacterTwo = fieldNumberAutoCharacterTwo;
    }

    public int getFieldNumberAutoCharacterThree() {
        return fieldNumberAutoCharacterThree;
    }

    public void setFieldNumberAutoCharacterThree(int fieldNumberAutoCharacterThree) {
        this.fieldNumberAutoCharacterThree = fieldNumberAutoCharacterThree;
    }
}







