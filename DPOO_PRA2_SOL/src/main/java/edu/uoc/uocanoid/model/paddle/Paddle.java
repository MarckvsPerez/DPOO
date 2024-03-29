package edu.uoc.uocanoid.model.paddle;

import edu.uoc.uocanoid.model.Entity;
import edu.uoc.uocanoid.model.Movable;
import edu.uoc.uocanoid.model.XDirection;

public class Paddle extends Entity implements Movable {
    private int speed;
    private XDirection direction;

    public Paddle(int x, int y, int width, int height, int speed) {
        super(x, y, width, height);
        this.speed = (speed >= 0) ? speed : 0;
        this.direction = XDirection.RIGHT;
    }

    @Override
    public void move() {
        int deltaX = speed;
        if (direction == XDirection.LEFT) {
            deltaX = -deltaX;
        }
        setX(getX() + deltaX);
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        if (speed > 0) {
            this.speed = speed;
        }
    }


    public XDirection getDirection() {
        return direction;
    }

    public void setDirection(XDirection direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return String.format("position: (%d,%d), size: %dx%d, direction: %s, speed: %d",
                getX(), getY(), getWidth(), getHeight(), direction, speed);
    }
}
