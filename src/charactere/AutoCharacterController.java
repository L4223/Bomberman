package charactere;

import hilfsKlassen.DirectionMovement;
import matchfield.Field;
import matchfield.Matchfield;
import processing.core.PApplet;

public class AutoCharacterController extends CharacterController {

    private AutoCharacter autoCharacter;
    private DirectionMovement directions = new DirectionMovement(getpApplet());

    public AutoCharacterController(AutoCharacter autoCharacter, AutoCharacterView view, Matchfield matchfield, Field[] field, PApplet pApplet) {
        super(autoCharacter, view, matchfield, field, pApplet);
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
    public void movement () {
        //checkt ob die Richtung rechts ist
        if (getAutoCharacter().getDirection().equals(getDirections().getRight())) {
            //wenn sie rechts ist geht es solange in die Richtung bis rechts nichts mehr frei ist
            if (getMatchfield().isFree(getCharacter().getCornerRightUpX() + getCharacter().getSpeed(), getCharacter().getCornerRightUpY())
                    && getMatchfield().isFree(getCharacter().getCornerRightDownX() + getCharacter().getSpeed(), getCharacter().getCornerRightDownY())) {
                right(getCharacter().getSpeed());
                getAutoCharacter().setDirection(getDirections().getRight());
            } else if (getMatchfield().isFree(getCharacter().getCornerRightUpX() + getCharacter().getSpeed(), getCharacter().getCornerRightUpY())) {
                up(getCharacter().getSpeed());
            } else if (getMatchfield().isFree(getCharacter().getCornerRightDownX() + getCharacter().getSpeed(), getCharacter().getCornerRightDownY())) {
                down(getCharacter().getSpeed());
            } else {
                for (int i = getCharacter().getSpeed(); i > 0; i--) {
                    if (getMatchfield().isFree(getCharacter().getCornerLeftDownX() + i, getCharacter().getCornerLeftDownY())
                            && getMatchfield().isFree(getCharacter().getCornerRightDownX() + i, getCharacter().getCornerRightDownY())) {
                        right(i);
                        getAutoCharacter().setDirection(getDirections().getRight());
                    }
                }
                //Richtung wird sonst random gewechselt
                getAutoCharacter().setDirection(getDirections().getRandomDirection());
            }
        }
        //checkt ob die Richtung unten ist
        if (getAutoCharacter().getDirection().equals(getDirections().getDown())) {
            //wenn sie unten ist geht es solange in die Richtung bis unten nichts mehr frei ist
            if (getMatchfield().isFree(getCharacter().getCornerLeftDownX(), getCharacter().getCornerLeftDownY() + getCharacter().getSpeed())
                    && getMatchfield().isFree(getCharacter().getCornerRightDownX(), getCharacter().getCornerRightDownY() + getCharacter().getSpeed())) {
                down(getCharacter().getSpeed());
                getAutoCharacter().setDirection(getDirections().getDown());
            } else if (getMatchfield().isFree(getCharacter().getCornerLeftDownX(), getCharacter().getCornerLeftDownY() + getCharacter().getSpeed())) {
                left(getCharacter().getSpeed());
            } else if (getMatchfield().isFree(getCharacter().getCornerRightDownX(), getCharacter().getCornerRightDownY() + getCharacter().getSpeed())) {
                right(getCharacter().getSpeed());
            } else {
                for (int i = getCharacter().getSpeed(); i > 0; i--) {
                    if (getMatchfield().isFree(getCharacter().getCornerLeftDownX(), getCharacter().getCornerLeftDownY() + i)
                            && getMatchfield().isFree(getCharacter().getCornerRightDownX(), getCharacter().getCornerRightDownY() + i)) {
                        down(i);
                        getAutoCharacter().setDirection(getDirections().getDown());
                    }
                }
                //Richtung wird sonst random gewechselt
                getAutoCharacter().setDirection(getDirections().getRandomDirection());
            }
        }
        //checkt ob die Richtung oben ist
        if (getAutoCharacter().getDirection().equals(getDirections().getUp())) {
            //wenn sie unten ist geht es solange in die Richtung bis unten nichts mehr frei ist
            if (getMatchfield().isFree(getCharacter().getCornerRightUpX(), getCharacter().getCornerRightUpY() - getCharacter().getSpeed())
                    && getMatchfield().isFree(getCharacter().getCornerLeftUpX(), getCharacter().getCornerLeftUpY() - getCharacter().getSpeed())) {
                up(getCharacter().getSpeed());
                getAutoCharacter().setDirection(getDirections().getUp());
            } else if (getMatchfield().isFree(getCharacter().getCornerLeftUpX(), getCharacter().getCornerLeftUpY() - getCharacter().getSpeed())) {
                left(getCharacter().getSpeed());
            } else if (getMatchfield().isFree(getCharacter().getCornerRightUpX(), getCharacter().getCornerRightUpY() - getCharacter().getSpeed())) {
                right(getCharacter().getSpeed());
            } else {
                for (int i = getCharacter().getSpeed(); i > 0; i--) {
                    if (getMatchfield().isFree(getCharacter().getCornerRightUpX(), getCharacter().getCornerRightUpY() - i)
                            && getMatchfield().isFree(getCharacter().getCornerLeftUpX(), getCharacter().getCornerLeftUpY() - i)) {
                        up(i);
                        getAutoCharacter().setDirection(getDirections().getUp());
                    }
                }
                //Richtung wird sonst random gewechselt
                getAutoCharacter().setDirection(getDirections().getRandomDirection());
            }
        }
        //checkt ob die Richtung links ist
        if (getAutoCharacter().getDirection().equals(getDirections().getLeft())) {
            //wenn sie links ist geht es solange in die Richtung bis links nichts mehr frei ist
            if (getMatchfield().isFree(getCharacter().getCornerLeftUpX() - getCharacter().getSpeed(), getCharacter().getCornerLeftUpY())
                    && getMatchfield().isFree(getCharacter().getCornerLeftDownX() - getCharacter().getSpeed(), getCharacter().getCornerLeftDownY())) {
                left(getCharacter().getSpeed());
                getAutoCharacter().setDirection(getDirections().getLeft());
            } else if (getMatchfield().isFree(getCharacter().getCornerLeftUpX() - getCharacter().getSpeed(), getCharacter().getCornerLeftUpY())) {
                up(getCharacter().getSpeed());
            } else if (getMatchfield().isFree(getCharacter().getCornerLeftDownX() - getCharacter().getSpeed(), getCharacter().getCornerLeftDownY())) {
                down(getCharacter().getSpeed());
            } else {
                for (int i = getCharacter().getSpeed(); i >= 0; i--) {
                    if (getMatchfield().isFree(getCharacter().getCornerLeftUpX() - i, getCharacter().getCornerLeftUpY())
                            && getMatchfield().isFree(getCharacter().getCornerLeftDownX() - i, getCharacter().getCornerLeftDownY())) {
                        left(i);
                        getAutoCharacter().setDirection(getDirections().getLeft());
                    }
                }
                //Richtung wird sonst random gewechselt
                getAutoCharacter().setDirection(getDirections().getRandomDirection());
            }
        }
        updatePosition();
        if(getpApplet().frameCount % 120 == 0) getAutoCharacter().setDirection(getDirections().getRandomDirection(getAutoCharacter().getDirection()));
    }
}