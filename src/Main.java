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
    Character bomberman[];
    CharacterController characterController[];
    Matchfield matchfield;
    Matchfield levelOne;
    MatchfieldView matchfieldView;
    MatchfieldController matchfieldController;
    CharacterView characterView;

    boolean start,pause, playground, gameover;





    public void setup() {

        //Spieleranzahl wird bestimmt
        numberOfPlayers = 4;

        newGame();

        // Bestimmt welcher Fenster angezeigt wird mit Fenster = true
        start = false;
        pause = false;
        playground = false;
        gameover = false;


    }

    public void newGame () {
        if (numberOfPlayers >= 0) {
            try {
                bomberman = new Character[numberOfPlayers];
                characterController = new CharacterController[numberOfPlayers];

                levelOne = new Matchfield(this);
                matchfield = levelOne;
                matchfieldView = new MatchfieldView();
                matchfieldController = new MatchfieldController(levelOne, matchfieldView, this);
                characterView = new CharacterView();


                for (int i = 0; i < numberOfPlayers; i++) {
                    bomberman[i] = new Character(i, matchfield, this);
                    characterController[i] = new CharacterController(bomberman[i], characterView, this);
                }
            } catch (Exception exception) {
                println("Fehler! Zwischen 1 - 4 Spieler zugelassen");
                numberOfPlayers = 0;
            }
        } else {
            println("Fehler! Spieleranzahl muss positiv sein");
            numberOfPlayers = 0;
        }
    }













    public void draw() {
      matchfieldController.setMatchfield();
      characterController[0].movement();
      characterController[1].movement();

      for (int i = 0; i < numberOfPlayers; i++) {
          characterController[i].updateView();
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







