public class CharacterView {

            for (int i = 0; i < 4; i++) {
        fill(player[i].getColor());
        rect(player[i].getCornerLeftUpX(), player[i].getCornerLeftUpY(), player[i].getCornerRightDownX(), player[i].getCornerRightDownY());
    }
}
