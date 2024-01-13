package edu.uoc.uocanoid.model.bricks;

import edu.uoc.uocanoid.model.Entity;

public abstract class Brick extends Entity {
    private int currentHits;
    private int numHitsToBreak;
    private int points;

    protected Brick(int x, int y, int width, int height, int numHitsToBreak, int points) {
        super(x, y, width, height);
        this.numHitsToBreak = (numHitsToBreak < 1) ? 1 : numHitsToBreak;
        this.points = (points < 0) ? 0 : points;
        this.currentHits = 0;
    }

    public int getNumHitsToBreak() {
        return numHitsToBreak;
    }

    public int getCurrentHits() {
        return currentHits;
    }

    public int getPoints() {
        return points;
    }

    private void setNumHitsToBreak(int numHitsToBreak) {
        this.numHitsToBreak = (numHitsToBreak < 1) ? 1 : numHitsToBreak;
    }

    private void setCurrentHits(int currentHits) {
        this.currentHits = (currentHits < 0) ? 0 : currentHits;
    }

    private void setPoints(int points) {
        this.points = (points < 0) ? 0 : points;
    }

    public void incCurrentHits() {
        if (!isBroken()) {
            currentHits++;
        }
    }

    public boolean isBroken() {
        return currentHits >= numHitsToBreak;
    }

    @Override
    public String toString() {
        return String.format("position: (%d,%d), size: %dx%d, hits to break: %d, current hits: %d, points: %d",
                getX(), getY(), getWidth(), getHeight(), numHitsToBreak, currentHits, points);
    }
}

