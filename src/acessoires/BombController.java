package acessoires;

import matchfield.Field;
import processing.core.PApplet;

public class BombController {
    public BombController(Bomb bomb, BombView view, PApplet pApplet) {
        this.bomb = bomb;
        this.view = view;
        this.pApplet = pApplet;
        setView();
    }

    final private Bomb bomb;
    final private BombView view;
    final private PApplet pApplet;

    public Bomb getBomb() {
        return bomb;
    }

    public PApplet getpApplet() {
        return pApplet;
    }

    int changeImage = 0;

    public int getChangeImage() {
        return changeImage;
    }

    public void addChangeImage() {
        this.changeImage = changeImage + 1;
    }

    public void setView() {
        view.draw(getBomb(), getpApplet());
        if (getpApplet().frameCount % 40 == 0) {
            if (getChangeImage() == 1) {
                getBomb().setImage(getpApplet().loadImage("images/Bomb_2.png"));
            }
            if (getChangeImage() == 2) {
                getBomb().setImage(getpApplet().loadImage("images/Bomb_3.png"));
            }
            if (getChangeImage() == 3) {
                getBomb().setImage(getpApplet().loadImage("images/Explosion.png"));
            }
            if (getChangeImage() == 4) {
                getBomb().setPlaced(false);
                getBomb().setExploded(true);
                getBomb().setImage(getpApplet().loadImage("images/Bomb_1.png"));
            }
            addChangeImage();

        }
    }

    public void explosion() {
        int verticalUp = -1;
        int horizontalLeft = -15;
        int verticalDown = 1;
        int horizontalRight = 15;
        int radius = getBomb().getBombRadius();
        int fieldNumber = getBomb().getFieldNumber();
        Field[] field = getBomb().getField();
        if (field[fieldNumber + verticalDown].isBorder()
                || field[fieldNumber + verticalUp].isBorder()) {
            verticalDown = 0;
            verticalUp = 0;
        }


        if (field[fieldNumber + horizontalRight].isBorder()
                || field[fieldNumber + horizontalLeft].isBorder()) {
            horizontalRight = 0;
            horizontalLeft = 0;
        }

                for (int j = 0; j <= radius; j++) {
                    int caseDown = fieldNumber + j * verticalDown;
                    int caseUp = fieldNumber + j * verticalUp;
                    int caseRight = fieldNumber + j * horizontalRight;
                    int caseLeft = fieldNumber + j * horizontalLeft;
                    for (int i = 0; i < field.length; i++) {
                        if (!field[i].isBorder()) {
                    if (!field[i].isEmpty()) {
                        if (i == caseDown) {
                            field[i].setEmpty(true);
                            verticalDown = 0;
                        }
                        if (i == caseUp) {
                            field[i].setEmpty(true);
                            verticalUp = 0;
                        }
                        if (i == caseRight) {
                            field[i].setEmpty(true);
                            horizontalRight = 0;
                        }
                        if (i == caseLeft) {
                            field[i].setEmpty(true);
                            horizontalLeft = 0;
                        }


                    }

                }


            }
        }
            getBomb().getCharacter().subBombCounter();
            getBomb().setExploded(false);
        }
    }





