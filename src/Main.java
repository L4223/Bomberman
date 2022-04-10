import processing.core.PApplet;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");

    }

    // Variablen für Bildschirm
    boolean start, pause, playground, gameover;
    //die größe des Spielfelds
    int fieldSize = 9;
    //Die Maße eines Feldes
    int fieldWidth;
    int fieldHeight;
    //Array der Spieler
    Character [] player = new Character[4];
    //Die Maße des Bildes
    int imageWidth;
    int imageHeight;


    //Größe der Anzeige und Einstellung des Renderers
    public void settings() {
//        fullScreen(2);
        size(900, 900, P2D);

    }


    // Bewegung bei Tastatudruck nach rechts oder linke
    public void movement(Character player) {
        if (keyPressed) {
            //checkt ob die nächste Position frei ist und ob die Taste gedrück wurde und bewegt sich nach links
            if (isFree(player.getPositionX() - 1,player.getPositionY() )
                    && isFree(player.getPositionX() - 1, player.getPositionY() + imageHeight)
            && keyCode == LEFT) {
                player.left();
            }
            //checkt ob die nächste Position frei ist und ob die Taste gedrück wurde und bewegt sich nach oben
            if (isFree(player.getPositionX(),player.getPositionY() - 1 )
                    && isFree(player.getPositionX() + imageWidth, player.getPositionY() - 1)
                    && keyCode == UP) {
                player.up();
            }
            //checkt ob die nächste Position frei ist und ob die Taste gedrück wurde und bewegt sich nach unten
            if (isFree(player.getPositionX() ,player.getPositionY() + imageHeight + 1 )
                    && isFree(player.getPositionX() + imageWidth, player.getPositionY() + imageHeight + 1)
                    && keyCode == DOWN) {
                player.down();
            }
            //checkt ob die nächste Position frei ist und ob die Taste gedrück wurde und bewegt sich nach rechts
            if (isFree(player.getPositionX() + imageWidth + 1,player.getPositionY() )
                    && isFree(player.getPositionX() + imageWidth + 1, player.getPositionY() + imageHeight)
                    && keyCode == RIGHT) {
                player.right();
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
                player[i].setPositionX(fieldWidth);
                player[i].setPositionY(fieldHeight);
            }
            if (i == 1) {
                player[i].setPositionX(width - fieldWidth);
                player[i].setPositionY(height - fieldHeight);
            }
            if (i == 2) {
                player[i].setPositionX(width - fieldWidth);
                player[i].setPositionY(fieldHeight);
            }
            if (i == 3) {
                player[i].setPositionX(fieldWidth);
                player[i].setPositionY(height - fieldHeight);
            }
        }
    }

    public void draw() {
        println(player[0].getPositionX());
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
                if (x == 0 || x > width - fieldWidth * 2 || y == 0 || y > height - fieldHeight * 2 || x % (fieldWidth * 2) == 0 && y % (fieldHeight * 2) == 0) {
                    noStroke();
                    fill(255);
                    rect(x, y, x + fieldWidth, y + fieldHeight);
                //zeichnet die restliche Fläche in Blau
                } else {
                    noStroke();
                    fill(0, 0, 255);
                    rect(x, y, x + fieldWidth, y + fieldHeight);
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
            for (int x = fieldWidth; x < width - fieldWidth; x += fieldWidth) {
                for (int y = fieldHeight; y < height - fieldHeight; y += fieldHeight) {

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


