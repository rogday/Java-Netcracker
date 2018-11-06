package com.rogday;

import com.rogday.Task3.Utils;

import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    private static void estimator(int[] arr, String method, Consumer<int[]> s) {
        var arr2 = arr.clone();
        long startTime = System.nanoTime();
        s.accept(arr2);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(method + estimatedTime);
    }

    public static void main(String[] args) {
        int[] arr = Utils.generate(5000, 0, 1000);

        estimator(arr, "BubbleSort: ", Utils::bubbleSort);
        estimator(arr, "SelectionSort: ", Utils::selectionSort);
        estimator(arr, "Arrays.sort(): ", Arrays::sort);

        long startTime = System.nanoTime();
        long ans = Utils.factRec(15);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Recursion: 15! = " + ans + " " + estimatedTime);

        startTime = System.nanoTime();
        ans = Utils.factIter(15);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Iteration: 15! = " + ans + " " + estimatedTime);

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
    }
}
