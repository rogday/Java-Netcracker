package com.rogday.backend.task4.tester;

import java.util.Random;

public abstract class Tester<T> {
    protected static int[] array;
    protected static int N;
    protected T col;
    private String colName;

    Tester(T col) {
        this.col = col;
        this.colName = col.getClass().toString();
    }

    public static void genArr(int N) {
        Tester.N = N;
        var rand = new Random();
        array = new int[N];
        for (int i = 0; i < N; ++i)
            array[i] = rand.nextInt(i + 1);
    }

    private void estimator(Runnable f, String action) {
        long t1 = System.currentTimeMillis();
        f.run();
        long t2 = System.currentTimeMillis() - t1;
        System.out.println(String.format("%s %s %d elements in %d miliseconds",
                colName, action, N, t2));
    }

    public void runAll() {
        estimator(this::addTest, "added");
        estimator(this::getTest, "got");
        estimator(this::removeTest, "removed");
    }

    public abstract void addTest();

    public abstract void getTest();

    public abstract void removeTest();
}
