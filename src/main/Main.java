package main;

import charactere.Character;
import processing.core.PApplet;

public class Main extends PApplet {


    public static void main(String[] args) {
        PApplet.main("main.Main");
    }

    //Größe der Anzeige und Einstellung des Renderers
    public void settings() {
//        fullScreen(2);
        size(900, 900, P2D);
    }

    //Anzahl der Spieler
    int numberOfPlayers;
    //Klasse Neues Spiel wird erstellt
    NewGame game;

    //booleans der verschiedenen Bildschirme
    boolean start,pause, playground, gameover;





    public void setup() {

        //Spieleranzahl wird bestimmt
        numberOfPlayers = 2;
        //Neues Spiel wird erstellt
        game = new NewGame(numberOfPlayers, this);





        // Bestimmt welcher Fenster angezeigt wird mit Fenster = true
        start = false;
        pause = false;
        playground = false;
        gameover = false;
    }










    //Hilfsfunktion falls man die main.Position des Characters wissen möchte
    public void printPosition (Character bomberman) {
        println("LinksObenX: " +
                  bomberman.getCornerLeftUpX() +
                "\nLinksObenY: " +
                        bomberman.getCornerLeftUpY() +
                        "\nLinksUntenX: " +
                        bomberman.getCornerLeftDownX() +
                        "\nLinksUntenY: " +
                        bomberman.getCornerLeftDownY() +
                        "\nRechtsObenX: " +
                        bomberman.getCornerRightUpX() +
                        "\nRechtsObenY: " +
                        bomberman.getCornerRightUpY() +
                        "\nRechtsUntenX: " +
                        bomberman.getCornerRightDownX() +
                        "\nRechtsUntenY: " +
                        bomberman.getCornerRightDownY());
    }


    private int heartBombermanOne;
    private int heartBombermanTwo;
    private int heartAutoCharacterOne;
    private int heartAutoCharacterTwo;
    private int heartAutoCharacterThree;

    public int getHeartBombermanOne() {
        return heartBombermanOne;
    }

    public void setHeartBombermanOne(int heartBombermanOne) {
        this.heartBombermanOne = heartBombermanOne;
    }

    public int getHeartBombermanTwo() {
        return heartBombermanTwo;
    }

    public void setHeartBombermanTwo(int heartBombermanTwo) {
        this.heartBombermanTwo = heartBombermanTwo;
    }

    public int getHeartAutoCharacterOne() {
        return heartAutoCharacterOne;
    }

    public void setHeartAutoCharacterOne(int heartAutoCharacterOne) {
        this.heartAutoCharacterOne = heartAutoCharacterOne;
    }

    public int getHeartAutoCharacterTwo() {
        return heartAutoCharacterTwo;
    }

    public void setHeartAutoCharacterTwo(int heartAutoCharacterTwo) {
        this.heartAutoCharacterTwo = heartAutoCharacterTwo;
    }

    public int getHeartAutoCharacterThree() {
        return heartAutoCharacterThree;
    }

    public void setHeartAutoCharacterThree(int heartAutoCharacterThree) {
        this.heartAutoCharacterThree = heartAutoCharacterThree;
    }

    private int fieldNumberBombermanOne;
    private int fieldNumberBombermanTwo;
    private int fieldNumberAutoCharacterOne;
    private int fieldNumberAutoCharacterTwo;
    private int fieldNumberAutoCharacterThree;


    private int [] fieldHit = new int[5];

    public int[] getFieldHit() {
        return fieldHit;
    }

    public void setFieldHit(int [] fieldHit) {
        this.fieldHit = fieldHit;
    }

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

    public void draw() {


      //zeichnet das Spielfeld
//        game.getMatchfieldController().setMatchfield();



        game.getFieldController().setView();
        game.getItemController().setView();
        game.getObstacleController().setView();

      //updatet die Bewegung der Spieler und zeichnet sie
      for (int i = 0; i <game.getNumberOfPlayers(); i++) {
          int positionX = game.getBomberman(i).getPositionX();
          int positionY = game.getBomberman(i).getPositionY();;
          int fieldNumber = game.getBomberman(i).getMatchfield().getFieldNumber(positionX, positionY);
          int heart = game.getBomberman(i).getHeart();

          if (i == 0) {
              setFieldNumberBombermanOne(fieldNumber);
              setHeartBombermanOne(heart);
          }
          if (i == 1) {
              setFieldNumberBombermanTwo(fieldNumber);
              setHeartBombermanTwo(heart);
          }
          if (getFieldHit()[i] == 1) {
              game.getBomberman(i).subHeart();
              getFieldHit()[i] = 0;
          }


          game.getBombermanController(i).movement();
          game.getBombermanController(i).updateView();
          println(heart);
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
          int positionY = game.getAutoCharacter(i).getPositionY();;
          int fieldNumber = game.getAutoCharacter(i).getMatchfield().getFieldNumber(positionX, positionY);
          int heart = game.getAutoCharacter(i).getHeart();

          if (i == 0) {
              setFieldNumberAutoCharacterOne(fieldNumber);
              setHeartAutoCharacterOne(heart);
          }
          if (i == 1) {
              setFieldNumberAutoCharacterTwo(fieldNumber);
              setHeartAutoCharacterTwo(heart);
          }
          if (i == 2) {
              setFieldNumberAutoCharacterThree(fieldNumber);
              setHeartAutoCharacterThree(heart);
          }

          if (getFieldHit()[i+2] == 1) game.getAutoCharacter(i).subHeart();

          game.getAutoCharacterController(i).movement();
          game.getAutoCharacterController(i).updateView();
      }


    }






















    public void keyPressed() {
        //Enter geht von Start ins Spiel
        if (start && key == ENTER) {
            start = false;
            playground = true;
        }
        //ESC geht wird umgeschrieben und bricht nicht das Spiel ab
        if (key == ESC) {
            key = 0;
        }
        //ESC geht vom Spielfeld in die Pause
        if (playground || pause && key == 0) {
            playground = !playground;
            pause = !pause;
        }
        //Der Punkt bricht das Spiel ab
        if (key == '.') {
            key = ESC;
        }

    }






    //zeigt schwarzen Bildschirm und ein "Start"
    public void start() {
        if (start) {
            background(0);
            textSize(height / 4);
            fill(255);
            text("Start", height / 2, width / 2);
        }
    }

    //zeigt schwarzen Bildschirm und ein "Game"
    public void playground() {
        if (playground) {
            background(0);
            textSize(height / 4);
            fill(255);
            text("Game", height / 2, width / 2);
        }
    }

    //zeigt schwarzen Bildschirm und ein "Pause"
    public void pause() {
        if (pause) {
            background(0);
            textSize(height / 4);
            fill(255);
            text("Pause", height / 2, width / 2);
        }
    }

    //zeigt schwarzen Bildschirm und ein "GAME OVER"
    public void gameover() {
        if (gameover) {
            background(0);
            textSize(height / 4);
            fill(255);
            text("GAME OVER", height / 2, width / 2);
        }
    }

}







