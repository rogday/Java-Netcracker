package com.rogday;

import com.rogday.Task3.Utils;

import java.util.Random;
import java.util.Arrays;
import java.util.function.Function;

public class Main {
    private static void estimator(int[] arr, String method, Function<int[], Void> s) {
        var arr2 = arr.clone();
        long startTime = System.nanoTime();
        s.apply(arr2);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(method + estimatedTime);
    }

    public static void main(String[] args) {
        Random rand = new Random();

        int n = rand.nextInt(4501) + 500; //n = [500; 5000]
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++)
            arr[i] = rand.nextInt(1001);

        estimator(arr, "BubbleSort: ", Utils::bubbleSort);
        estimator(arr, "SelectionSort: ", Utils::selectionSort);
        Function<int[], Void> f = (array) -> {
            Arrays.sort(array);
            return null;
        };
        estimator(arr, "Arrays.sort(): ", f);


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
    }
}
