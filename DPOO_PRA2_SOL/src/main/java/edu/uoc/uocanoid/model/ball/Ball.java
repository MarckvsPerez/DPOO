package edu.uoc.uocanoid.model.ball;

import edu.uoc.uocanoid.model.Entity;
import edu.uoc.uocanoid.model.XDirection;
import edu.uoc.uocanoid.model.YDirection;
import edu.uoc.uocanoid.model.Movable;

public class Ball extends Entity implements Movable {

    private int speed;
    private XDirection xDirection;
    private YDirection yDirection;
    private final int INIT_X;
    private final int INIT_Y;
    private static final XDirection INIT_X_DIRECTION = XDirection.RIGHT;
    private static final YDirection INIT_Y_DIRECTION = YDirection.UP;


    public Ball(int x, int y, int radius, XDirection xDirection, YDirection yDirection, int speed) {
        super(x, y, radius, radius);
        this.xDirection = xDirection;
        this.yDirection = yDirection;
        this.speed = (speed >= 0) ? speed : 0;
        this.INIT_X = x;
        this.INIT_Y = y;
    }

    @Override
    public void move() {
        int xDirectionValue = (xDirection == XDirection.RIGHT) ? 1 : -1;
        int yDirectionValue = (yDirection == YDirection.DOWN) ? 1 : -1;

        setX(getX() + (speed * xDirectionValue));
        setY(getY() + (speed * yDirectionValue));
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

    public XDirection getXDirection() {
        return xDirection;
    }

    private void setXDirection(XDirection xDirection) {
        this.xDirection = xDirection;
    }

    public void changeXDirection() {
        setXDirection((getXDirection() == XDirection.LEFT) ? XDirection.RIGHT : XDirection.LEFT);
    }

    public YDirection getYDirection() {
        return yDirection;
    }

    private void setYDirection(YDirection yDirection) {
        this.yDirection = yDirection;
    }

    public void changeYDirection() {
        setYDirection((getYDirection() == YDirection.UP) ? YDirection.DOWN : YDirection.UP);
    }


    public void restore() {
        setX(INIT_X);
        setY(INIT_Y);
        setXDirection(XDirection.RIGHT);
        setYDirection(YDirection.UP);
    }

    @Override
    public String toString() {
        return String.format("position: (%d,%d), size: %dx%d, direction: (%s,%s), speed: %d",
                getX(), getY(), getWidth(), getHeight(), getXDirection(), getYDirection(), getSpeed());
    }
}
