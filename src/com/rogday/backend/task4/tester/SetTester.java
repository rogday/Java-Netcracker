package com.rogday.backend.task4.tester;

import java.util.Set;

public class SetTester<T extends Set<Integer>> extends Tester<T> {
    public SetTester(T col) {
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
            col.contains(array[i]);
    }

    @Override
    public void removeTest() {
        for (int i = 0; i < N; ++i)
            col.remove(array[i]);
    }
}
