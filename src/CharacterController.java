import processing.core.PApplet;

public class CharacterController {

    private PApplet pApplet;
    private Character bomberman;
    private CharacterView view;

    public CharacterController (Character bomberman, CharacterView view, PApplet pApplet) {
        this.bomberman = bomberman;
        this.view = view;
        this.pApplet = pApplet;
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
            //checkt ob die nächste Position frei ist und ob die Taste gedrückt wurde und bewegt sich nach links
            if (pApplet.keyCode == pApplet.LEFT && bomberman.getPlayernumber() == 0
                    || pApplet.key == 'a' && bomberman.getPlayernumber() == 1) {
                if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX() - bomberman.getSpeed(), bomberman.getCornerLeftUpY())
                        && bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX() - bomberman.getSpeed(), bomberman.getCornerLeftDownY())) {
                    left(bomberman.getSpeed());
                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX() - i, bomberman.getCornerLeftUpY())
                                && bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX() - i, bomberman.getCornerLeftDownY())) {
                            left(i);


                        }

                    }
                }
            }
            if (pApplet.keyCode == pApplet.RIGHT && bomberman.getPlayernumber() == 0
                    || pApplet.key == 'd' && bomberman.getPlayernumber() == 1) {
                if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX() + bomberman.getSpeed(), bomberman.getCornerRightUpY())
                        && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX() + bomberman.getSpeed(), bomberman.getCornerRightDownY())) {
                    right(bomberman.getSpeed());

                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX() + i, bomberman.getCornerRightUpY())
                                && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX() + i, bomberman.getCornerRightDownY())) {
                            right(i);


                        }

                    }
                }
            }
            if (pApplet.keyCode == pApplet.UP && bomberman.getPlayernumber() == 0
                    || pApplet.key == 'w' && bomberman.getPlayernumber() == 1) {
                if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX(), bomberman.getCornerLeftUpY() - bomberman.getSpeed())
                        && bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX() , bomberman.getCornerRightUpY() - bomberman.getSpeed())) {
                    up(bomberman.getSpeed());
                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX() , bomberman.getCornerLeftUpY() - i)
                                && bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX() , bomberman.getCornerRightUpY() - i )) {
                            up(i);


                        }

                    }
                }
            }
            if (pApplet.keyCode == pApplet.DOWN && bomberman.getPlayernumber() == 0
                    || pApplet.key == 's' && bomberman.getPlayernumber() == 1) {
                if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX()  , bomberman.getCornerLeftDownY()  + bomberman.getSpeed())
                        && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX() , bomberman.getCornerRightDownY() + bomberman.getSpeed())) {
                    down(bomberman.getSpeed());
                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX() , bomberman.getCornerLeftDownY()  + i)
                                && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX(), bomberman.getCornerRightDownY() + i)) {
                            down(i);

                        }

                    }
                }
            }


        }
        updatePosition();

    }

    public void automovement(int direction) {
        switch (direction) {
            case 0:

                if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX() - bomberman.getSpeed(), bomberman.getCornerLeftUpY())
                        && bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX() - bomberman.getSpeed(), bomberman.getCornerLeftDownY())) {
                    left(bomberman.getSpeed());
                    automovement((int)pApplet.random(3));
                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX() - i, bomberman.getCornerLeftUpY())
                                && bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX() - i, bomberman.getCornerLeftDownY())) {
                            left(i);
                            automovement((int)pApplet.random(1,3));
                        }
                    }
                }
                break;
            case 1:

                if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX() + bomberman.getSpeed(), bomberman.getCornerRightUpY())
                        && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX() + bomberman.getSpeed(), bomberman.getCornerRightDownY())) {
                    right(bomberman.getSpeed());
                    automovement((int)pApplet.random(3));

                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX() + i, bomberman.getCornerRightUpY())
                                && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX() + i, bomberman.getCornerRightDownY())) {
                            right(i);
                            automovement((int)pApplet.random(2,3));
                        }
                    }
                }
                break;
            case 2:
                if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX(), bomberman.getCornerLeftUpY() - bomberman.getSpeed())
                        && bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX(), bomberman.getCornerRightUpY() - bomberman.getSpeed())) {
                    up(bomberman.getSpeed());
                    automovement((int)pApplet.random(3));
                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX(), bomberman.getCornerLeftUpY() - i)
                                && bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX(), bomberman.getCornerRightUpY() - i)) {
                            up(i);
                            automovement((int)pApplet.random(1));
                        }
                    }
                }
                break;
            case 3:
                if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX(), bomberman.getCornerLeftDownY() + bomberman.getSpeed())
                        && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX(), bomberman.getCornerRightDownY() + bomberman.getSpeed())) {
                    down(bomberman.getSpeed());
                    automovement((int)pApplet.random(3));
                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX(), bomberman.getCornerLeftDownY() + i)
                                && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX(), bomberman.getCornerRightDownY() + i)) {
                            down(i);
                            automovement((int)pApplet.random(2));
                        }
                    }
                }
                break;
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
        updatePosition();
        view.draw(bomberman, pApplet);
    }


}
