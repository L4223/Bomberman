package charactere;

import processing.core.PApplet;

public class BombermanController extends CharacterController {
    

    public BombermanController(Bomberman bomberman, BombermanView view, PApplet pApplet) {
        super(bomberman, view, pApplet);
    }


    @Override
    public void movement() {
        if (getpApplet().keyPressed) {
            //checkt ob die nächste main.Position links frei ist und ob die Taste gedrückt wurde und bewegt sich nach links
            if (getpApplet().keyCode == getpApplet().LEFT && getCharacter().getPlayernumber() == 0
                    || getpApplet().key == 'a' && getCharacter().getPlayernumber() == 1) {
                if (getCharacter().getMatchfield().isFree(getCharacter().getCornerLeftUpX() - getCharacter().getSpeed(), getCharacter().getCornerLeftUpY())
                        && getCharacter().getMatchfield().isFree(getCharacter().getCornerLeftDownX() - getCharacter().getSpeed(), getCharacter().getCornerLeftDownY())) {
                    left(getCharacter().getSpeed());
                    //checkt ob eine der linken Ecke frei ist und bewegt sich dementsprechend um die Figur ganz zu befreien
                } else if (getCharacter().getMatchfield().isFree(getCharacter().getCornerLeftUpX() - getCharacter().getSpeed(), getCharacter().getCornerLeftUpY())) {
                    up(getCharacter().getSpeed());
                } else if (getCharacter().getMatchfield().isFree(getCharacter().getCornerLeftDownX() - getCharacter().getSpeed(), getCharacter().getCornerLeftDownY())) {
                    down(getCharacter().getSpeed());
                } else {
                    //dasselbe wie vorher nur für die einzelnen Pixel um an den Rand zu kommen, sonst Abstand wie Geschwindigkeit
                    for (int i = getCharacter().getSpeed(); i > 0; i--) {
                        if (getCharacter().getMatchfield().isFree(getCharacter().getCornerLeftUpX() - i, getCharacter().getCornerLeftUpY())
                                && getCharacter().getMatchfield().isFree(getCharacter().getCornerLeftDownX() - i, getCharacter().getCornerLeftDownY())) {
                            left(i);
                        } else if (getCharacter().getMatchfield().isFree(getCharacter().getCornerLeftUpX() - i, getCharacter().getCornerLeftUpY())) {
                            up(i);
                        } else if (getCharacter().getMatchfield().isFree(getCharacter().getCornerLeftDownX() - i, getCharacter().getCornerLeftDownY())) {
                            down(i);
                        }
                    }
                }
            }
            //checkt ob die nächste main.Position rechts frei ist und ob die Taste gedrückt wurde und bewegt sich nach rechts
            if (getpApplet().keyCode == getpApplet().RIGHT && getCharacter().getPlayernumber() == 0
                    || getpApplet().key == 'd' && getCharacter().getPlayernumber() == 1) {
                if (getCharacter().getMatchfield().isFree(getCharacter().getCornerRightUpX() + getCharacter().getSpeed(), getCharacter().getCornerRightUpY())
                        && getCharacter().getMatchfield().isFree(getCharacter().getCornerRightDownX() + getCharacter().getSpeed(), getCharacter().getCornerRightDownY())) {
                    right(getCharacter().getSpeed());
                    //checkt ob eine der rechten Ecke frei ist und bewegt sich dementsprechend um die Figur ganz zu befreien
                } else if (getCharacter().getMatchfield().isFree(getCharacter().getCornerRightUpX() + getCharacter().getSpeed(), getCharacter().getCornerRightUpY())) {
                    up(getCharacter().getSpeed());
                } else if (getCharacter().getMatchfield().isFree(getCharacter().getCornerRightDownX() + getCharacter().getSpeed(), getCharacter().getCornerRightDownY())) {
                    down(getCharacter().getSpeed());
                } else {
                    //dasselbe wie vorher nur für die einzelnen Pixel um an den Rand zu kommen, sonst Abstand wie Geschwindigkeit
                    for (int i = getCharacter().getSpeed(); i > 0; i--) {
                        if (getCharacter().getMatchfield().isFree(getCharacter().getCornerRightUpX() + i, getCharacter().getCornerRightUpY())
                                && getCharacter().getMatchfield().isFree(getCharacter().getCornerRightDownX() + i, getCharacter().getCornerRightDownY())) {
                            right(i);
                        } else if (getCharacter().getMatchfield().isFree(getCharacter().getCornerRightUpX() + i, getCharacter().getCornerRightUpY())) {
                            up(i);
                        } else if (getCharacter().getMatchfield().isFree(getCharacter().getCornerRightDownX() + i, getCharacter().getCornerRightDownY())) {
                            down(i );
                        }
                    }
                }
            }
            //checkt ob die nächste main.Position oben frei ist und ob die Taste gedrückt wurde und bewegt sich nach oben
            if (getpApplet().keyCode == getpApplet().UP && getCharacter().getPlayernumber() == 0
                    || getpApplet().key == 'w' && getCharacter().getPlayernumber() == 1) {
                if (getCharacter().getMatchfield().isFree(getCharacter().getCornerLeftUpX(), getCharacter().getCornerLeftUpY() - getCharacter().getSpeed())
                        && getCharacter().getMatchfield().isFree(getCharacter().getCornerRightUpX(), getCharacter().getCornerRightUpY() - getCharacter().getSpeed())) {
                    up(getCharacter().getSpeed());
                    //checkt ob eine der oberen Ecke frei ist und bewegt sich dementsprechend um die Figur ganz zu befreien
                } else if (getCharacter().getMatchfield().isFree(getCharacter().getCornerLeftUpX(), getCharacter().getCornerLeftUpY() - getCharacter().getSpeed())) {
                    left(getCharacter().getSpeed());
                } else if (getCharacter().getMatchfield().isFree(getCharacter().getCornerRightUpX(), getCharacter().getCornerRightUpY() - getCharacter().getSpeed())) {
                    right(getCharacter().getSpeed());
                } else {
                    //dasselbe wie vorher nur für die einzelnen Pixel um an den Rand zu kommen, sonst Abstand wie Geschwindigkeit
                    for (int i = getCharacter().getSpeed(); i > 0; i--) {
                        if (getCharacter().getMatchfield().isFree(getCharacter().getCornerLeftUpX(), getCharacter().getCornerLeftUpY() - i)
                                && getCharacter().getMatchfield().isFree(getCharacter().getCornerRightUpX(), getCharacter().getCornerRightUpY() - i)) {
                            up(i);
                        } else if (getCharacter().getMatchfield().isFree(getCharacter().getCornerLeftUpX(), getCharacter().getCornerLeftUpY() - i)) {
                            left(i);
                        } else if (getCharacter().getMatchfield().isFree(getCharacter().getCornerRightUpX(), getCharacter().getCornerRightUpY() - i)) {
                            right(i);
                        }
                    }
                }
            }
            //checkt ob die nächste main.Position unten frei ist und ob die Taste gedrückt wurde und bewegt sich nach unten
            if (getpApplet().keyCode == getpApplet().DOWN && getCharacter().getPlayernumber() == 0
                    || getpApplet().key == 's' && getCharacter().getPlayernumber() == 1) {
                if (getCharacter().getMatchfield().isFree(getCharacter().getCornerLeftDownX(), getCharacter().getCornerLeftDownY() + getCharacter().getSpeed())
                        && getCharacter().getMatchfield().isFree(getCharacter().getCornerRightDownX(), getCharacter().getCornerRightDownY() + getCharacter().getSpeed())) {
                    down(getCharacter().getSpeed());
                    //checkt ob eine der unteren Ecke frei ist und bewegt sich dementsprechend um die Figur ganz zu befreien
                } else if (getCharacter().getMatchfield().isFree(getCharacter().getCornerLeftDownX(), getCharacter().getCornerLeftDownY() + getCharacter().getSpeed())) {
                    left(getCharacter().getSpeed());
                } else if (getCharacter().getMatchfield().isFree(getCharacter().getCornerRightDownX(), getCharacter().getCornerRightDownY() + getCharacter().getSpeed())) {
                    right(getCharacter().getSpeed());
                } else {
                    //dasselbe wie vorher nur für die einzelnen Pixel um an den Rand zu kommen, sonst Abstand wie Geschwindigkeit
                    for (int i = getCharacter().getSpeed(); i > 0; i--) {
                        if (getCharacter().getMatchfield().isFree(getCharacter().getCornerLeftDownX(), getCharacter().getCornerLeftDownY() + i)
                                && getCharacter().getMatchfield().isFree(getCharacter().getCornerRightDownX(), getCharacter().getCornerRightDownY() + i)) {
                            down(i);
                        } else if (getCharacter().getMatchfield().isFree(getCharacter().getCornerLeftDownX(), getCharacter().getCornerLeftDownY() + i)) {
                            left(i);
                        } else if (getCharacter().getMatchfield().isFree(getCharacter().getCornerRightDownX(), getCharacter().getCornerRightDownY() + i)) {
                            right(i);
                        }
                    }
                }
            }
        }
        updatePosition();
    }
}
