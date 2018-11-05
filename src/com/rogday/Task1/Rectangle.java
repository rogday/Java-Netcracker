package com.rogday.Task1;

public class Rectangle {
    private float length = 1.0f;
    private float width = 1.0f;

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle() {
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public double getArea() {
        return (double) length * width;
    }

    public double getPerimetr() {
        return ((double) length + width) * 2.0;
    }

    public String toString() {
        return String.format("Rectangle[length=%f,width=%f]", length, width);
    }
}
