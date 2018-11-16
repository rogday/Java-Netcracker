package com.rogday.frontend.task1;

import java.util.ArrayList;
import java.util.Random;

public class BookGenerator {
    private static Random rand = new Random();

    private static int getInt(int a, int b) {
        return rand.nextInt(b - a + 1) + a;
    }

    private static String getString(int n) {
        var sb = new StringBuilder();

        for (int i = 0; i < n; ++i) {
            int rnd = getInt(0, 51);
            char base = (rnd < 26) ? 'A' : 'a';
            char c = (char) (base + rnd % 26);
            sb.append(c);
        }

        return sb.toString();
    }

    public static ArrayList<Book> generate(int N) {
        var arr = new ArrayList<Book>();

        for (int i = 0; i < N; ++i) {
            String title = getString(getInt(5, 13));

            int len = getInt(1, 4);
            var authors = new ArrayList<String>();

            for (int j = 0; j < len; ++j)
                authors.add(getString(getInt(5, 13)));

            arr.add(new Book(title, authors, getInt(100, 10000)));
        }

        return arr;
    }
}
