package charactere;

import processing.core.PApplet;

public abstract class CharacterController {

    private PApplet pApplet;
    private Character character;
    private CharacterView view;

    public CharacterController (Character character, CharacterView view, PApplet pApplet) {
        setCharacter(character);
        setView(view);
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

}
