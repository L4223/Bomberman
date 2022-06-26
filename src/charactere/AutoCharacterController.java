package charactere;

import acessoires.Obstacle;
import hilfsKlassen.DirectionMovement;
import matchfield.Field;
import matchfield.Matchfield;
import processing.core.PApplet;

public class AutoCharacterController extends CharacterController {

    private AutoCharacter autoCharacter;
    private DirectionMovement directions = new DirectionMovement(getpApplet());

    public AutoCharacterController(AutoCharacter autoCharacter, CharacterView view, Matchfield matchfield, Field[] field, Obstacle[] obstacles, PApplet pApplet) {
        super(autoCharacter, view, matchfield, field, obstacles, pApplet);
        setAutoCharacter(autoCharacter);
        //Erstellt eine Klasse DirectionMovement mit dem Inhalt von rechts, links, unten, oben
        setDirections(new DirectionMovement(pApplet));
    }

    private DirectionMovement getDirections() {
        return directions;
    }

    private void setDirections(DirectionMovement directions) {
        this.directions = directions;
    }

    private void setAutoCharacter(AutoCharacter autoCharacter) {
        this.autoCharacter = autoCharacter;
    }

    public AutoCharacter getAutoCharacter() {
        return autoCharacter;
    }






    @Override

    public void movement() {

            //checkt ob die nächste main.Position links frei ist und ob die Taste gedrückt wurde und bewegt sich nach links
            if (getAutoCharacter().getDirection().equals(getDirections().getLeft())) {
                if (getMatchfield().isFree(getCharacter().getCornerLeftUpX() - getCharacter().getSpeed(), getCharacter().getCornerLeftUpY()) && getMatchfield().isFree(getCharacter().getCornerLeftDownX() - getCharacter().getSpeed(), getCharacter().getCornerLeftDownY())) {
                    for (int j = getCharacter().getSpeed(); j > 0; j--) {
                        if (movementLeft()) {
                            left(1);
                        } else {
                            getAutoCharacter().setDirection(getDirections().getRandomDirection());
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
                    getAutoCharacter().setDirection(getDirections().getRandomDirection());

                }
            }
            //checkt ob die nächste main.Position rechts frei ist und ob die Taste gedrückt wurde und bewegt sich nach rechts
            if (getAutoCharacter().getDirection().equals(getDirections().getRight())) {
                if (getMatchfield().isFree(getCharacter().getCornerRightUpX() + getCharacter().getSpeed(), getCharacter().getCornerRightUpY()) && getMatchfield().isFree(getCharacter().getCornerRightDownX() + getCharacter().getSpeed(), getCharacter().getCornerRightDownY())) {
                    for (int j = getCharacter().getSpeed(); j > 0; j--) {
                        if (movementRight()) {
                            right(1);
                        } else {
                            getAutoCharacter().setDirection(getDirections().getRandomDirection());
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
                    getAutoCharacter().setDirection(getDirections().getRandomDirection());

                }

            }

            //checkt ob die nächste main.Position oben frei ist und ob die Taste gedrückt wurde und bewegt sich nach oben
            if (getAutoCharacter().getDirection().equals(getDirections().getUp())) {
                if (getMatchfield().isFree(getCharacter().getCornerLeftUpX(), getCharacter().getCornerLeftUpY() - getCharacter().getSpeed())
                        && getMatchfield().isFree(getCharacter().getCornerRightUpX(), getCharacter().getCornerRightUpY() - getCharacter().getSpeed())) {
                    for (int j = getCharacter().getSpeed(); j > 0; j--) {
                        if (movementUp()) {
                            up(1);
                        } else {
                            getAutoCharacter().setDirection(getDirections().getRandomDirection());
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
                    getAutoCharacter().setDirection(getDirections().getRandomDirection());

                }
            }
            //checkt ob die nächste main.Position unten frei ist und ob die Taste gedrückt wurde und bewegt sich nach unten
            if (getAutoCharacter().getDirection().equals(getDirections().getDown())) {
                if (getMatchfield().isFree(getCharacter().getCornerLeftDownX(), getCharacter().getCornerLeftDownY() + getCharacter().getSpeed()) && getMatchfield().isFree(getCharacter().getCornerRightDownX(), getCharacter().getCornerRightDownY() + getCharacter().getSpeed())) {
                    for (int j = getCharacter().getSpeed(); j > 0; j--) {
                        if (movementDown()) {
                            down(1);
                        } else {
                            getAutoCharacter().setDirection(getDirections().getRandomDirection());
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
                    getAutoCharacter().setDirection(getDirections().getRandomDirection());

                }



        }



        updatePosition();
        if(getpApplet().frameCount % 120 == 0) getAutoCharacter().setDirection(getDirections().getRandomDirection(getAutoCharacter().getDirection()));
    }
}

