package acessoires;

import matchfield.Field;
import processing.core.PApplet;

public class BombController {

    final private Bomb bomb;
    final private BombView view;
    final private PApplet pApplet;
    private int changeImage = 0;

    public BombController(Bomb bomb, BombView view, PApplet pApplet) {
        this.bomb = bomb;
        this.view = view;
        this.pApplet = pApplet;
        setView();
    }

    //Die Bombe wechselt ihr Bild alle 40 Millisekunden und explodiert am Ende
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


    /*prüft ob die übergebenen Feldnummern auf einem Feld liegen, die getroffen werden bei der Explosion und gibt ein array
     * zurück welches für jeweils eine eins oder eine null für getroffen oder nicht getroffen steht. 0 ist der spieler, 1 ist der zweite Spieler 5 ist der
     * letzte gegner. Außerdem ändert es die Felder und bewirkt das Felder frei geschossen werden können und wie weit die Bombe schießen kann*/
    public int[] explosion(int fieldNumberBombermanOne, int fieldNumberBombermanTwo, int fieldNumberAutoCharacterOne, int fieldNumberAutoCharacterTwo, int fieldNumberAutoCharacterThree) {
        int maxNumberOfFieldsGetHit = getBomb().getBombRadius() * 4 + 1;
        int[] fieldsHit = new int[maxNumberOfFieldsGetHit];
        int[] playerHit = {0, 0, 0, 0, 0};
        int verticalUp = -1;
        int horizontalLeft = -15;
        int verticalDown = 1;
        int horizontalRight = 15;
        int radius = getBomb().getBombRadius();
        int fieldNumber = getBomb().getFieldNumber();
        fieldsHit[0] = fieldNumber;
        int k = 1;
        Field[] field = getBomb().getField();
        Obstacle[] obstacles = getBomb().getObstacles();
        //Wenn der Strahl auf einer Seite an die Wand trifft diesen Strahl stoppen
        if (field[fieldNumber + verticalDown].isBorder()) verticalDown = 0;
        if (field[fieldNumber + verticalUp].isBorder()) verticalUp = 0;
        if (field[fieldNumber + horizontalRight].isBorder()) horizontalRight = 0;
        if (field[fieldNumber + horizontalLeft].isBorder()) horizontalLeft = 0;
        //Es wird für die jeweiligen Felder geprüft
        for (int j = 0; j <= radius; j++) {
            int caseDown = fieldNumber + j * verticalDown;
            int caseUp = fieldNumber + j * verticalUp;
            int caseRight = fieldNumber + j * horizontalRight;
            int caseLeft = fieldNumber + j * horizontalLeft;
            //Es werden nur Felder angesprochen die auch betroffen sind. Freie Felder werden in Ruhe gelassen
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.isBorder()) {
                    if (!obstacle.isEmpty()) {
                        //Das Obstacle bekommt ein durchsichtiges Bild.
                        if (obstacle.getFieldNumber() == caseDown) {
                            obstacle.setImage(getpApplet().loadImage("images/nothing.png"));
                        }
                        if (obstacle.getFieldNumber() == caseUp) {
                            obstacle.setImage(getpApplet().loadImage("images/nothing.png"));
                        }
                        if (obstacle.getFieldNumber() == caseRight) {
                            obstacle.setImage(getpApplet().loadImage("images/nothing.png"));
                        }
                        if (obstacle.getFieldNumber() == caseLeft) {
                            obstacle.setImage(getpApplet().loadImage("images/nothing.png"));
                        }
                    }
                }
            }
            //Die Felder werden auf frei gelegt, sodass sich wieder dadurch bewegt werden kann
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
                    //Es wird ein Array befüllt welche Felder getroffen worden sind
                    if (field[i].isEmpty()) {
                        if (i == caseDown) {
                            fieldsHit[k] = i;
                        }
                        if (i == caseUp) {
                            fieldsHit[k + 1] = i;
                        }
                        if (i == caseRight) {
                            fieldsHit[k + 2] = i;
                        }
                        if (i == caseLeft) {
                            fieldsHit[k + 3] = i;
                        }
                    }
                }
            }
        }
        //Es wird überprüft ob einer der Charactere auf einem der Felder saß welches getroffen wurde
        for (int j : fieldsHit) {
            if (j == fieldNumberBombermanOne) {
                playerHit[0] = 1;
            }
            if (j == fieldNumberBombermanTwo) {
                playerHit[1] = 1;
            }
            if (j == fieldNumberAutoCharacterOne) {
                playerHit[2] = 1;
            }
            if (j == fieldNumberAutoCharacterTwo) {
                playerHit[3] = 1;
            }
            if (j == fieldNumberAutoCharacterThree) {
                playerHit[4] = 1;
            }
        }
        //Die Charactere bekommen wieder eine Bombe zum benutzen und die Bombe wird nicht mehr angezeigt
        getBomb().getCharacter().subBombCounter();
        getBomb().setExploded(false);
        //Es wird die Liste zurückgegeben ob jemand getroffen wurde
        return playerHit;
    }

    //Getter und Setter der Variablen
    public Bomb getBomb() {
        return bomb;
    }
    public PApplet getpApplet() {
        return pApplet;
    }
    public int getChangeImage() {
        return changeImage;
    }

    //Es wird eins addiert
    public void addChangeImage() {
        this.changeImage = changeImage + 1;
    }
}





