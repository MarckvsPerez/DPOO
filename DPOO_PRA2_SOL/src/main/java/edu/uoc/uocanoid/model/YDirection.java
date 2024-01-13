package edu.uoc.uocanoid.model;

public enum YDirection {
    UP(-1),
    DOWN(1);

    private int orientation;

    private YDirection(int orientation) {
        this.orientation = orientation;
    }

    public int getOrientation() {
        return orientation;
    }

    private void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public YDirection next() {
        return (this == UP) ? DOWN : UP;
    }

    public static YDirection getValueByOrientation(int orientation) {
        for (YDirection direction : values()) {
            if (direction.getOrientation() == orientation) {
                return direction;
            }
        }
        return null;
    }

}
