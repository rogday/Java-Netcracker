package com.rogday.backend.task1;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Float.compare(rectangle.length, length) == 0 &&
                Float.compare(rectangle.width, width) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        int f1 = Float.floatToIntBits(length);
        int f2 = Float.floatToIntBits(length);
        result = 31 * result + f1;
        result = 31 * result + f2;
        return result;
    }
}
