package com.rogday.task1;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return String.format("Circle[radius=%f,color=%s]", radius, color);
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 &&
                color.equals(circle.color);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + color.hashCode();
        long l = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (l ^ (l >>> 32));
        return result;
    }
}
