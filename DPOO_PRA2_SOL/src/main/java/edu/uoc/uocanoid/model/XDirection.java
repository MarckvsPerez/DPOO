package edu.uoc.uocanoid.model;

public enum XDirection {
    LEFT(-1),
    RIGHT(1);

    private int orientation;

    private XDirection(int orientation) {
        this.orientation = orientation;
    }

    public int getOrientation() {
        return orientation;
    }

    private void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public XDirection next() {
        return (this == LEFT) ? RIGHT : LEFT;
    }

    public static XDirection getValueByOrientation(int orientation) {
        for (XDirection direction : values()) {
            if (direction.getOrientation() == orientation) {
                return direction;
            }
        }
        return null;
    }

}
