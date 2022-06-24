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
        numberOfPlayers = 1;
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



    public void draw() {

      //zeichnet das Spielfeld
//        game.getMatchfieldController().setMatchfield();



        game.getFieldController().setField();

      //updatet die Bewegung der Spieler und zeichnet sie
      for (int i = 0; i <game.getNumberOfPlayers(); i++) {
//          game.getBombermanController(i).movementOne();
          game.getBombermanController(i).movement();
          game.getBombermanController(i).updateView();
          if (game.getBomberman(i).isBombSet()) {
              for (int j = 0; j < game.getBomberman(i).getBombCounter(); j++) {
                  if (game.getBomberman(i).getBombs(j).getBomb().isPlaced()) {

                      game.getBomberman(i).getBombs(j).getBombController().setView();
                  }
              }
          }
      }
//      updatet die Bewegung der Bots und zeichnet sie
      for (int i = 0; i < game.getNumberOfOpponents(); i++) {
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







