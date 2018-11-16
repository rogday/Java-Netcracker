package com.rogday.backend.task3;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    private static void sortEstimate(int[] arr, String method, Consumer<int[]> s) {
        var arr2 = arr.clone();
        long startTime = System.nanoTime();
        s.accept(arr2);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(method + estimatedTime);
    }

    private static void factEstimate(int n, Function<Integer, Integer> c, String method) {
        long startTime = System.nanoTime();
        long ans = c.apply(15);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(String.format("%s, 15! = %d, time = %d nanoseconds",
                method, ans, estimatedTime));
    }

    public static void main(String[] args) {
        int[] arr = Utils.generate(5000, 0, 1000);

        sortEstimate(arr, "BubbleSort: ", Utils::bubbleSort);
        sortEstimate(arr, "SelectionSort: ", Utils::selectionSort);
        sortEstimate(arr, "Arrays.sort(): ", Arrays::sort);

        int fact = 15;
        factEstimate(fact, Utils::factRec, "Recursion");
        factEstimate(fact, Utils::factIter, "Iteration");

        Utils.drawRect(7, 7);
        Utils.drawFig(7, 7);

        System.out.println("4.a");
        Utils.fourA();
        System.out.println("4.b");
        Utils.fourB();
        System.out.println("4.c");
        Utils.fourC();
        System.out.println("4.d");
        Utils.fourD();
        System.out.println("4.e");
        Utils.fourE();
        System.out.println("4.f");
        Utils.fourF();
        System.out.println("5.a");
        Utils.fiveA();
        System.out.println("5.b");
        Utils.fiveB();
        System.out.println("5.c");
        Utils.fiveC();
        System.out.println("5.d");
        Utils.fiveD();
        //idk what to do in №6.

        /*System.out.println("Polynomial:");
        var p1 = new MyPolynomial(new double[]{1.0, 1.0});
        var p2 = new MyPolynomial(new double[]{1.0, 1.0, 2.0});
        System.out.println(p1.multiply(p2));
        System.out.println(p1.add(p2));
        System.out.println(p2.evaluate(2));*/
    }
}
