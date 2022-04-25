package charactere;

import matchfield.Matchfield;
import hilfsKlassen.DirectionMovement;
import processing.core.PApplet;

public class AutoCharacter extends Character {
    private DirectionMovement directionMovement;

    public AutoCharacter(int playernumber, Matchfield matchfield, PApplet pApplet) {
        super(playernumber, matchfield, pApplet);
        setColor(colorSelection[playernumber]);
        directionMovement = new DirectionMovement("left");
        //main.Position rechts oben
        if (playernumber == 0) {
            setPositionXY(pApplet.width - matchfield.getFieldWidth() - getImageWidth(), matchfield.getFieldHeight());
        }
        //main.Position links unten
        if (playernumber == 1) {
            setPositionXY(matchfield.getFieldWidth(), pApplet.height - matchfield.getFieldHeight() -getImageHeight());
        }
        //main.Position rechts unten
        if (playernumber == 2) {
            setPositionXY(pApplet.width - matchfield.getFieldWidth() - getImageWidth(), pApplet.height - matchfield.getFieldHeight() - getImageHeight());
        }
    }

    //Farbe des Spielers, {pink, gelb, grün}
    private final int [] colorSelection = {0xFFFF5F85, 0xFFF0F14E, 0xFF6DED8A};

    public DirectionMovement getDirectionMovement() {
        return directionMovement;
    }

    public void setDirection(String direction) {
        getDirectionMovement().setDirection(direction);
    }

    public String getDirection() {
        return directionMovement.getDirection();
    }

    private void setDirectionMovement(DirectionMovement direction) {
        this.directionMovement = direction;
    }
}
