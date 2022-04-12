import processing.core.PApplet;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");


    }

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


    //Größe der Anzeige und Einstellung des Renderers
    public void settings() {
        fullScreen(2);
//        size(900, 900, P2D);

    }


    public void movement() {
        if (keyPressed) {
            //checkt ob die nächste Position frei ist und ob die Taste gedrück wurde und bewegt sich nach links

            if (levelOne.isFree(player[0].getCornerLeftUpX(), player[0].getCornerLeftUpY()) && levelOne.isFree(player[0].getCornerLeftDownX(), player[0].getCornerLeftDownY()) && keyCode == LEFT) {
                player[0].left(player[0].getSpeed());
            }

            else {
                if (keyCode == LEFT) {

                    for (int i = player[0].getSpeed(); i > 0; i--) {
                        println("test3");
                        println(player[0].getCornerRightUpX());
                        if (levelOne.isFree(player[0].getCornerLeftUpX() - i, player[0].getCornerLeftUpY()) && levelOne.isFree(player[0].getCornerLeftDownX() - i , player[0].getCornerLeftDownY()) && keyCode == LEFT) {
                            player[0].left(i);
                            println("test2");

                        }
                    }
                }
            }
                        if(levelOne.isFree(player[0].getCornerRightUpX() , player[0].getCornerRightUpY()) && levelOne.isFree(player[0].getCornerRightDownX() , player[0].getCornerRightDownY()) && keyCode == RIGHT) {
                player[0].right(player[0].getSpeed());
                println("test");
            }
//            //checkt ob die nächste Position frei ist und ob die Taste gedrück wurde und bewegt sich nach oben
//            if (isFree(player.getPositionX(), player.getPositionY() - player.getSpeed())
//                    && isFree(player.getPositionX() + imageWidth, player.getPositionY() - player.getSpeed())
//                    && keyCode == UP) {
//                player.up(player.getSpeed());
//            } else {
//                if (keyCode == UP) {
//
//                    for (int i = player.getSpeed(); i > 0; i--) {
//                        if (isFree(player.getPositionX(), player.getPositionY() - i)
//                                && isFree(player.getPositionX() + imageWidth, player.getPositionY() - i)) {
//                            player.up(i);
//                        }
//                    }
//                }
//            }
//            //checkt ob die nächste Position frei ist und ob die Taste gedrück wurde und bewegt sich nach rechts
//            if (isFree(player.getPositionX() + imageWidth + player.getSpeed(), player.getPositionY())
//                    && isFree(player.getPositionX() + imageWidth + player.getSpeed(), player.getPositionY() + imageHeight)
//                    && keyCode == RIGHT) {
//                player.right(player.getSpeed());
//            } else {
//                if (keyCode == RIGHT) {
//
//                    for (int i = player.getSpeed(); i > 0; i--) {
//                        if (isFree(player.getPositionX() + imageWidth + i, player.getPositionY())
//                                && isFree(player.getPositionX() + imageWidth + i, player.getPositionY() + imageHeight)) {
//                            player.right(i);
//                        }
//                    }
//                }
//            }
//            //checkt ob die nächste Position frei ist und ob die Taste gedrück wurde und bewegt sich nach unten
//            if (isFree(player.getPositionX(), player.getPositionY() + imageHeight + player.getSpeed())
//                    && isFree(player.getPositionX() + imageWidth, player.getPositionY() + imageHeight + player.getSpeed())
//                    && keyCode == DOWN) {
//                player.down(player.getSpeed());
//            } else {
//                if (keyCode == DOWN) {
//
//                    for (int i = player.getSpeed(); i > 0; i--) {
//                        if (isFree(player.getPositionX(), player.getPositionY() + imageHeight + i)
//                                && isFree(player.getPositionX() + imageWidth, player.getPositionY() + imageHeight + i)) {
//                            player.down((i));
//                        }
//                    }
//                }
//            }
        }
    }

    public void updatePosition() {
        player[0].setCornerLeftUpX();
        player[0].setCornerLeftUpY();
        player[0].setCornerLeftDownX();
        player[0].setCornerLeftDownY();
        player[0].setCornerRightUpX();
        player[0].setCornerRightUpY();
        player[0].setCornerRightDownX();
        player[0].setCornerRightUpY();




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

    public void setup() {


        //bestimmt die Größe des Bildes
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


        // zeichnet Spielfeld


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

            player[i].setColor(player[i].getColorSelection(i));
            player[i].setSpeed(width / 100);
            player[i].setBomb(1);
            player[i].setHeart(3);
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

    public void draw() {
        //lässt die Spieler bewegen
//        movement(player[0]);
        //zeichnet Spielfeld neu


        rectMode(CORNERS);
        noStroke();
        matchfield();
        movement();
        updatePosition();


        //zeichnet Spieler in enstprechender Farbe
        for (int i = 0; i < 4; i++) {
            fill(player[i].getColor());
            rect(player[i].getCornerLeftUpX(), player[i].getCornerLeftUpY(), player[i].getCornerRightDownX(), player[i].getCornerRightDownY());
        }

        //zeichnet entsprechend aktivierten Bildschirm
        start();
        pause();
        playground();
        gameover();


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
    }
    //erstellt Spielfeld
    public void matchfield() {


        for (int x = 0; x < levelOne.getWidth(); x += levelOne.getFieldWidth()) {
            for (int y = 0; y < levelOne.getHeight(); y += levelOne.getFieldHeight()) {
                //erstellt die weißen Felder in dem mittleren Teil
                if (x == 0 || x == levelOne.getWidth() - levelOne.getFieldWidth()   || y == 0 || y == levelOne.getHeight()  - levelOne.getFieldHeight() || x % (levelOne.getFieldWidth() * 2) == 0 && y % (levelOne.getFieldHeight() * 2) == 0) {

                    fill(255);
                    rect(x, y, x + levelOne.getFieldWidth(), y + levelOne.getFieldHeight());
//                                        println("Free: Position X = " + x + ", " + y + "; Position Y = " + (x + fieldWidth) + ", " + (y + fieldHeight));

                    //zeichnet die restliche Fläche in Blau
                } else {

                    fill(0, 0, 255);
                    rect(x, y, x + levelOne.getFieldWidth(), y + levelOne.getFieldHeight());
//                    println("Free: Position X = " + x + ", " + y + "; Position Y = " + (x + fieldWidth) + ", " + (y + fieldHeight));
                }
            }
        }
    }
}







