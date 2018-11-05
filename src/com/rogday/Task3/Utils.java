package com.rogday.Task3;

public class Utils {
    public static Void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }

            }
        }
        return null;
    }

    public static Void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            int imax = i;
            for (int j = i + 1; j < arr.length; ++j)
                if (arr[imax] > arr[j])
                    imax = j;

            int t = arr[imax];
            arr[imax] = arr[i];
            arr[i] = t;
        }
        return null;
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

    @FunctionalInterface
    interface Figure {
        boolean magic(int i, int j);
    }

    private static void drawFigHelper(int n, int m, Figure fig) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j)
                if (fig.magic(i, j))
                    System.out.print("# ");
                else
                    System.out.print("  ");
            System.out.println();
        }
        System.out.println();
    }

    public static void drawFig(int n, int m) {
        Figure[] arr = new Figure[]{
                (i, j) -> i >= j,
                (i, j) -> i <= m - j - 1,
                (i, j) -> i <= j,
                (i, j) -> i >= m - j - 1,
                (i, j) -> i % (n - 1) == 0 || j % (m - 1) == 0,
                (i, j) -> i % (n - 1) == 0 || i == j,
                (i, j) -> i % (n - 1) == 0 || i == m - j - 1,
                (i, j) -> i == j || i == (m - j - 1) ||
                        i == 0 || i == (n - 1),
                (i, j) -> i == j || i == (m - j - 1) ||
                        i == 0 || j == 0 || i == (n - 1) || j == (m - 1)
        };

        for (var f : arr)
            drawFigHelper(n, m, f);
    }
}
