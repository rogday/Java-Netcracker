package com.rogday.backend.task4;

import com.rogday.backend.task4.mylinkedlist.MyLinkedList;
import com.rogday.backend.task4.tester.ListTester;
import com.rogday.backend.task4.tester.MapTester;
import com.rogday.backend.task4.tester.SetTester;
import com.rogday.backend.task4.tester.Tester;

import java.util.*;

public class Main {
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

        // MyLinkedList is 2-3 times slower than standard implementation
        // I won't give any proofs here since I don't like the testing code.

        int N = 100_000;
        Tester.genArr(N);

        var array1 = new ArrayList<Map<Integer, Integer>>();
        array1.add(new HashMap<>());
        array1.add(new LinkedHashMap<>());
        array1.add(new TreeMap<>());

        for (var col : array1) {
            var tester = new MapTester<>(col);
            tester.runAll();
        }

        var array2 = new ArrayList<Set<Integer>>();
        array2.add(new HashSet<>());
        array2.add(new LinkedHashSet<>());
        array2.add(new TreeSet<>());

        for (var col : array2) {
            var tester = new SetTester<>(col);
            tester.runAll();
        }

        var array3 = new ArrayList<List<Integer>>();
        array3.add(new ArrayList<>());
        array3.add(new LinkedList<>());

        for (var col : array3) {
            var tester = new ListTester<>(col);
            tester.runAll();
        }

        /*  Conclusion:
         *  ArrayList is as fast as LinkedList in adding element to the end of collection, but
         *  both data structures cant gracefully handle random element removing, LinkedList cant
         *  because it takes O(n) to get to element and ArrayList cant because all elements should
         *  be shifted. LinkedListed should be preferred over ArrayList if there is a necessity of
         *  frequent insertions in the middle of the collection.
         *
         *  There is no significant differences in HashSet(Map) and LinkedHashSet(Map) in terms of
         *  speed. Since underneath these classes are hash-tables of some kind, all operations take
         *  O(1) in average. Linked structures should be used to track insertion order.
         *
         *  TreeSet(Map) operations are logarithmic, this class sorts elements automatically.
         */

    }
}
