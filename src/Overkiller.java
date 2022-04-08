public class Overkiller {

    private boolean free;









    public boolean isFree(int screenWidth, int screenHeight, int fieldWidth, int fieldHeight,int xPosition, int yPosition) {
        if (xPosition < fieldWidth || xPosition > screenWidth - fieldWidth || yPosition < fieldHeight || yPosition > screenHeight - fieldHeight) {
            this.free = false;
        } else {
            forSchleife:
            for (int x = fieldWidth; x < screenWidth - fieldWidth; x += fieldWidth) {
                for (int y = fieldHeight; y < screenHeight - fieldHeight; y += fieldHeight) {
//
                    if (x % (fieldWidth * 2) == 0 && y % (fieldHeight * 2) == 0) {
                        if (xPosition > x && xPosition < x + fieldWidth && yPosition > y && yPosition < y + fieldHeight) {
                            this.free = false;
                            break forSchleife;
                        } else {
                            this.free = true;
                        }
                    }
                }
            }
        }
        return this.free;
    }

}
