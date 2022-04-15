public class Position {
    private int positionX;
    private int positionY;


    public int getPositionX (){
        return positionX;
    }

    public int getPositionY () {
        return positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    //checkt ob eine Position frei ist
    public boolean isFree(int positionX, int positionY) {
        //schneller check ob der Rand betroffen ist
        if (positionX < getFieldWidth()
        positionX > getWidth() - getFieldWidth()
        positionY < getFieldHeight()
                || positionY > getHeight() - getFieldHeight()) {
            this.free = false;
        } else {
            //check ob die Felder in der Mitte getroffen werden mit Hilfe einer for-Schleife, gleich wie beim zeichnen
            forSchleife:
            for (int x = getFieldWidth(); x < getWidth() - getFieldWidth(); x += getFieldWidth()) {
                for (int y = getFieldHeight(); y < getHeight() - getFieldHeight(); y += getFieldHeight()) {

                    if (x % (getFieldWidth() * 2) == 0 && y % (getFieldHeight() * 2) == 0) {
                        if (positionX > x && positionX < x + getFieldWidth()
                                && positionY > y
                                && positionY < y + getFieldHeight() ) {
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
