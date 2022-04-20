import processing.core.PApplet;

public class MatchfieldController {

    private Matchfield matchfield;
    private MatchfieldView view;
    private PApplet pApplet;

    public MatchfieldController(Matchfield matchfield, MatchfieldView view, PApplet pApplet) {
        this.matchfield = matchfield;
        this.view = view;
        this.pApplet = pApplet;
    }

//    //checkt ob eine Position frei ist
//    public boolean isFree(int positionX, int positionY) {
//        //schneller check ob der Rand betroffen ist
//        if (positionX < matchfield.getFieldWidth()
//        || positionX > matchfield.getWidth() - matchfield.getFieldWidth()
//        || positionY < matchfield.getFieldHeight()
//                || positionY > matchfield.getHeight() - matchfield.getFieldHeight()) {
//            matchfield.setFree(false);
//        } else {
//            //check ob die Felder in der Mitte getroffen werden mit Hilfe einer for-Schleife, gleich wie beim zeichnen
//            forSchleife:
//            for (int x = matchfield.getFieldWidth(); x < matchfield.getWidth() - matchfield.getFieldWidth(); x += matchfield.getFieldWidth()) {
//                for (int y = matchfield.getFieldHeight(); y < matchfield.getHeight() - matchfield.getFieldHeight(); y += matchfield.getFieldHeight()) {
//
//                    if (x % (matchfield.getFieldWidth() * 2) == 0 && y % (matchfield.getFieldHeight() * 2) == 0) {
//                        if (positionX > x && positionX < x + matchfield.getFieldWidth()
//                                && positionY > y
//                                && positionY < y + matchfield.getFieldHeight() ) {
//                            matchfield.setFree(false);
//                            break forSchleife;
//                        } else {
//                            matchfield.setFree(true);
//                        }
//                    }
//                }
//            }
//        }
//        return matchfield.setFree();
//    }

    public void setMatchfield () {
        view.matchfield(matchfield, pApplet);
    }

}
