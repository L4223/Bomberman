package acessoires;//noch nicht benutzt

import main.Position;

public class Bomb extends Position {
    private int explosionRadius;
    private String color;
    private boolean exploded;
    private boolean dropped;

    public Bomb(int positionX, int positionY) {
        super(positionX, positionY);
    }

    //radius
    //delay

//    public void dropBomb() {
//
//        int scaleSize = gameTimer.getTime() - bombObject.dropTime;
//
//        if (this.getDropped() == false && player[0].getBomb() > 0) {
//            this.setDropped(true);
//            this.setPositionX(playerX || autoCharacterX);
//            this.setPositionY(playerY || autoCharacterY);
//
//            this.dropTime = gameTimer.getTime();
//        }
//    }
//
//        //Bombe wird Angezeigt
//        if (this.dropped == true {
//
//            push();
//            translate(bombObject.getPositionX(), bombObject.getPositionY());
//
//            switch(scaleSize) {
//                case 0: scale(1); break;
//                case 1: scale((float) 1.3); break;
//                case 2: scale((float) 1.5); break;
//                case 3: scale((float) 1.7); break;
//                case 4: scale(2); break;
//            }
//
//            imageMode(CENTER);
//            image(imgBomb, 0, 0, bombSize, bombSize);
//
//            pop();
//
//            //Nach Delay explodiert Bombe und Spieler bekommt -1 Bombe
//            if (bombObject.getDropped() && bombObject.dropTime + bombDelay < gameTimer.getTime() ) {
//
//                player[0].setBomb(player[0].getBomb() - 1);
//                println("Boooooom!");
//
//                bombObject.isNotDropped();
//            }
//        }


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

    public void setDropped (boolean isDropped) {
        this.dropped = isDropped;
    }

//    public void getDropped() {
//        return this.dropped;
//    }
}
