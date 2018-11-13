package com.rogday.task2;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public String toString() {
        return String.format("(%f%+fi)", real, imag);
    }

    public boolean isReal() {
        return real != 0.0;
    }

    public boolean isImaginary() {
        return imag != 0.0;
    }

    public boolean equals(double real, double imag) {
        return (this.real == real) && (this.imag == imag);  //here should've been some constant eps
    }

    public boolean equals(MyComplex another) {
        return equals(another.real, another.imag);
    }

    public double magnitude() {
        return Math.hypot(real, imag);
    }

    public double argument() {
        return Math.atan2(imag, real);
    }

    public MyComplex add(MyComplex right) {
        this.real += right.real;
        this.imag += right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        var left = new MyComplex(this.real, this.imag);
        return left.add(right);
    }

    public MyComplex subtract(MyComplex right) { // it's better to add add(real, imag) and just change signs
        this.real -= right.real;
        this.imag -= right.imag;
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        var left = new MyComplex(this.real, this.imag);
        return left.subtract(right);
    }

    public MyComplex multiply(MyComplex right) {
        double r = this.real;
        double i = this.imag;
        this.real = r * right.real - i * right.imag;
        this.imag = r * right.imag + i * right.real;
        return this;
    }

    public MyComplex devide(MyComplex right) {
        double denominator = Math.pow(right.real, 2) + Math.pow(right.imag, 2);
        double r = this.real;
        double i = this.imag;
        this.real = (r * right.real + i * right.imag) / denominator;
        this.imag = (i * right.real - r * right.imag) / denominator;
        return this;
    }

    public MyComplex conjugate() {
        this.imag = -this.imag;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyComplex myComplex = (MyComplex) o;
        return Double.compare(myComplex.real, real) == 0 &&
                Double.compare(myComplex.imag, imag) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        long f1 = Double.doubleToLongBits(real);
        long f2 = Double.doubleToLongBits(imag);
        result = 31 * result + (int) (f1 ^ (f1 >>> 31));
        result = 31 * result + (int) (f2 ^ (f2 >>> 31));
        return result;
    }
}
