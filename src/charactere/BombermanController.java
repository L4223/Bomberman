package charactere;

import acessoires.Bomb;
import acessoires.BombController;
import acessoires.BombView;
import acessoires.Obstacle;
import matchfield.Field;
import matchfield.Matchfield;
import processing.core.PApplet;

public class BombermanController extends CharacterController {

    public BombermanController(Bomberman bomberman, CharacterView view, Matchfield matchfield, Field[] field, Obstacle[] obstacles, PApplet pApplet) {
        super(bomberman, view, matchfield, field, obstacles, pApplet);
    }


    //Auch die Erstellung der Bombe enthalten, soll aber noch in eine eigenee Funktion
    @Override
    public void movement() {
        if (getpApplet().keyPressed) {
            //checkt ob die nächste main.Position links frei ist und ob die Taste gedrückt wurde und bewegt sich nach links
            if (getpApplet().keyCode == getpApplet().LEFT && getCharacter().getPlayernumber() == 0 || getpApplet().key == 'a' && getCharacter().getPlayernumber() == 1) {
                if (getMatchfield().isFree(getCharacter().getCornerLeftUpX() - getCharacter().getSpeed(), getCharacter().getCornerLeftUpY()) && getMatchfield().isFree(getCharacter().getCornerLeftDownX() - getCharacter().getSpeed(), getCharacter().getCornerLeftDownY())) {
                    for (int j = getCharacter().getSpeed(); j > 0; j--) {
                        if (movementLeft()) {
                            left(1);
                        }
                    }
                    //checkt ob eine der linken Ecke frei ist und bewegt sich dementsprechend um die Figur ganz zu befreien
                } else if (getMatchfield().isFree(getCharacter().getCornerLeftUpX() - getCharacter().getSpeed(), getCharacter().getCornerLeftUpY())) {
                    up(getCharacter().getSpeed());
                } else if (getMatchfield().isFree(getCharacter().getCornerLeftDownX() - getCharacter().getSpeed(), getCharacter().getCornerLeftDownY())) {
                    down(getCharacter().getSpeed());
                } else {
                    //dasselbe wie vorher nur für die einzelnen Pixel um an den Rand zu kommen, sonst Abstand wie Geschwindigkeit
                    for (int i = getCharacter().getSpeed(); i > 0; i--) {
                        if (getMatchfield().isFree(getCharacter().getCornerLeftUpX() - i, getCharacter().getCornerLeftUpY()) && getMatchfield().isFree(getCharacter().getCornerLeftDownX() - i, getCharacter().getCornerLeftDownY())) {
                            left(i);
                        } else if (getMatchfield().isFree(getCharacter().getCornerLeftUpX() - i, getCharacter().getCornerLeftUpY())) {
                            up(i);
                        } else if (getMatchfield().isFree(getCharacter().getCornerLeftDownX() - i, getCharacter().getCornerLeftDownY())) {
                            down(i);
                        }
                    }
                }
            }
            //checkt ob die nächste main.Position rechts frei ist und ob die Taste gedrückt wurde und bewegt sich nach rechts
            if (getpApplet().keyCode == getpApplet().RIGHT && getCharacter().getPlayernumber() == 0 || getpApplet().key == 'd' && getCharacter().getPlayernumber() == 1) {

                if (getMatchfield().isFree(getCharacter().getCornerRightUpX() + getCharacter().getSpeed(), getCharacter().getCornerRightUpY()) && getMatchfield().isFree(getCharacter().getCornerRightDownX() + getCharacter().getSpeed(), getCharacter().getCornerRightDownY())) {
                    for (int j = getCharacter().getSpeed(); j > 0; j--) {
                        if (movementRight()) {
                            right(1);
                        }
                    }
                    //checkt ob eine der rechten Ecke frei ist und bewegt sich dementsprechend um die Figur ganz zu befreien
                } else if (getMatchfield().isFree(getCharacter().getCornerRightUpX() + getCharacter().getSpeed(), getCharacter().getCornerRightUpY())) {
                    up(getCharacter().getSpeed());
                } else if (getMatchfield().isFree(getCharacter().getCornerRightDownX() + getCharacter().getSpeed(), getCharacter().getCornerRightDownY())) {
                    down(getCharacter().getSpeed());
                } else {
                    //dasselbe wie vorher nur für die einzelnen Pixel um an den Rand zu kommen, sonst Abstand wie Geschwindigkeit
                    for (int i = getCharacter().getSpeed(); i > 0; i--) {
                        if (getMatchfield().isFree(getCharacter().getCornerRightUpX() + i, getCharacter().getCornerRightUpY()) && getMatchfield().isFree(getCharacter().getCornerRightDownX() + i, getCharacter().getCornerRightDownY())) {
                            right(i);
                        } else if (getMatchfield().isFree(getCharacter().getCornerRightUpX() + i, getCharacter().getCornerRightUpY())) {
                            up(i);
                        } else if (getMatchfield().isFree(getCharacter().getCornerRightDownX() + i, getCharacter().getCornerRightDownY())) {
                            down(i);
                        }
                    }
                }
            }
            //checkt ob die nächste main.Position oben frei ist und ob die Taste gedrückt wurde und bewegt sich nach oben
            if (getpApplet().keyCode == getpApplet().UP && getCharacter().getPlayernumber() == 0 || getpApplet().key == 'w' && getCharacter().getPlayernumber() == 1) {
                if (getMatchfield().isFree(getCharacter().getCornerLeftUpX(), getCharacter().getCornerLeftUpY() - getCharacter().getSpeed()) && getMatchfield().isFree(getCharacter().getCornerRightUpX(), getCharacter().getCornerRightUpY() - getCharacter().getSpeed())) {
                    for (int j = getCharacter().getSpeed(); j > 0; j--) {
                        if (movementUp()) {
                            up(1);
                        }
                    }
                    //checkt ob eine der oberen Ecke frei ist und bewegt sich dementsprechend um die Figur ganz zu befreien
                } else if (getMatchfield().isFree(getCharacter().getCornerLeftUpX(), getCharacter().getCornerLeftUpY() - getCharacter().getSpeed())) {
                    left(getCharacter().getSpeed());
                } else if (getMatchfield().isFree(getCharacter().getCornerRightUpX(), getCharacter().getCornerRightUpY() - getCharacter().getSpeed())) {
                    right(getCharacter().getSpeed());
                } else {
                    //dasselbe wie vorher nur für die einzelnen Pixel um an den Rand zu kommen, sonst Abstand wie Geschwindigkeit
                    for (int i = getCharacter().getSpeed(); i > 0; i--) {
                        if (getMatchfield().isFree(getCharacter().getCornerLeftUpX(), getCharacter().getCornerLeftUpY() - i) && getMatchfield().isFree(getCharacter().getCornerRightUpX(), getCharacter().getCornerRightUpY() - i)) {
                            up(i);
                        } else if (getMatchfield().isFree(getCharacter().getCornerLeftUpX(), getCharacter().getCornerLeftUpY() - i)) {
                            left(i);
                        } else if (getMatchfield().isFree(getCharacter().getCornerRightUpX(), getCharacter().getCornerRightUpY() - i)) {
                            right(i);
                        }
                    }
                }
            }
            //checkt ob die nächste main.Position unten frei ist und ob die Taste gedrückt wurde und bewegt sich nach unten
            if (getpApplet().keyCode == getpApplet().DOWN && getCharacter().getPlayernumber() == 0 || getpApplet().key == 's' && getCharacter().getPlayernumber() == 1) {
                if (getMatchfield().isFree(getCharacter().getCornerLeftDownX(), getCharacter().getCornerLeftDownY() + getCharacter().getSpeed()) && getMatchfield().isFree(getCharacter().getCornerRightDownX(), getCharacter().getCornerRightDownY() + getCharacter().getSpeed())) {
                    for (int j = getCharacter().getSpeed(); j > 0; j--) {
                        if (movementDown()) {
                            down(1);
                        }
                    }
                    //checkt ob eine der unteren Ecke frei ist und bewegt sich dementsprechend um die Figur ganz zu befreien
                } else if (getMatchfield().isFree(getCharacter().getCornerLeftDownX(), getCharacter().getCornerLeftDownY() + getCharacter().getSpeed())) {
                    left(getCharacter().getSpeed());
                } else if (getMatchfield().isFree(getCharacter().getCornerRightDownX(), getCharacter().getCornerRightDownY() + getCharacter().getSpeed())) {
                    right(getCharacter().getSpeed());
                } else {
                    //dasselbe wie vorher nur für die einzelnen Pixel um an den Rand zu kommen, sonst Abstand wie Geschwindigkeit
                    for (int i = getCharacter().getSpeed(); i > 0; i--) {

                        if (getMatchfield().isFree(getCharacter().getCornerLeftDownX(), getCharacter().getCornerLeftDownY() + i) && getMatchfield().isFree(getCharacter().getCornerRightDownX(), getCharacter().getCornerRightDownY() + i)) {
                            down(i);
                        } else if (getMatchfield().isFree(getCharacter().getCornerLeftDownX(), getCharacter().getCornerLeftDownY() + i)) {
                            left(i);
                        } else if (getMatchfield().isFree(getCharacter().getCornerRightDownX(), getCharacter().getCornerRightDownY() + i)) {
                            right(i);
                        }
                    }
                }
            }
        }
        //Bei Leerzeichen wird eine Bombe gesetzt und erstellt
        if (getpApplet().keyCode == 32 && getCharacter().getPlayernumber() == 0
                || getpApplet().key  == 'b' && getCharacter().getPlayernumber() == 1) {
            if (getCharacter().getBombCounter() < getCharacter().getNumberOfBombs()) {
                getCharacter().setBomb(getCharacter().getBombCounter(), getField()[getMatchfield().getFieldNumber(getCharacter().getMidX(), getCharacter().getMidY())].getCornerLeftUpX(), getField()[getMatchfield().getFieldNumber(getCharacter().getMidX(), getCharacter().getMidY())].getCornerLeftUpY(), getCharacter().getBombRadius(), getMatchfield().getFieldNumber(getCharacter().getMidX(), getCharacter().getMidY()), getField(), getObstacles(), getpApplet());
                getCharacter().addBombCounter();
                getCharacter().setBombSet(true);
                getpApplet().keyCode = 1;
                PApplet.println("SetBomb");
                PApplet.println(getCharacter().getBombCounter());
            }
        }
        //Position wird wieder geupdatet
        updatePosition();
    }
}


