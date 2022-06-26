package matchfield;

import processing.core.PApplet;

public class FieldController extends MatchfieldController{


    public FieldController(Matchfield matchfield, FieldView view, Field[] field, PApplet pApplet) {
        super(matchfield, view, pApplet);
        this.field = field;
        this.view = view;
        this.pApplet = pApplet;
    }

    final private Field[] field;
    final private FieldView view;
    final private PApplet pApplet;



    public Field[] getField() {
        return field;
    }

    public FieldView getView() {
        return view;
    }

    public PApplet getpApplet() {
        return pApplet;
    }


    public void setView() {
        view.draw(getField(), getpApplet());
    }
}
