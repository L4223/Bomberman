import processing.core.PApplet;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");

    }

    // Variablen für Bildschirm
    boolean start, pause, playground, gameover;
    //die größe des Spielfelds
    int fieldSize = 15;
    //Die Maße eines Feldes
    int fieldWidth;
    int fieldHeight;
    //Array der Spieler
    Character [] player = new Character[4];
    //Die Maße des Bildes
    int imageWidth;
    int imageHeight;
    //pixelReste
    int pixelRestWidth;
    int pixelRestHeight;


    //Größe der Anzeige und Einstellung des Renderers
    public void settings() {
        fullScreen(2);
//        size(900, 900, P2D);

    }



    public void movement(Character player) {
        if (keyPressed) {
            //checkt ob die nächste Position frei ist und ob die Taste gedrück wurde und bewegt sich nach links

            if (isFree(player.getPositionX() - player.getSpeed(),player.getPositionY() )
                    && isFree(player.getPositionX() - player.getSpeed(), player.getPositionY() + imageHeight)
                    && keyCode == LEFT) {
                player.left(player.getSpeed());
            } else {
                if (keyCode == LEFT) {

                    for (int i = player.getSpeed(); i > 0; i--) {
                        if (isFree(player.getPositionX() - i,player.getPositionY() )
                                && isFree(player.getPositionX() - i, player.getPositionY() + imageHeight)) {
                            player.left(i);
                        }
                    }
                }
            }
            //checkt ob die nächste Position frei ist und ob die Taste gedrück wurde und bewegt sich nach oben
            if (isFree(player.getPositionX(),player.getPositionY() - player.getSpeed())
                    && isFree(player.getPositionX() + imageWidth, player.getPositionY()  - player.getSpeed())
                    && keyCode == UP) {
                player.up(player.getSpeed());
            } else {
                if (keyCode == UP) {

                    for (int i = player.getSpeed(); i > 0; i--) {
                        if (isFree(player.getPositionX(),player.getPositionY() - i)
                                && isFree(player.getPositionX() + imageWidth, player.getPositionY() - i)) {
                            player.up(i);
                        }
                    }
                }
            }
            //checkt ob die nächste Position frei ist und ob die Taste gedrück wurde und bewegt sich nach rechts
            if (isFree(player.getPositionX() + imageWidth + player.getSpeed(),player.getPositionY() )
                    && isFree(player.getPositionX() + imageWidth + player.getSpeed(), player.getPositionY() + imageHeight)
                    && keyCode == RIGHT) {
                player.right(player.getSpeed());
            } else {
                if (keyCode == RIGHT) {

                    for (int i = player.getSpeed(); i > 0; i--) {
                        if (isFree(player.getPositionX() + imageWidth + i,player.getPositionY() )
                                && isFree(player.getPositionX() + imageWidth + i, player.getPositionY() + imageHeight)) {
                            player.right(i);
                        }
                    }
                }
            }
            //checkt ob die nächste Position frei ist und ob die Taste gedrück wurde und bewegt sich nach unten
            if (isFree(player.getPositionX() ,player.getPositionY() + imageHeight + player.getSpeed() )
                    && isFree(player.getPositionX() + imageWidth , player.getPositionY() + imageHeight + player.getSpeed())
                    && keyCode == DOWN) {
                player.down(player.getSpeed());
            } else {
                if (keyCode == DOWN) {

                    for (int i = player.getSpeed(); i >0; i--) {
                        if (isFree(player.getPositionX(),player.getPositionY() + imageHeight + i )
                                && isFree(player.getPositionX() + imageWidth, player.getPositionY() + imageHeight + i)) {
                            player.down((i ));
                        }
                    }
                }
            }
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

    public void setup() {

        pixelRestWidth = width%fieldSize;
        pixelRestHeight = height%fieldSize;

        width = width - pixelRestWidth;
        height = height - pixelRestHeight;


        //bestimmt die Feldgröße anhand der Größe des Bildschirms
        fieldWidth = width/ fieldSize;
        fieldHeight = height/ fieldSize;

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


        // zeichnet Spielfeld
        matchfield();

    }

    // erstellt die Charactere eines neuen Spiel mit Anzahl der Spieler und weißt Ihnen die Anzahl der Bomben, der Leben, die Farbe, die Geschwindigkeit und Position zu.
    public void newGame (int numberOfPlayer) {
        for (int i = 0; i < numberOfPlayer; i++) {
            player[i] = new Character();
            player[i].setColor(player[i].getColorSelection(i));
            player[i].setSpeed(width/100);
            player[i].setBomb(1);
            player[i].setHeart(3);
            if (i == 0) {
                player[i].setPositionX((int)fieldWidth);
                player[i].setPositionY((int)fieldHeight);
            }
            if (i == 1) {
                player[i].setPositionX(width - (int)fieldWidth);
                player[i].setPositionY(height - (int)fieldHeight);
            }
            if (i == 2) {
                player[i].setPositionX(width - (int)fieldWidth);
                player[i].setPositionY((int)fieldHeight);
            }
            if (i == 3) {
                player[i].setPositionX((int)fieldWidth);
                player[i].setPositionY(height - (int)fieldHeight);
            }
        }
    }

    public void draw() {
        //lässt die Spieler bewegen
        movement(player[0]);
        //zeichnet Spielfeld neu
        matchfield();

        rectMode(CORNERS);
        noStroke();

        //zeichnet Spieler in enstprechender Farbe
        for(int i = 0; i < 4; i++) {
            fill(player[i].getColor());
            if (i == 0) rect(player[i].getPositionX(), player[i].getPositionY(),player[i].getPositionX() + imageWidth, player[i].getPositionY() + imageHeight  );
            if (i == 1) rect(player[i].getPositionX() - imageWidth, player[i].getPositionY() - imageHeight,player[i].getPositionX(), player[i].getPositionY()  );
            if (i == 2) rect(player[i].getPositionX() - imageWidth, player[i].getPositionY(),player[i].getPositionX() , player[i].getPositionY() + imageHeight );
            if (i == 3) rect(player[i].getPositionX(), player[i].getPositionY() - imageHeight,player[i].getPositionX() + imageWidth, player[i].getPositionY()  );
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
        rectMode(CORNERS);

        for (int x = 0; x < width; x += fieldWidth) {
            for (int y = 0; y < height; y += fieldHeight) {
                //erstellt die weißen Felder in dem mittleren Teil
                if (x == 0 || x == fieldWidth * fieldSize - fieldWidth   || y == 0 || y == fieldHeight * fieldSize - fieldHeight || x % (fieldWidth * 2) == 0 && y % (fieldHeight * 2) == 0) {
                    noStroke();
                    fill(255);
                    rect(x, y, x + fieldWidth, y + fieldHeight);
//                                        println("Free: Position X = " + x + ", " + y + "; Position Y = " + (x + fieldWidth) + ", " + (y + fieldHeight));

                    //zeichnet die restliche Fläche in Blau
                } else {
                    noStroke();
                    fill(0, 0, 255);
                    rect(x, y, x + fieldWidth, y + fieldHeight);
//                    println("Free: Position X = " + x + ", " + y + "; Position Y = " + (x + fieldWidth) + ", " + (y + fieldHeight));
                }
            }
        }
    }

    //checkt ob eine Position frei ist
    public boolean isFree(int xPosition, int yPosition) {
        boolean ergebnis = false;
        //schneller check ob der Rand betroffen ist
        if (xPosition < fieldWidth || xPosition > width - fieldWidth || yPosition < fieldHeight || yPosition > height - fieldHeight) {
            ergebnis = false;
        } else {
            //check ob die Felder in der Mitte getroffen werden mit Hilfe einer for-Schleife, gleich wie beim zeichnen
            forSchleife:
            for (double x = fieldWidth; x < width - fieldWidth; x += fieldWidth) {
                for (double y = fieldHeight; y < height - fieldHeight; y += fieldHeight) {

                    if (x % (fieldWidth * 2) == 0 && y % (fieldHeight * 2) == 0) {
                        if (xPosition > x && xPosition < x + fieldWidth && yPosition > y  && yPosition < y + fieldHeight ) {
                            ergebnis = false;
                            break forSchleife;
                        } else {
                            ergebnis = true;
                        }
                    }
                }
            }
        }
        return ergebnis;
    }

}


