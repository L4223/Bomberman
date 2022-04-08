import processing.core.PApplet;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");

    }


//    boolean start, pause, playground, gameover;
//    int fieldsX = 9;
//    int fieldsY = 9;
    int fieldSize = 9;
    int fieldWidth;
    int fieldHeight;
    Character [] player = new Character[4];
    int imageWidth;
    int imageHeight;
//    int[][] matchfield = new int[fieldsX][fieldsY];

    public void settings() {
//        fullScreen(2);
        size(900, 900);

    }

//    public void keyPressed() {
//        if (start && key == ENTER) {
//            start = false;
//            playground = true;
//        }
//        if (key == ESC) {
//            key = 0;
//        }
//        if (playground || pause && key == 0) {
//            playground = !playground;
//            pause = !pause;
//        }
//        if (key == '.') {
//            key = ESC;
//        }

//    }

    public void setup() {
        fieldWidth = width/ fieldSize;
        fieldHeight = height/ fieldSize;
        imageWidth = 20;
        imageHeight = 20;

        newGame(4);







//        start = false;
//        pause = false;
//        playground = false;
//        gameover = false;

//
//        background(0);
        battlefield();
//        println(free(250, 250));
//        matchfield();
//        println("Hallo" + test);
//        for (int i = 0; i < matchfield.length; i++) {
//            println();
//            for (int j = 0; j < matchfield[i].length; j++) {
//                print(matchfield[i][j] + " ");
//            }
//        }
    }

    public void newGame (int numberOfPlayer) {
        for (int i = 0; i < numberOfPlayer; i++) {
            player[i] = new Character();
            player[i].setColor(player[i].getColorSelection(i));
            player[i].setSpeed(width/100);
            player[i].setBomb(1);
            player[i].setHeart(3);
            player[i].setPositionX(player[i].getStartPositionX(i));
            player[i].setPositionY(player[i].getStartPositionY(i));
        }
    }
    public void draw() {
        battlefield();
        rectMode(CORNERS);
        stroke(0);
        for(int i = 0; i < 4; i++) {
            fill(player[i].getColor());
            rect(player[i].getPositionX(), player[i].getPositionY(),player[i].getPositionX() + imageWidth, player[i].getPositionY() + imageHeight  );
        }
//        background(255);
//        start();
//        pause();
//        playground();
//        gameover();


    }
//
//    public void start() {
//        if (start) {
//            background(0);
//            textSize(height / 4);
//            fill(255);
//            text("Start", height / 2, width / 2);
//        }
//    }
//
//    public void playground() {
//        if (playground) {
//            background(0);
//            textSize(height / 4);
//            fill(255);
//            text("Game", height / 2, width / 2);
//        }
//    }
//
//    public void pause() {
//        if (pause) {
//            background(0);
//            textSize(height / 4);
//            fill(255);
//            text("Pause", height / 2, width / 2);
//        }
//    }
//
//    public void gameover() {
//        if (gameover) {
//            background(0);
//            textSize(height / 4);
//            fill(255);
//            text("GAME OVER", height / 2, width / 2);
//        }
//    }
//
//    public void matchfield() {
//        for (int i = 0; i < matchfield.length; i++) {
//            for (int j = 0; j < matchfield[i].length; j++) {
//                if (i == 0 || i == matchfield.length - 1 || j == 0 || j == matchfield[i].length - 1 || i % 2 == 0 && j % 2 == 0) {
//                    matchfield[i][j] = 1;
//                } else {
//                    matchfield[i][j] = 0;
//                }
//            }
//        }
//    }
//    int xTest = 250;
//    int yTest = 250;
//    boolean test;
    public void battlefield() {
        rectMode(CORNERS);

        for (int x = 0; x < width; x += fieldWidth) {
            for (int y = 0; y < height; y += fieldHeight) {

                if (x == 0 || x > width - fieldWidth * 2 || y == 0 || y > height - fieldHeight * 2 || x % (fieldWidth * 2) == 0 && y % (fieldHeight * 2) == 0) {
                    noStroke();
                    fill(255);
                    rect(x, y, x + fieldWidth, y + fieldHeight);

                } else {
                    noStroke();
                    fill(0, 0, 255);
                    rect(x, y, x + fieldWidth, y + fieldHeight);
//                    println("Free: Position X = " + x + ", " + y + "; Position Y = " + (x + fieldWidth) + ", " + (y + fieldHeight));
                }
            }
        }
    }

    public boolean isFree(int xPosition, int yPosition) {
        boolean ergebnis = false;
        if (xPosition < fieldWidth || xPosition > width - fieldWidth || yPosition < fieldHeight || yPosition > height - fieldHeight) {
            ergebnis = false;
        } else {
            forSchleife:
            for (int x = fieldWidth; x < width - fieldWidth; x += fieldWidth) {
                for (int y = fieldHeight; y < height - fieldHeight; y += fieldHeight) {

                    if (x % (fieldWidth * 2) == 0 && y % (fieldHeight * 2) == 0) {
                        if (xPosition > x && xPosition < x + fieldWidth && yPosition > y && yPosition < y + fieldHeight) {
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


