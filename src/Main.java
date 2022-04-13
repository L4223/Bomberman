import processing.core.PApplet;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");
        PApplet.main("Position");


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
//        fullScreen(2);
        size(900, 900, P2D);

    }


    public void movement() {
        if (keyPressed) {
            //checkt ob die nächste Position frei ist und ob die Taste gedrück wurde und bewegt sich nach links
            if (keyCode == LEFT) {
                if (levelOne.isFree(player[0].getCornerLeftUpX() - player[0].getSpeed(), player[0].getCornerLeftUpY())
                        && levelOne.isFree(player[0].getCornerLeftDownX() - player[0].getSpeed(), player[0].getCornerLeftDownY())) {
                    player[0].left(player[0].getSpeed());
                    player[0].updatePosition();
                } else {
                    for (int i = player[0].getSpeed(); i > 0; i--) {
                        if (levelOne.isFree(player[0].getCornerLeftUpX() - i, player[0].getCornerLeftUpY())
                                && levelOne.isFree(player[0].getCornerLeftDownX() - i, player[0].getCornerLeftDownY())) {
                            player[0].left(i);


                        }

                    }
                }
            }
            if (keyCode == RIGHT) {
                if (levelOne.isFree(player[0].getCornerRightUpX() + player[0].getSpeed(), player[0].getCornerRightUpY())
                        && levelOne.isFree(player[0].getCornerRightDownX() + player[0].getSpeed(), player[0].getCornerRightDownY())) {
                    player[0].right(player[0].getSpeed());
                    player[0].updatePosition();
                } else {
                    for (int i = player[0].getSpeed(); i > 0; i--) {
                        if (levelOne.isFree(player[0].getCornerRightUpX() + i, player[0].getCornerRightUpY())
                                && levelOne.isFree(player[0].getCornerRightDownX() + i, player[0].getCornerRightDownY())) {
                            player[0].right(i);


                        }

                    }
                }
            }
            if (keyCode == UP) {
                if (levelOne.isFree(player[0].getCornerLeftUpX(), player[0].getCornerLeftUpY() - player[0].getSpeed())
                        && levelOne.isFree(player[0].getCornerRightUpX() , player[0].getCornerRightUpY() - player[0].getSpeed())) {
                    player[0].up(player[0].getSpeed());
                } else {
                    for (int i = player[0].getSpeed(); i > 0; i--) {
                        if (levelOne.isFree(player[0].getCornerLeftUpX() , player[0].getCornerLeftUpY() - i)
                                && levelOne.isFree(player[0].getCornerRightUpX() , player[0].getCornerRightUpY() - i )) {
                            player[0].up(i);


                        }

                    }
                }
            }
            if (keyCode == DOWN) {
                if (levelOne.isFree(player[0].getCornerLeftDownX()  , player[0].getCornerLeftDownY()  + player[0].getSpeed())
                        && levelOne.isFree(player[0].getCornerRightDownX() , player[0].getCornerRightDownY() + player[0].getSpeed())) {
                    player[0].down(player[0].getSpeed());
                } else {
                    for (int i = player[0].getSpeed(); i > 0; i--) {
                        if (levelOne.isFree(player[0].getCornerLeftDownX() , player[0].getCornerLeftDownY()  + i)
                                && levelOne.isFree(player[0].getCornerRightDownX(), player[0].getCornerRightDownY() + i)) {
                            player[0].down(i);

                        }

                    }
                }
            }


                }
        player[0].updatePosition();

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

        println("Position X = " + player[0].getPositionX() + "PositionY = " + player[0].getPositionY());


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







