package com.rogday.task4;

import java.util.Random;

public abstract class Tester<T> {
    protected int[] array;
    protected int N;
    protected T col;
    private String colName;

    Tester(int N, T col) {
        this.N = N;
        this.col = col;
        this.colName = col.getClass().toString();
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
