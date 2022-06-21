package charactere;

import matchfield.Field;
import matchfield.Matchfield;
import processing.core.PApplet;

public abstract class CharacterController {

    private PApplet pApplet;
    private Character character;
    private CharacterView view;

    private Matchfield matchfield;

    private Field[] field;

    public CharacterController (Character character, CharacterView view, Matchfield matchfield, Field[] field, PApplet pApplet) {
        setCharacter(character);
        setView(view);
        setMatchfield(matchfield);
        setField(field);
        setpApplet(pApplet);

    }


    private void setpApplet(PApplet pApplet) {
        this.pApplet = pApplet;
    }

    public PApplet getpApplet() {
        return pApplet;
    }

    private void setCharacter(Character bomberman) {
        this.character = bomberman;
    }

    public Character getCharacter() {
        return character;
    }

    private void setView(CharacterView view) {
        this.view = view;
    }

    public Matchfield getMatchfield() {
        return matchfield;
    }

    public void setMatchfield(Matchfield matchfield) {
        this.matchfield = matchfield;
    }

    public Field[] getField() {
        return field;
    }

    public void setField(Field[] field) {
        this.field = field;
    }

    public CharacterView getView() {
        return view;
    }

    //läuft in die gegebene Richtung
    public void left(int speed) {
        getCharacter().setPositionX(getCharacter().getPositionX() - speed);
        updatePosition();
    }
    public void right(int speed) {
        getCharacter().setPositionX(getCharacter().getPositionX() + speed);
        updatePosition();
    }
    public void down(int speed) {
        getCharacter().setPositionY(getCharacter().getPositionY() + speed);
        updatePosition();
    }
    public void up(int speed) {
        getCharacter().setPositionY(getCharacter().getPositionY()- speed);
        updatePosition();
    }






    //Die Positionen der verschiedenen Ecken werden aktualisiert
    public void updatePosition() {

        getCharacter().setCornerLeftUpX();
        getCharacter().setCornerLeftUpY();
        getCharacter().setCornerLeftDownX();
        getCharacter().setCornerLeftDownY();
        getCharacter().setCornerRightUpX();
        getCharacter().setCornerRightUpY();
        getCharacter().setCornerRightDownX();
        getCharacter().setCornerRightDownY();
    }
    //Die Ansicht wird mit den neuest Daten geupdatet
    public void updateView () {
        updatePosition();
        getView().draw(getCharacter(), getpApplet());
    }

    //abstrakte Funktion die in den Unterklassen verwendet wird
    public abstract void movement ();

    public boolean movementDown() {
        boolean move = true;
        forSchleife:
        for (int i = 0; i < getField().length; i++) {
            if (!(getField()[i].isEmpty())) {
                if (getField()[i].getCornerLeftUpX() <= getCharacter().getCornerLeftDownX()
                        && getField()[i].getCornerRightUpX() >= getCharacter().getCornerRightDownX()
                        && getField()[i].getCornerLeftUpY() == getCharacter().getCornerRightDownY()
                        && getField()[i].getCornerRightUpY() == getCharacter().getCornerLeftDownY()) {
                    move = false;
                    break forSchleife;

                } else {
                    move = true;
                }
            }
        }
        return move;
    }

    public boolean movementUp() {
        boolean move = true;
        forSchleife:
        for (int i = 0; i < getField().length; i++) {
            if (!(getField()[i].isEmpty())) {
                if (getField()[i].getCornerLeftDownX() <= getCharacter().getCornerLeftUpX()
                        && getField()[i].getCornerRightDownX() >= getCharacter().getCornerRightUpX()
                        && getField()[i].getCornerLeftDownY() == getCharacter().getCornerRightUpY()
                        && getField()[i].getCornerRightDownY() == getCharacter().getCornerLeftUpY()) {
                    move = false;
                    break forSchleife;

                } else {
                    move = true;
                }
            }
        }
        return move;
    }

    public boolean movementRight() {
        boolean move = true;
        forSchleife:
        for (int i = 0; i < getField().length; i++) {
            if (!(getField()[i].isEmpty())) {
                if (getField()[i].getCornerLeftUpY() <= getCharacter().getCornerRightUpY()
                        && getField()[i].getCornerLeftDownY() >= getCharacter().getCornerRightDownY()
                        && getField()[i].getCornerLeftUpX() == getCharacter().getCornerRightUpX()
                        && getField()[i].getCornerLeftDownX() == getCharacter().getCornerRightDownX()) {
                    move = false;
                    break forSchleife;

                } else {
                    move = true;
                }
            }
        }
        return move;
    }

    public boolean movementLeft() {
        boolean move = true;
        forSchleife:
        for (int i = 0; i < getField().length; i++) {
            if (!(getField()[i].isEmpty())) {
                if (
                        getField()[i].getCornerRightUpY() <= getCharacter().getCornerLeftUpY()
                                && getField()[i].getCornerRightDownY() >= getCharacter().getCornerLeftDownY()
                                && getField()[i].getCornerRightUpX() == getCharacter().getCornerLeftUpX()
                                && getField()[i].getCornerRightDownX() == getCharacter().getCornerLeftDownX()) {
                    move = false;
                    break forSchleife;

                } else {
                    move = true;
                }
            }
        }
        return move;
    }

}
