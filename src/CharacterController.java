import hilfsKlassen.Direction;
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
                } else if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX() - bomberman.getSpeed(), bomberman.getCornerLeftUpY())) {
                    up(bomberman.getSpeed());
                } else if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX() - bomberman.getSpeed(), bomberman.getCornerLeftDownY())) {
                    down(bomberman.getSpeed());
                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX() - i, bomberman.getCornerLeftUpY())
                                && bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX() - i, bomberman.getCornerLeftDownY())) {
                            left(i);
                        } else if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX() - i, bomberman.getCornerLeftUpY())) {
                            up(i);
                        } else if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX() - i, bomberman.getCornerLeftDownY())) {
                            down(i);
                        }
                    }
                }
            }
            if (pApplet.keyCode == pApplet.RIGHT && bomberman.getPlayernumber() == 0
                    || pApplet.key == 'd' && bomberman.getPlayernumber() == 1) {
                if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX() + bomberman.getSpeed(), bomberman.getCornerRightUpY())
                        && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX() + bomberman.getSpeed(), bomberman.getCornerRightDownY())) {
                    right(bomberman.getSpeed());
                } else if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX() + bomberman.getSpeed(), bomberman.getCornerRightUpY())) {
                    up(bomberman.getSpeed());
                } else if (bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX() + bomberman.getSpeed(), bomberman.getCornerRightDownY())) {
                    down(bomberman.getSpeed());
                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX() + i, bomberman.getCornerRightUpY())
                                && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX() + i, bomberman.getCornerRightDownY())) {
                            right(i);
                        } else if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX() + i, bomberman.getCornerRightUpY())) {
                            up(i);
                        } else if (bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX() + i, bomberman.getCornerRightDownY())) {
                            down(i );
                        }
                    }
                }
            }
            if (pApplet.keyCode == pApplet.UP && bomberman.getPlayernumber() == 0
                    || pApplet.key == 'w' && bomberman.getPlayernumber() == 1) {
                if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX(), bomberman.getCornerLeftUpY() - bomberman.getSpeed())
                        && bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX(), bomberman.getCornerRightUpY() - bomberman.getSpeed())) {
                    up(bomberman.getSpeed());
                } else if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX(), bomberman.getCornerLeftUpY() - bomberman.getSpeed())) {
                    left(bomberman.getSpeed());
                } else if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX(), bomberman.getCornerRightUpY() - bomberman.getSpeed())) {
                    right(bomberman.getSpeed());
                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX(), bomberman.getCornerLeftUpY() - i)
                                && bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX(), bomberman.getCornerRightUpY() - i)) {
                            up(i);
                        } else if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX(), bomberman.getCornerLeftUpY() - i)) {
                            left(i);
                        } else if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX(), bomberman.getCornerRightUpY() - i)) {
                            right(i);
                        }
                    }
                }
            }
                if (pApplet.keyCode == pApplet.DOWN && bomberman.getPlayernumber() == 0
                        || pApplet.key == 's' && bomberman.getPlayernumber() == 1) {
                    if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX(), bomberman.getCornerLeftDownY() + bomberman.getSpeed())
                            && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX(), bomberman.getCornerRightDownY() + bomberman.getSpeed())) {
                        down(bomberman.getSpeed());
                    } else if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX(), bomberman.getCornerLeftDownY() + bomberman.getSpeed())) {
                        left(bomberman.getSpeed());
                    } else if (bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX(), bomberman.getCornerRightDownY() + bomberman.getSpeed())) {
                        right(bomberman.getSpeed());
                    } else {
                        for (int i = bomberman.getSpeed(); i > 0; i--) {
                            if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX(), bomberman.getCornerLeftDownY() + i)
                                    && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX(), bomberman.getCornerRightDownY() + i)) {
                                down(i);
                            } else if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX(), bomberman.getCornerLeftDownY() + i)) {
                                left(i);
                            } else if (bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX(), bomberman.getCornerRightDownY() + i)) {
                                right(i);
                            }
                        }
                    }
                }
            }
        updatePosition();
    }

/*    public void automovement(int direction) {
//        pApplet.println("test");
        if(direction < 251) {

            //checkt ob die nächste Position frei ist und ob die Taste gedrückt wurde und bewegt sich nach links
//            for (int j = (int) pApplet.random(1,1000); j > 0; j =- bomberman.getSpeed()) {
            if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX() - 1, bomberman.getCornerLeftUpY())
                    && bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX() - 1, bomberman.getCornerLeftDownY())) {
//                for (int j = (int) pApplet.random(bomberman.getCornerLeftUpX() - bomberman.getMatchfield().getFieldWidth()); j > 0; j -= bomberman.getMatchfield().getFieldWidth()) {
                    for (int j = bomberman.getCornerLeftUpX() - bomberman.getMatchfield().getFieldWidth(); j > bomberman.getMatchfield().getFieldWidth(); j -= bomberman.getMatchfield().getFieldWidth()) {

//                        forSchleife:
//                    for (int i = bomberman.getSpeed(); i > 0; i--) {
//                        if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX() - i, bomberman.getCornerLeftUpY())
//                                && bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX() - i, bomberman.getCornerLeftDownY())) {
//                            left(1);
                        for (int i = bomberman.getMatchfield().getFieldWidth(); i > 0; i--) {
                            left(1);
//                            break;
//                            break forSchleife;
//                        }
                    }
                    ;
                    pApplet.println("left " + direction);
//                        break;
                }
            }
        }
//                } else if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX() - bomberman.getSpeed(), bomberman.getCornerLeftUpY())) {
//                    up(bomberman.getSpeed());
//                    pApplet.println("test2");
//                } else if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX() - bomberman.getSpeed(), bomberman.getCornerLeftDownY())) {
//                    down(bomberman.getSpeed());
//                    pApplet.println("test3");
//                } else {
//                    for (int i = bomberman.getSpeed(); i > 0; i--) {
//                        if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX() - i, bomberman.getCornerLeftUpY())
//                                && bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX() - i, bomberman.getCornerLeftDownY())) {
//                            left(i);
//                            pApplet.println("test4");
//                        } else if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX() - i, bomberman.getCornerLeftUpY())) {
//                            up(i);
//                            pApplet.println("test5");
//                        } else if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX() - i, bomberman.getCornerLeftDownY())) {
//                            down(i);
//                            pApplet.println("test6");
//                        }
//                    }
//                }
        if(direction > 250 && direction < 501) {
            if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX() + 1, bomberman.getCornerRightUpY())
                    && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX() + 1, bomberman.getCornerRightDownY())) {
//                for (int j = (int) pApplet.random(pApplet.width - bomberman.getCornerRightUpX() - bomberman.getMatchfield().getFieldWidth()); j > 0; j -= bomberman.getMatchfield().getFieldWidth()) {
                    for (int j = pApplet.width - bomberman.getCornerRightUpX() - bomberman.getMatchfield().getFieldWidth(); j > bomberman.getMatchfield().getFieldWidth(); j -= bomberman.getMatchfield().getFieldWidth()) {

//                        forSchleife:
//                    for (int i = bomberman.getSpeed(); i > 0; i--) {
//                        if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX() + i, bomberman.getCornerRightUpY())
//                                && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX() + i, bomberman.getCornerRightDownY())) {
//                            right(1);
                        for (int i = bomberman.getMatchfield().getFieldWidth(); i > 0; i--) {
                            right(1);
//                            break;
//                            break forSchleife;
//                        }
                    }
                    pApplet.println("right " + direction);
//                        break;
                }
            }
        }
//                } else if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX() + bomberman.getSpeed(), bomberman.getCornerRightUpY())) {
//                    up(bomberman.getSpeed());
//                    pApplet.println("test8");
//                } else if (bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX() + bomberman.getSpeed(), bomberman.getCornerRightDownY())) {
//                    down(bomberman.getSpeed());
//                    pApplet.println("test9");
//                } else {
//                    for (int i = bomberman.getSpeed(); i > 0; i--) {
//                        if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX() + i, bomberman.getCornerRightUpY())
//                                && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX() + i, bomberman.getCornerRightDownY())) {
//                            right(i);
//                            pApplet.println("test10");
//                        } else if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX() + i, bomberman.getCornerRightUpY())) {
//                            up(i );
//                            pApplet.println("test11");
//                        } else if (bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX() + i, bomberman.getCornerRightDownY())) {
//                            down(i );
//                            pApplet.println("test12");
//                        }
//                    }
//                }
        if(direction > 500 && direction < 751) {
            if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX(), bomberman.getCornerLeftUpY() - 1)
                    && bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX(), bomberman.getCornerRightUpY() - 1)) {
//                for (int j = (int) pApplet.random(bomberman.getCornerLeftUpY() - bomberman.getMatchfield().getFieldHeight()); j > 0; j -= bomberman.getMatchfield().getFieldHeight()) {
                    for (int j = bomberman.getCornerLeftUpY() - bomberman.getMatchfield().getFieldHeight(); j > bomberman.getMatchfield().getFieldHeight(); j -= bomberman.getMatchfield().getFieldHeight()) {

//                        forSchleife:
//                    for (int i = bomberman.getSpeed(); i > 0; i--) {
//                        if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX(), bomberman.getCornerLeftUpY() - i)
//                                && bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX(), bomberman.getCornerRightUpY() - i)) {
//                            up(1);
                        for (int i = bomberman.getMatchfield().getFieldHeight(); i > 0; i--) {
                            up(1);
//                            break;
//                            break forSchleife;
//                        }
                    }
                    pApplet.println("up " + direction);
//                        break;
                }
            }
        }
//                } else if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX(), bomberman.getCornerLeftUpY() - bomberman.getSpeed())) {
//                    left(bomberman.getSpeed());
//                    pApplet.println("test14");
//                } else if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX(), bomberman.getCornerRightUpY() - bomberman.getSpeed())) {
//                    right(bomberman.getSpeed());
//                    pApplet.println("test15");
//                } else {
//                    for (int i = bomberman.getSpeed(); i > 0; i--) {
//                        if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX(), bomberman.getCornerLeftUpY() - i)
//                                && bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX(), bomberman.getCornerRightUpY() - i)) {
//                            up(i);
//                            pApplet.println("test16");
//                        } else if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX(), bomberman.getCornerLeftUpY() - i)) {
//                            left(i);
//                            pApplet.println("test17");
//                        } else if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX(), bomberman.getCornerRightUpY() - i)) {
//                            right(i);
//                            pApplet.println("test18");
//                        }
//                    }
//                }
        if(direction > 750) {
            if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX(), bomberman.getCornerLeftDownY() + 1)
                    && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX(), bomberman.getCornerRightDownY() + 1)) {
//                for (int j = (int) pApplet.random(pApplet.height - bomberman.getCornerLeftDownY() - bomberman.getMatchfield().getFieldHeight()); j > 0; j -= bomberman.getMatchfield().getFieldHeight()) {
                    for (int j = pApplet.height - bomberman.getCornerLeftDownY() - bomberman.getMatchfield().getFieldHeight(); j > bomberman.getMatchfield().getFieldHeight(); j -= bomberman.getMatchfield().getFieldHeight()) {

//                        forSchleife:
//                    for (int i = bomberman.getSpeed(); i > 0; i--) {
//                        if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX(), bomberman.getCornerLeftDownY() + i)
//                                && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX(), bomberman.getCornerRightDownY() + i)) {
//                            down(1);
                    for (int i = bomberman.getMatchfield().getFieldHeight(); i > 0; i--) {
                        down(1);
//                        break;
//                            break forSchleife;
//                        }
                    }
                    pApplet.println("down " + direction);
//                        break;
                }
            }
        }
//                } else if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX(), bomberman.getCornerLeftDownY() + bomberman.getSpeed())) {
//                    left(bomberman.getSpeed());
//                    pApplet.println("test20");
//                } else if (bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX(), bomberman.getCornerRightDownY() + bomberman.getSpeed())) {
//                    right(bomberman.getSpeed());
//                    pApplet.println("test21");
//                } else {
//                    for (int i = bomberman.getSpeed(); i > 0; i--) {
//                        if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX(), bomberman.getCornerLeftDownY() + i)
//                                && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX(), bomberman.getCornerRightDownY() + i)) {
//                            down(i);
//                            pApplet.println("test22");
//                        } else if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX(), bomberman.getCornerLeftDownY() + i)) {
//                            left(i);
//                            pApplet.println("test23");
//                        } else if (bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX(), bomberman.getCornerRightDownY() + i)) {
//                            right(i);
//                            pApplet.println("test24");
//                        }
//                    }
//                }

        updatePosition();
//                pApplet.println("test25");
    }*/

    public void automovement (String direction) {
        if (direction == "right") {
//            for (int j = pApplet.height - bomberman.getCornerLeftDownY() - bomberman.getMatchfield().getFieldHeight(); j > 0; j =- bomberman.getSpeed()) {
                if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX() + bomberman.getSpeed(), bomberman.getCornerRightUpY())
                        && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX() + bomberman.getSpeed(), bomberman.getCornerRightDownY())) {
                    right(bomberman.getSpeed());
                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX() + i, bomberman.getCornerLeftDownY())
                                && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX() + i, bomberman.getCornerRightDownY())) {
                            right(i);
                        }
                    }
                }
//            }
        }
        if (direction == "down") {
//            for (int j = pApplet.height - bomberman.getCornerLeftDownY() - bomberman.getMatchfield().getFieldHeight(); j > 0; j =- bomberman.getSpeed()) {
                if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX(), bomberman.getCornerLeftDownY() + bomberman.getSpeed())
                        && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX(), bomberman.getCornerRightDownY() + +bomberman.getSpeed())) {
                    down(bomberman.getSpeed());
                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (bomberman.getMatchfield().isFree(bomberman.getCornerLeftDownX(), bomberman.getCornerLeftDownY() + i)
                                && bomberman.getMatchfield().isFree(bomberman.getCornerRightDownX(), bomberman.getCornerRightDownY() + +i)) {
                            down(i);
                        }
                    }
                }
//            }
        }
        if (direction == "up") {
//            for (int j = bomberman.getCornerLeftUpY() - bomberman.getMatchfield().getFieldHeight(); j > 0; j =- bomberman.getSpeed()) {
                if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX(), bomberman.getCornerRightUpY() - bomberman.getSpeed())
                        && bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX(), bomberman.getCornerLeftUpY() - bomberman.getSpeed())) {
                    up(bomberman.getSpeed());
                } else {
                    for (int i = bomberman.getSpeed(); i > 0; i--) {
                        if (bomberman.getMatchfield().isFree(bomberman.getCornerRightUpX(), bomberman.getCornerRightUpY() - i)
                                && bomberman.getMatchfield().isFree(bomberman.getCornerLeftUpX(), bomberman.getCornerLeftUpY() - i)) {
                            up(i);
                        }
                    }
                }
//            }
        }
        if (direction == "left") {
//            for (int j = bomberman.getCornerLeftUpX() - bomberman.getMatchfield().getFieldWidth(); j > 0; j =- bomberman.getSpeed()) {
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
//            }
        }
        updatePosition();
//        pApplet.println(direction);
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
