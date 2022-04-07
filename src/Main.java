import processing.core.PApplet;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    boolean start, pause, playground, gameover;
    int fieldsX = 9;
    int fieldsY = 9;
    int[][] matchfield = new int[fieldsX][fieldsY];

    public void settings() {
        fullScreen(P2D, 2);

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
        start = true;
        pause = false;
        playground = false;
        gameover = false;

        background(0);
        matchfield();
        for (int i = 0; i < matchfield.length; i++) {
            println();
            for (int j = 0; j < matchfield[i].length; j++) {
                print(matchfield[i][j] + " ");
            }
        }
    }

    public void draw() {
        background(255);
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
}
