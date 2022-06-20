package charactere;

import matchfield.Field;
import matchfield.Matchfield;
import processing.core.PApplet;

public class BombermanController extends CharacterController {


    boolean move;


    public BombermanController(Bomberman bomberman, BombermanView view, Matchfield matchfield, Field[] field, PApplet pApplet) {
        super(bomberman, view, matchfield, field, pApplet);
    }

    public boolean movementDown(int positionFirstY, int positionSecondY) {
        boolean move = true;
        forSchleife:
        for (int i = 0; i < getField().length; i++) {
//                    getpApplet().println(i);
            if (!(getField()[i].isEmpty())) {
                if (getField()[i].getCornerLeftUpX() <= getCharacter().getCornerLeftDownX() && getField()[i].getCornerRightUpX() >= getCharacter().getCornerRightDownX() && getField()[i].getCornerLeftUpY() == positionFirstY && getField()[i].getCornerRightUpY() == positionSecondY) {
                    move = false;
                    break forSchleife;

                } else {
//                            getpApplet().println("testb");
//                            printPositionOne(getCharacter());
//                            printPositionTwo(getField()[21]);
                    move = true;
                }
            }
        }


//        getpApplet().println("testc");
        return move;
    }


    public void printPositionOne(Character bomberman) {
        getpApplet().println("LinksObenX: " + bomberman.getCornerLeftUpX() + "\nLinksObenY: " + bomberman.getCornerLeftUpY() + "\nLinksUntenX: " + bomberman.getCornerLeftDownX() + "\nLinksUntenY: " + bomberman.getCornerLeftDownY() + "\nRechtsObenX: " + bomberman.getCornerRightUpX() + "\nRechtsObenY: " + bomberman.getCornerRightUpY() + "\nRechtsUntenX: " + bomberman.getCornerRightDownX() + "\nRechtsUntenY: " + bomberman.getCornerRightDownY());
    }

    public void printPositionTwo(Field bomberman) {
        getpApplet().println("LinksObenX: " + bomberman.getCornerLeftUpX() + "\nLinksObenY: " + bomberman.getCornerLeftUpY() + "\nLinksUntenX: " + bomberman.getCornerLeftDownX() + "\nLinksUntenY: " + bomberman.getCornerLeftDownY() + "\nRechtsObenX: " + bomberman.getCornerRightUpX() + "\nRechtsObenY: " + bomberman.getCornerRightUpY() + "\nRechtsUntenX: " + bomberman.getCornerRightDownX() + "\nRechtsUntenY: " + bomberman.getCornerRightDownY());
    }


    @Override
    public void movement() {

        if (getpApplet().keyPressed) {
            //checkt ob die nächste main.Position links frei ist und ob die Taste gedrückt wurde und bewegt sich nach links
            if (getpApplet().keyCode == getpApplet().LEFT && getCharacter().getPlayernumber() == 0 || getpApplet().key == 'a' && getCharacter().getPlayernumber() == 1) {
                if (getMatchfield().isFree(getCharacter().getCornerLeftUpX() - getCharacter().getSpeed(), getCharacter().getCornerLeftUpY()) && getMatchfield().isFree(getCharacter().getCornerLeftDownX() - getCharacter().getSpeed(), getCharacter().getCornerLeftDownY())) {
                    left(getCharacter().getSpeed());
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
                    right(getCharacter().getSpeed());
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
                    up(getCharacter().getSpeed());
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
                    down(getCharacter().getSpeed());
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

        if (getpApplet().keyCode == 32 && getCharacter().getPlayernumber() == 0) {

        }

        if (getpApplet().keyCode == 32 && getCharacter().getPlayernumber() == 1) {

        }

        updatePosition();
    }
}


