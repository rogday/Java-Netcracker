package com.rogday.Task1;

public class MyPoint {
    private int x = 0;
    private int y = 0;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MyPoint() {
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

    public int[] getXY() {
        int[] arr = {x, y};
        return arr;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    public double distance(int x, int y) {
        return Math.hypot(this.x - x, this.y - y);
    }

    public double distance(MyPoint another) {
        return distance(another.x, another.y);
    }

    public double distance() {
        return distance(0, 0);
    }
}
