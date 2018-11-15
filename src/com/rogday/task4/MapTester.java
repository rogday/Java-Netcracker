package com.rogday.task4;

import java.util.Map;

public class MapTester<T extends Map<Integer, Integer>> extends Tester<T> {
    public MapTester(T map) {
        super(map);
    }

    @Override
    public void addTest() {
        for (int i = 0; i < N; ++i)
            col.put(i, array[i]);
    }

    @Override
    public void getTest() {
        for (int i = 0; i < N; ++i)
            col.get(array[i]);
    }

    @Override
    public void removeTest() {
        for (int i = 0; i < N; ++i)
            col.remove(array[i]);
    }
}
