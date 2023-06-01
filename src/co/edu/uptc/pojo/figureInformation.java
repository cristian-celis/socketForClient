package co.edu.uptc.pojo;

public class figureInformation {
    public int rectangle;
    private int Color;

    public figureInformation(int rectangle, int color) {
        this.rectangle = rectangle;
        this.Color = color;
    }

    public int getRectangle() {
        return rectangle;
    }

    public void setRectangle(int rectangle) {
        this.rectangle = rectangle;
    }

    public int getColor() {
        return Color;
    }

    public void setColor(int color) {
        this.Color = color;
    }
}
