package edu.uoc.uocanoid.model;

public abstract class Entity {
    private int x;
    private int y;
    private int width;
    private int height;

    protected Entity(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = (width < 1) ? 1 : width;
        this.height = (height < 1) ? 1 : height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = (width < 1) ? 1 : width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = (height < 1) ? 1 : height;
    }

    @Override
    public String toString() {
        return String.format("position: (%d,%d), size: %dx%d", x, y, width, height);
    }
}
