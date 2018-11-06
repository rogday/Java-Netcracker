package com.rogday.Task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.BiPredicate;

public class Utils {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }

            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            int imax = i;
            for (int j = i + 1; j < arr.length; ++j)
                if (arr[imax] > arr[j])
                    imax = j;

            int t = arr[imax];
            arr[imax] = arr[i];
            arr[i] = t;
        }
    }

    public static long factRec(long n) {
        if (n <= 1)
            return 1;
        return n * factRec(n - 1);
    }

    public static long factIter(long n) {
        long r = 1;
        while (n != 1)
            r *= n--;
        return r;
    }

    public static void drawRect(int n, int m) {
        while (n-- > 0) {
            for (int i = 0; i < m; ++i)
                System.out.print("# ");
            System.out.println();
        }
        System.out.println();
    }

    private static void drawFigHelper(int n, int m, BiPredicate<Integer, Integer> fig) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j)
                if (fig.test(i, j))
                    System.out.print("# ");
                else
                    System.out.print("  ");
            System.out.println();
        }
        System.out.println();
    }

    public static void drawFig(int n, int m) {
        var arr = new ArrayList<BiPredicate<Integer, Integer>>();
        arr.add((i, j) -> i >= j);
        arr.add((i, j) -> i <= m - j - 1);
        arr.add((i, j) -> i <= j);
        arr.add((i, j) -> i >= m - j - 1);
        arr.add((i, j) -> i % (n - 1) == 0 || j % (m - 1) == 0);
        arr.add((i, j) -> i % (n - 1) == 0 || i.equals(j));
        arr.add((i, j) -> i % (n - 1) == 0 || i == m - j - 1);
        arr.add((i, j) -> i.equals(j) || i == (m - j - 1) ||
                i % (n - 1) == 0);
        arr.add((i, j) -> i.equals(j) || i == (m - j - 1) ||
                i % (n - 1) == 0 || j % (m - 1) == 0);

        for (var f : arr)
            drawFigHelper(n, m, f);
    }

    public static void fourA() {
        var arr = new int[50];

        for (int i = 0; i < arr.length; ++i)
            arr[i] = i * 2 + 1;

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length / 2; ++i) {
            int t = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = t;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static int[] generate(int n, int a, int b) {
        var rand = new Random();
        var arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = rand.nextInt(b - a + 1) + a;
        return arr;
    }

    public static void fourB() {
        int[] arr = generate(20, 0, 10);

        int even = 0, odd = 0;
        for (var i : arr)
            if (i % 2 == 0)
                ++even;
            else
                ++odd;

        System.out.println(Arrays.toString(arr));
        System.out.println("Even: " + even + ", odd: " + odd);
    }

    public static void fourC() {
        int[] arr = generate(10, 1, 100);

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length / 2; ++i)
            arr[i * 2 + 1] = 0;

        System.out.println(Arrays.toString(arr));
    }

    public static void fourD() {
        int[] arr = generate(15, -50, 50);
        int imax = 0, imin = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] <= arr[imin])
                imin = i;
            if (arr[i] >= arr[imax])
                imax = i;
        }
        System.out.println("Min: " + arr[imin] + ", index=" + imin + "; max: " + arr[imax] + ", index=" + imax);
    }

    public static void fourE() {
        var matrix = new int[][]{generate(10, 0, 10), generate(10, 0, 10)};

        for (var arr : matrix)
            System.out.println(Arrays.toString(arr));

        double a1 = Arrays.stream(matrix[0]).average().orElse(Double.NaN);
        double a2 = Arrays.stream(matrix[1]).average().orElse(Double.NaN);

        if (Math.abs(a1 - a2) < 0.000001) {
            System.out.println("Equal");
            return;
        }
        System.out.print("Average of first array is ");
        if (a1 > a2)
            System.out.println("bigger.");
        else
            System.out.println("smaller.");
    }

    public static void fourF() {
        int[] arr = generate(10, -1, 1);
        var counts = new int[3];

        System.out.println(Arrays.toString(arr));

        for (var i : arr)
            ++counts[i + 1];

        //generally speaking, I should sort indexes and then loop over that array while prev=current
        int imax1 = 0, imax2 = -1;
        for (int i = 1; i < 3; ++i) {
            if (counts[i] > counts[imax1]) {
                imax2 = imax1;
                imax1 = i;
            } else if (imax2 == -1 || counts[i] >= counts[imax2])
                imax2 = i;
        }

        System.out.println((imax1 - 1) + " was found " + counts[imax1] + " times");
        if (counts[imax2] == counts[imax1])
            System.out.println((imax2 - 1) + " was found " + counts[imax2] + " times");

    }
}
