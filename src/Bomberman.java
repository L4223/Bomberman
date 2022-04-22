import processing.core.PApplet;

public class Bomberman extends Character{
    public Bomberman(int playernumber, Matchfield matchfield, PApplet pApplet) {
        super(playernumber, matchfield, pApplet);
        //Farbe des Spieles
        setColor(colorSelection[playernumber]);
        //Position links oben
        if (playernumber == 0) {
            setPositionXY(matchfield.getFieldWidth(), matchfield.getFieldHeight());
        }
        //Position rechts unten
        if (playernumber == 1) {
            setPositionXY(pApplet.width - matchfield.getFieldWidth() - getImageWidth(), pApplet.height - matchfield.getFieldHeight() - getImageHeight());
        }
    }
    //Farbe des Spielers, {rot, grün}
    private final int [] colorSelection = {0xFFED3833, 0xFF6DED8A};
}