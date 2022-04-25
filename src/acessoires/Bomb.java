package acessoires;//noch nicht benutzt

import main.Position;

public class Bomb extends Position {
    private int explosionRadius;
    private String color;
    private boolean exploded;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public boolean isExploded() {
        return exploded;
    }

    public int getExplosionRadius() {
        return explosionRadius;
    }

    public void setExploded(boolean exploded) {
        this.exploded = exploded;
    }

    public void setExplosionRadius(int explosionRadius) {
        this.explosionRadius = explosionRadius;
    }
}
