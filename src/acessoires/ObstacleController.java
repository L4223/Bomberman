package acessoires;

import matchfield.Field;
import matchfield.FieldController;
import matchfield.FieldView;
import matchfield.Matchfield;
import processing.core.PApplet;

public class ObstacleController extends FieldController {
    public ObstacleController(Matchfield matchfield, FieldView view, Field[] field, PApplet pApplet) {
        super(matchfield, view, field, pApplet);
    }

    public void setView() {
        getView().draw(getField(), getpApplet());
    }
}
