package matchfield;

import processing.core.PApplet;

public class FieldController {

    final private Field[] field;
    final private FieldView view;
    final private PApplet pApplet;

    public FieldController(Matchfield matchfield, FieldView view, Field[] field, PApplet pApplet) {
        this.field = field;
        this.view = view;
        this.pApplet = pApplet;
    }
    //Getter und Setter der Variablen
    public Field[] getField() {
        return field;
    }
    public void setView() {
        view.draw(getField(), getpApplet());
    }

    public FieldView getView() {
        return view;
    }

    public PApplet getpApplet() {
        return pApplet;
    }
}
