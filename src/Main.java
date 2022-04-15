import processing.core.PApplet;

public class Main extends PApplet {

    private MatchfieldView matchfieldView;
    private CharacterView characterView;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    //Größe der Anzeige und Einstellung des Renderers
    public void settings() {
//        fullScreen(2);
        size(900, 900, P2D);

    }


    public void setup() {
        matchfieldView = new MatchfieldView();
        characterView = new CharacterView();


/*        //bestimmt die Größe des Bildes
        imageWidth = 20;
        imageHeight = 20;
        //erstellt neues Spiel mit Anzahl der Spieler
        newGame(4);


        // Bestimmt welcher Fenster angezeigt wird mit Fenster = true
        start = false;
        pause = false;
        playground = false;
        gameover = false;
        println(levelOne.getFieldHeight());


        // zeichnet Spielfeld*/


    }

    public void draw() {
/*        //lässt die Spieler bewegen
//        movement(player[0]);
        //zeichnet Spielfeld neu


        rectMode(CORNERS);
        noStroke();
        matchfield();
        movement();

        println("Position X = " + player[0].getPositionX() + "PositionY = " + player[0].getPositionY());


        //zeichnet Spieler in enstprechender Farbe


        //zeichnet entsprechend aktivierten Bildschirm
        start();
        pause();
        playground();
        gameover();*/


    }



/*
    // Variablen für Bildschirm
    boolean start, pause, playground, gameover;
    //Die Maße eines Feldes

    //Array der Spieler
    Character[] player = new Character[4];

    Matchfield levelOne = new Matchfield();


    //Die Maße des Bildes
    int imageWidth;
    int imageHeight;
    //pixelReste












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



    // erstellt die Charactere eines neuen Spiel mit Anzahl der Spieler und weißt Ihnen die Anzahl der Bomben, der Leben, die Farbe, die Geschwindigkeit und Position zu.
    public void newGame(int numberOfPlayer) {


        levelOne.setFieldSize(15);
        levelOne.setWidth(width);
        levelOne.setHeight(height);
        levelOne.setFieldWidth();
        levelOne.setFieldHeight();


        for (int i = 0; i < numberOfPlayer; i++) {


            player[i] = new Character();

            player[i].setFieldSize(levelOne.getFieldSize());
            player[i].setWidth(levelOne.getWidth());
            player[i].setHeight(levelOne.getHeight());
            player[i].setFieldWidth();
            player[i].setFieldHeight();

            player[i].setImageWidth(20);
            player[i].setImageHeight(20);


            if (i == 0) {
                player[i].setPositionX(levelOne.getFieldWidth());
                player[i].setPositionY(levelOne.getFieldHeight());
            }
            if (i == 1) {
                player[i].setPositionX(width - levelOne.getFieldWidth());
                player[i].setPositionY(height -levelOne.getFieldHeight());
            }
            if (i == 2) {
                player[i].setPositionX(width - levelOne.getFieldWidth());
                player[i].setPositionY(levelOne.getFieldHeight());
            }
            if (i == 3) {
                player[i].setPositionX(levelOne.getFieldWidth());
                player[i].setPositionY(height - levelOne.getFieldHeight());
            }
            player[i].setCornerLeftUpX();
            player[i].setCornerLeftUpY();
            player[i].setCornerLeftDownX();
            player[i].setCornerLeftDownY();
            player[i].setCornerRightUpX();
            player[i].setCornerRightUpY();
            player[i].setCornerRightDownX();
            player[i].setCornerRightDownY();


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

    //  //zeigt schwarzen Bildschirm und ein "Game"
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
    }*/

}







