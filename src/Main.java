import hilfsKlassen.Direction;
import processing.core.PApplet;

public class Main extends PApplet {


    public static void main(String[] args) {
        PApplet.main("Main");
    }

    //Größe der Anzeige und Einstellung des Renderers
    public void settings() {
//        fullScreen(2);
        size(900, 900, P2D);

    }


    int numberOfPlayers;
    NewGame newGame;
    Direction direction;
    int randomDirection;

    boolean start,pause, playground, gameover;





    public void setup() {

        //Spieleranzahl wird bestimmt
        numberOfPlayers = 4;
        newGame = new NewGame(numberOfPlayers, this);

        newGame.newGame();
        randomDirection = (int) random(4);


        // Bestimmt welcher Fenster angezeigt wird mit Fenster = true
        start = false;
        pause = false;
        playground = false;
        gameover = false;
    }











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
      newGame.getMatchfieldController().setMatchfield();
      newGame.getCharacterController(0).automovement(newGame.getBomberman()[0].getDirection());
      newGame.getCharacterController(0).automovement(newGame.getBomberman()[1].getDirection());
      newGame.getCharacterController(0).automovement(newGame.getBomberman()[2].getDirection());
      newGame.getCharacterController(0).automovement(newGame.getBomberman()[3].getDirection());
      printPosition(newGame.getBomberman()[0]);
//      newGame.getCharacterController(1).automovement(0);
//      newGame.getCharacterController(2).automovement(0);
//      newGame.getCharacterController(3).automovement(0);


      for (int i = 0; i <numberOfPlayers; i++) {
          newGame.getCharacterController(i).updateView();
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







