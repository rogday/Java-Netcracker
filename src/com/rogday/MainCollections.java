package com.rogday;

import com.rogday.Task4.MyLinkedList;

public class MainCollections {
    public static void main(String[] args) {
        var test = new MyLinkedList<Integer>();

        //add(e)
        for (int i = 0; i < 5; ++i)
            test.add(i);

        //add(i, e)
        for (int i = 0; i < 5; ++i)
            test.add(test.size() - i, i + 5);

        System.out.println(test);
        System.out.println(test.size());

        /* //clear()
        test.clear();
        System.runFinalization();
        System.gc();
        while (true) {}
        */

        //get(i)
        for (int i = 0; i < test.size() / 2; ++i)
            System.out.print(test.get(test.size() - i - 1) + " ");
        System.out.println();

        //toArray()
        Object[] arr = test.toArray();
        for (var i : arr)
            System.out.print(i + " ");

        System.out.println();

        //indexOf()
        for (int i = 0; i < 5; ++i)
            System.out.print(test.indexOf(4 - i) + " ");
        System.out.println();

        //remove
        for (int i = 0; i < test.size(); ++i)
            if (test.get(i) % 2 == 0) {
                test.remove(i);
                --i;
            }
        System.out.println(test);

        //set
        for (int i = 0; i < test.size(); ++i)
            test.set(test.size() - i - 1, i + 100);
        System.out.println(test);

        //Iterator
        for (var c : test)
            System.out.print(c + " ");
        System.out.println();
    }
}
