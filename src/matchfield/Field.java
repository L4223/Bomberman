package matchfield;

public class Field {


    int startPositionX;
    int startPositionY;
    int endPositionX;
    int endPositionY;
//    Color color;
    public Field (int positionX, int positionY, int width, int height) {
        setStartPositionX(positionX);
        setStartPositionY(positionY);
        setEndPositionX(positionX + width);
        setEndPositionY(positionY + height);
    }


    private boolean destroyable;
    private boolean empty;
    private String theme;


    public int getStartPositionX() {
        return startPositionX;
    }

    public void setStartPositionX(int startPositionX) {
        this.startPositionX = startPositionX;
    }

    public int getStartPositionY() {
        return startPositionY;
    }

    public void setStartPositionY(int startPositionY) {
        this.startPositionY = startPositionY;
    }

    public int getEndPositionX() {
        return endPositionX;
    }

    public void setEndPositionX(int endPositionX) {
        this.endPositionX = endPositionX;
    }

    public int getEndPositionY() {
        return endPositionY;
    }

    public void setEndPositionY(int endPositionY) {
        this.endPositionY = endPositionY;
    }

//    public Color getColor() {
//        return color;
//    }
//
//    public void setColor(Color color) {
//        this.color = color;
//    }




    public boolean isDestroyable() {
        return destroyable;
    }

    public boolean isEmpty() {
        return empty;
    }

    public String getTheme() {
        return theme;
    }

    public void setDestroyable(boolean destroyable) {
        this.destroyable = destroyable;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}