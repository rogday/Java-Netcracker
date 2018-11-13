package com.rogday.task2;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double[] coeffs) {
        this.coeffs = coeffs;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        for (int i = coeffs.length - 1; i >= 0; --i)
            builder.append(String.format("%+f", coeffs[i])).append("x^").append(i);
        return builder.toString();
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    public double evaluate(double x) {
        double result = coeffs[0];
        double part = x;
        for (int i = 1; i < coeffs.length; ++i) {
            result += coeffs[i] * x;
            x *= part;
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial another) {
        var arr = (coeffs.length > another.coeffs.length) ? coeffs : another.coeffs;
        int m = Math.min(coeffs.length, another.coeffs.length);
        var nCoeffs = new double[arr.length];

        for (int i = 0; i < m; ++i)
            nCoeffs[i] = coeffs[i] + another.coeffs[i];
        for (int i = m; i < arr.length; ++i)
            nCoeffs[i] = arr[i];

        return new MyPolynomial(nCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial another) {
        int n = getDegree() + another.getDegree() + 1;
        var nCoeffs = new double[n];
        for (int i = 0; i < coeffs.length; ++i)
            for (int j = 0; j < another.coeffs.length; ++j)
                nCoeffs[i + j] += coeffs[i] * another.coeffs[j];
        return new MyPolynomial(nCoeffs);
    }
}
