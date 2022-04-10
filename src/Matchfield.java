// nocht nicht benutzt

public class Matchfield extends Position{
    private boolean visible;
    private boolean taken;

    public boolean isTaken() {
        return taken;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
