

public class Position  {


    public int positionX;
    public int positionY;

    private int width;
    private int height;


    private int fieldWidth;
    private int fieldHeight;

    private int fieldSize;

    private boolean free;


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        int pixelRestWidth = width % this.fieldSize;
        this.width = width - pixelRestWidth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        int pixelRestHeight = height % this.fieldSize;
        this.height = height - pixelRestHeight;
    }

    public int getFieldWidth() {
        return fieldWidth;
    }

    public void setFieldWidth() {
        this.fieldWidth = this.width / this.fieldSize;
    }

    public int getFieldHeight() {
        return fieldHeight;
    }

    public void setFieldHeight() {
        this.fieldHeight = this.height / this.fieldSize;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }


    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }





    //checkt ob eine Position frei ist
    public boolean isFree(int positionX, int positionY) {
        //schneller check ob der Rand betroffen ist
        if (positionX <= this.fieldWidth || positionX >= this.width - this.fieldWidth || positionY <= this.fieldHeight || positionY >= this.height - this.fieldHeight) {
            this.free = false;
        } else {
            //check ob die Felder in der Mitte getroffen werden mit Hilfe einer for-Schleife, gleich wie beim zeichnen
            forSchleife:
            for (int x = this.fieldWidth; x < this.width - this.fieldWidth; x += this.fieldWidth) {
                for (int y = this.fieldHeight; y < this.height - this.fieldHeight; y += this.fieldHeight) {

                    if (x % (this.fieldWidth * 2) == 0 && y % (this.fieldHeight * 2) == 0) {
                        if (positionX > x && positionX < x + this.fieldWidth && positionY > y  && positionY < y + this.fieldHeight ) {
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




