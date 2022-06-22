package charactere;

import matchfield.Matchfield;
import hilfsKlassen.DirectionMovement;
import processing.core.PApplet;

public class AutoCharacter extends Character {
    private DirectionMovement directionMovement;

    public AutoCharacter(int playernumber, Matchfield matchfield, PApplet pApplet) {
        super(playernumber, matchfield, pApplet);
        directionMovement = new DirectionMovement("left");
        //main.Position rechts oben
        if (playernumber == 0) {
            setPositionXY(pApplet.width - matchfield.getFieldWidth() - getImageWidth(), matchfield.getFieldHeight());
            setImage(pApplet.loadImage("images/bombermanGegner.png"));
        }
        //main.Position links unten
        if (playernumber == 1) {
            setPositionXY(matchfield.getFieldWidth(), pApplet.height - matchfield.getFieldHeight() -getImageHeight());
            setImage(pApplet.loadImage("images/bombermanGegner2.png"));
        }
        //main.Position rechts unten
        if (playernumber == 2) {
            setPositionXY(pApplet.width - matchfield.getFieldWidth() - getImageWidth(), pApplet.height - matchfield.getFieldHeight() - getImageHeight());
            setImage(pApplet.loadImage("images/bombermanGegner3.png"));
        }
    }


    public DirectionMovement getDirectionMovement() {
        return directionMovement;
    }

    public void setDirection(String direction) {
        getDirectionMovement().setDirection(direction);
    }

    public String getDirection() {
        return directionMovement.getDirection();
    }

}
