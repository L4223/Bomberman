import processing.core.PApplet;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");
        Character bombermanOne = new Character();
        System.out.println(bombermanOne.getPositionX());
    }


    boolean start, pause, playground, gameover;
    int fieldsX = 9;
    int fieldsY = 9;
    int fieldWidth = 17;
    int fieldHeight = 17;
    int[][] matchfield = new int[fieldsX][fieldsY];

    public void settings() {
//        fullScreen(2);
        size(900, 900);

    }

    public void keyPressed() {
        if (start && key == ENTER) {
            start = false;
            playground = true;
        }
        if (key == ESC) {
            key = 0;
        }
        if (playground || pause && key == 0) {
            playground = !playground;
            pause = !pause;
        }
        if (key == '.') {
            key = ESC;
        }

    }

    public void setup() {
        start = false;
        pause = false;
        playground = false;
        gameover = false;

        background(0);
        battlefield();
        println(free(250, 250));
        matchfield();
        println("Hallo" + test);
        for (int i = 0; i < matchfield.length; i++) {
            println();
            for (int j = 0; j < matchfield[i].length; j++) {
                print(matchfield[i][j] + " ");
            }
        }
    }

    public void draw() {
//        background(255);
        start();
        pause();
        playground();
        gameover();

    }

    public void start() {
        if (start) {
            background(0);
            textSize(height / 4);
            fill(255);
            text("Start", height / 2, width / 2);
        }
    }

    public void playground() {
        if (playground) {
            background(0);
            textSize(height / 4);
            fill(255);
            text("Game", height / 2, width / 2);
        }
    }

    public void pause() {
        if (pause) {
            background(0);
            textSize(height / 4);
            fill(255);
            text("Pause", height / 2, width / 2);
        }
    }

    public void gameover() {
        if (gameover) {
            background(0);
            textSize(height / 4);
            fill(255);
            text("GAME OVER", height / 2, width / 2);
        }
    }

    public void matchfield() {
        for (int i = 0; i < matchfield.length; i++) {
            for (int j = 0; j < matchfield[i].length; j++) {
                if (i == 0 || i == matchfield.length - 1 || j == 0 || j == matchfield[i].length - 1 || i % 2 == 0 && j % 2 == 0) {
                    matchfield[i][j] = 1;
                } else {
                    matchfield[i][j] = 0;
                }
            }
        }
    }
    int xTest = 250;
    int yTest = 250;
    boolean test;
    public void battlefield() {
        rectMode(CORNERS);
        forSchleife:
        for (int x = 0; x < width; x += width / fieldWidth) {
            for (int y = 0; y < height; y += height / fieldHeight) {

                if (x == 0 || x > width - (width / fieldWidth) * 2 || y == 0 || y > height - (height / fieldHeight) * 2 || x % ((width / fieldWidth) * 2) == 0 && y % ((height / fieldHeight) * 2) == 0) {
                    noStroke();
                    fill(255);
                    rect(x, y, x + width / fieldWidth, y + height / fieldHeight);
                    if (xTest > x && xTest < x + fieldWidth && yTest > y && yTest < y + fieldHeight) {
                        test = false;
                        break forSchleife;
                    }
//                    println("NotFree: Position X = " + x + ", " + y + "; Position Y = " + (x + width / fieldWidth) + ", " + (y + height / fieldHeight));
                } else {
                    test = true;
                    noStroke();
                    fill(0, 0, 255);
                    rect(x, y, x + width / fieldWidth, y + height / fieldHeight);
//                    println("Free: Position X = " + x + ", " + y + "; Position Y = " + (x + width / fieldWidth) + ", " + (y + height / fieldHeight));
                }
            }
        }
    }

    public boolean free(int xPosition, int yPosition) {
        boolean ergebnis = false;
        if (xPosition < width / fieldWidth || xPosition > width - width / fieldWidth || yPosition < height / fieldHeight || yPosition > height - height / fieldHeight) {
            ergebnis = false;
        } else {
            forSchleife:
            for (int x = width / fieldWidth; x < width - fieldWidth; x += width / fieldWidth) {
                for (int y = height / fieldHeight; y < height - fieldHeight; y += height / fieldHeight) {
                    println("test");
//
                    if (x % ((width / fieldWidth) * 2) == 0 && y % ((height / fieldHeight) * 2) == 0) {
                        println("test1");
                        if (xPosition > x && xPosition < x + width / fieldWidth && yPosition > y && yPosition < y + height / fieldHeight) {
                            println("test2");
                            ergebnis = false;
                            break forSchleife;
                        } else {
                            println("test4");
                            ergebnis = true;
                        }
                    }
                }
            }
        }
        return ergebnis;
    }
}


