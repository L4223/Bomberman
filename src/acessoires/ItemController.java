package acessoires;

import matchfield.FieldController;
import matchfield.FieldView;
import matchfield.Matchfield;
import processing.core.PApplet;

public class ItemController extends FieldController {
    public ItemController(Matchfield matchfield, FieldView view, Item[] items, PApplet pApplet) {
        super(matchfield, view, items, pApplet);
    }

    public void setView() {
        getView().draw(getField(), getpApplet());
    }

}
