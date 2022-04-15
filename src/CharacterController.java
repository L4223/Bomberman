import processing.core.PApplet;

public class CharacterController {

    private Character bomberman;
    private CharacterView view;

    public CharacterController (Character bomberman, CharacterView view) {
        this.bomberman = bomberman;
        this.view = view;
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

    public void movement(PApplet pApplet) {
        if (pApplet.keyPressed) {
            //checkt ob die nächste Position frei ist und ob die Taste gedrück wurde und bewegt sich nach links
            if (pApplet.keyCode == pApplet.LEFT) {
                if (levelOne.isFree(player[0].getCornerLeftUpX() - player[0].getSpeed(), player[0].getCornerLeftUpY())
                        && levelOne.isFree(player[0].getCornerLeftDownX() - player[0].getSpeed(), player[0].getCornerLeftDownY())) {
                    player[0].left(player[0].getSpeed());
                } else {
                    for (int i = player[0].getSpeed(); i > 0; i--) {
                        if (levelOne.isFree(player[0].getCornerLeftUpX() - i, player[0].getCornerLeftUpY())
                                && levelOne.isFree(player[0].getCornerLeftDownX() - i, player[0].getCornerLeftDownY())) {
                            player[0].left(i);


                        }

                    }
                }
            }
            if (keyCode == RIGHT) {
                if (levelOne.isFree(player[0].getCornerRightUpX() + player[0].getSpeed(), player[0].getCornerRightUpY())
                        && levelOne.isFree(player[0].getCornerRightDownX() + player[0].getSpeed(), player[0].getCornerRightDownY())) {
                    player[0].right(player[0].getSpeed());
                } else {
                    for (int i = player[0].getSpeed(); i > 0; i--) {
                        if (levelOne.isFree(player[0].getCornerRightUpX() + i, player[0].getCornerRightUpY())
                                && levelOne.isFree(player[0].getCornerRightDownX() + i, player[0].getCornerRightDownY())) {
                            player[0].right(i);


                        }

                    }
                }
            }
            if (keyCode == UP) {
                if (levelOne.isFree(player[0].getCornerLeftUpX(), player[0].getCornerLeftUpY() - player[0].getSpeed())
                        && levelOne.isFree(player[0].getCornerRightUpX() , player[0].getCornerRightUpY() - player[0].getSpeed())) {
                    player[0].up(player[0].getSpeed());
                } else {
                    for (int i = player[0].getSpeed(); i > 0; i--) {
                        if (levelOne.isFree(player[0].getCornerLeftUpX() , player[0].getCornerLeftUpY() - i)
                                && levelOne.isFree(player[0].getCornerRightUpX() , player[0].getCornerRightUpY() - i )) {
                            player[0].up(i);


                        }

                    }
                }
            }
            if (keyCode == DOWN) {
                if (levelOne.isFree(player[0].getCornerLeftDownX()  , player[0].getCornerLeftDownY()  + player[0].getSpeed())
                        && levelOne.isFree(player[0].getCornerRightDownX() , player[0].getCornerRightDownY() + player[0].getSpeed())) {
                    player[0].down(player[0].getSpeed());
                } else {
                    for (int i = player[0].getSpeed(); i > 0; i--) {
                        if (levelOne.isFree(player[0].getCornerLeftDownX() , player[0].getCornerLeftDownY()  + i)
                                && levelOne.isFree(player[0].getCornerRightDownX(), player[0].getCornerRightDownY() + i)) {
                            player[0].down(i);

                        }

                    }
                }
            }


        }
        player[0].updatePosition();

    }


}
