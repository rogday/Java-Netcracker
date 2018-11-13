package com.rogday.task4;

import java.util.Iterator;
import java.util.StringJoiner;

public class MyLinkedList<E> implements ILinkedList<E> {
    class Node<M> {
        M element;
        Node nextNode;

        Node(M element) {
            this.element = element;
            this.nextNode = null;
        }

        /*protected void finalize() {
            System.out.println("I'm dead: " + element);
        }*/ //tests of memory freeing
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public E next() {
                var res = curr.element;
                curr = curr.nextNode;
                return res;
            }
        };
    }

    @SuppressWarnings("unchecked")
    private Node<E> getHelper(int index) {
        if (index == size - 1)
            return tail;

        var obj = head;
        for (int i = 0; i < index; ++i)
            obj = obj.nextNode;

        return obj;
    }

    private boolean saneIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void add(int index, E element) {
        if (!saneIndex(index) && index != size)
            return;

        if (index == 0) { //insertion at the begging of the list
            var tmp = head;
            head = new Node<>(element);
            head.nextNode = tmp;
            if (size == 0)
                tail = head;
        } else {
            if (index == size) { //insertion at the end of the list
                tail.nextNode = new Node<>(element);
                tail = tail.nextNode;
            } else {  //insertion in other places  of the list
                var prev = getHelper(index - 1);
                var next = prev.nextNode;
                prev.nextNode = new Node<>(element);
                prev.nextNode.nextNode = next;
            }
        }
        ++size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {

        if (!saneIndex(index))
            return null;

        Node<E> res;
        if (index == 0) {
            res = head;
            head = head.nextNode;
        } else {
            var t = getHelper(index - 1);
            res = t.nextNode;
            t.nextNode = res.nextNode;
            if (index == size - 1)
                tail = t;
        }
        --size;
        return res.element;
    }

    @Override
    public void clear() {
        head = tail = null; //so, we have no references to the head object,
        size = 0;// and therefore it will be deleted, and so on, right?
    }

    @Override
    public E get(int index) {
        if (!saneIndex(index))
            return null;
        return getHelper(index).element;
    }

    @Override
    public E set(int index, E element) {
        if (!saneIndex(index))
            return null;
        getHelper(index).element = element;
        return element;
    }

    @Override
    public int indexOf(E element) {
        int i = 0;
        for (E el : this) {
            if (el.equals(element))
                return i;
            ++i;
        }
        return -1;
    }

    @Override
    public E[] toArray() {
        if (size == 0)
            return null;

        @SuppressWarnings("unchecked")
        E[] arr = (E[]) new Object[size];

        int i = 0;
        for (E el : this)
            arr[i++] = el;

        return arr;
    }

    @Override
    public String toString() {
        var sj = new StringJoiner(", ", "MyLinkedList{", "}");
        for (E el : this)
            sj.add(el.toString());
        return sj.toString();
    }

    @Override
    public int size() {
        return size;
    }
}
