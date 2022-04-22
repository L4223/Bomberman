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

    public Matchfield getMatchfield() {
        return matchfield;
    }

    public MatchfieldView getView() {
        return view;
    }

    public PApplet getpApplet() {
        return pApplet;
    }


    public void setMatchfield () {
        view.matchfield(getMatchfield(), getpApplet());
    }

}