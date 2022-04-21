import processing.core.PApplet;

public class MatchfieldView {

    //zeichnet Spielfeld
    public void matchfield(Matchfield matchfield, PApplet pApplet) {
        pApplet.noStroke();
        for (int x = 0; x < matchfield.getWidth(); x += matchfield.getFieldWidth()) {
            for (int y = 0; y < matchfield.getHeight(); y += matchfield.getFieldHeight()) {
                //erstellt die weißen Felder in dem mittleren Teil
                if (x == 0
                        || x == matchfield.getWidth() - matchfield.getFieldWidth()
                        || y == 0
                        || y == matchfield.getHeight()  - matchfield.getFieldHeight()
                        || x % (matchfield.getFieldWidth() * 2) == 0 && y % (matchfield.getFieldHeight() * 2) == 0) {
                    pApplet.fill(255);
                    pApplet.rect(x, y, x + matchfield.getFieldWidth(), y + matchfield.getFieldHeight());

                //zeichnet die restliche Fläche in Blau
                } else {
                    pApplet.fill(0, 0, 255);
                    pApplet.rect(x, y, x + matchfield.getFieldWidth(), y + matchfield.getFieldHeight());
                }
            }
        }
    }
}
