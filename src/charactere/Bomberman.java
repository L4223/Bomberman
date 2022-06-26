package charactere;

import matchfield.Matchfield;
import processing.core.PApplet;
import matchfield.Field;
import processing.core.PImage;

public class Bomberman extends Character {
    //erstellt Spieler und übernimmt die Eigenchaften der Superklasse
    public Bomberman(int playernumber, Matchfield matchfield,  PApplet pApplet) {
        super(playernumber, matchfield, pApplet);
        //main.Position links oben
        if (playernumber == 0) {
            setPositionXY(matchfield.getFieldWidth(), matchfield.getFieldHeight());
            setImage(pApplet.loadImage("images/bombermanPlayer.png"));
        }
        //main.Position rechts unten
        if (playernumber == 1) {
            setPositionXY(pApplet.width - matchfield.getFieldWidth() - getImageWidth(), pApplet.height - matchfield.getFieldHeight() - getImageHeight());
            setImage(pApplet.loadImage("images/bombermanGegner.png"));
        }
    }
}
