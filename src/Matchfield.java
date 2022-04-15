// nocht nicht benutzt

public class Matchfield extends Position{
    private boolean visible;
    private boolean taken;


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
        int pixelRestWidth = width % getFieldSize();
        this.width = width - pixelRestWidth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        int pixelRestHeight = height % getFieldSize();
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

    public boolean isTaken() {
        return taken;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
