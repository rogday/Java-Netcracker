package com.rogday.task4;

import java.util.List;

public class ListTester<T extends List<Integer>> extends Tester<T> {
    public ListTester(T col) {
        super(col);
    }

    @Override
    public void addTest() {
        for (int i = 0; i < N; ++i)
            col.add(i);
    }

    @Override
    public void getTest() {
        for (int i = 0; i < N; ++i)
            col.get(array[i]);
    }

    @Override
    public void removeTest() {
        for (int i = N - 1; i >= 0; --i)
            col.remove(array[i]);
    }
}
