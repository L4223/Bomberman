import processing.core.PApplet;

public class CharacterController {

    private PApplet pApplet = this.pApplet;

    private Character bomberman;
    private CharacterView view;
    private Matchfield matchfield;

    public CharacterController (Character bomberman, CharacterView view, Matchfield matchfield) {
        this.bomberman = bomberman;
        this.view = view;
        this.matchfield = matchfield;
    }


    //läuft in die gegebene Richtung
    public void left(int speed) {
        bomberman.setPositionX(bomberman.getPositionX() - speed);
        updatePosition();
    }
    public void right(int speed) {
        bomberman.setPositionX(bomberman.getPositionX() + speed);
        updatePosition();
    }
    public void down(int speed) {
        bomberman.setPositionY(bomberman.getPositionY() + speed);
        updatePosition();
    }
    public void up(int speed) {
        bomberman.setPositionY(bomberman.getPositionY()- speed);
        updatePosition();
    }



    public void movement() {
        if (pApplet.keyPressed) {
            //checkt ob die nächste Position frei ist und ob die Taste gedrück wurde und bewegt sich nach links
            if (pApplet.keyCode == pApplet.LEFT) {
                if (matchfield.isFree(bomberman.getCornerLeftUpX() - bomberman.getSpeed(), bomberman.getCornerLeftUpY())
                        && matchfield.isFree(bomberman.getCornerLeftDownX() - bomberman.getSpeed(), bomberman.getCornerLeftDownY())) {
                    left(bomberman.getSpeed());
                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (matchfield.isFree(bomberman.getCornerLeftUpX() - i, bomberman.getCornerLeftUpY())
                                && matchfield.isFree(bomberman.getCornerLeftDownX() - i, bomberman.getCornerLeftDownY())) {
                            left(i);


                        }

                    }
                }
            }
            if (pApplet.keyCode == pApplet.RIGHT) {
                if (matchfield.isFree(bomberman.getCornerRightUpX() + bomberman.getSpeed(), bomberman.getCornerRightUpY())
                        && matchfield.isFree(bomberman.getCornerRightDownX() + bomberman.getSpeed(), bomberman.getCornerRightDownY())) {
                    right(bomberman.getSpeed());
                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (matchfield.isFree(bomberman.getCornerRightUpX() + i, bomberman.getCornerRightUpY())
                                && matchfield.isFree(bomberman.getCornerRightDownX() + i, bomberman.getCornerRightDownY())) {
                            right(i);


                        }

                    }
                }
            }
            if (pApplet.keyCode == pApplet.UP) {
                if (matchfield.isFree(bomberman.getCornerLeftUpX(), bomberman.getCornerLeftUpY() - bomberman.getSpeed())
                        && matchfield.isFree(bomberman.getCornerRightUpX() , bomberman.getCornerRightUpY() - bomberman.getSpeed())) {
                    up(bomberman.getSpeed());
                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (matchfield.isFree(bomberman.getCornerLeftUpX() , bomberman.getCornerLeftUpY() - i)
                                && matchfield.isFree(bomberman.getCornerRightUpX() , bomberman.getCornerRightUpY() - i )) {
                            up(i);


                        }

                    }
                }
            }
            if (pApplet.keyCode == pApplet.DOWN) {
                if (matchfield.isFree(bomberman.getCornerLeftDownX()  , bomberman.getCornerLeftDownY()  + bomberman.getSpeed())
                        && matchfield.isFree(bomberman.getCornerRightDownX() , bomberman.getCornerRightDownY() + bomberman.getSpeed())) {
                    down(bomberman.getSpeed());
                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (matchfield.isFree(bomberman.getCornerLeftDownX() , bomberman.getCornerLeftDownY()  + i)
                                && matchfield.isFree(bomberman.getCornerRightDownX(), bomberman.getCornerRightDownY() + i)) {
                            down(i);

                        }

                    }
                }
            }


        }
        updatePosition();

    }

    public void updatePosition() {
        bomberman.setCornerLeftUpX();
        bomberman.setCornerLeftUpY();
        bomberman.setCornerLeftDownX();
        bomberman.setCornerLeftDownY();
        bomberman.setCornerRightUpX();
        bomberman.setCornerRightUpY();
        bomberman.setCornerRightDownX();
        bomberman.setCornerRightDownY();
    }

    public void updateView () {
        view.draw(bomberman);
    }


}
