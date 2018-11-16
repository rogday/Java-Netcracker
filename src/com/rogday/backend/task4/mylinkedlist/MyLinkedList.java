package com.rogday.backend.task4.mylinkedlist;

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
    }

    private Node<E> head = new Node<>(null);
    private Node<E> tail = null;
    private int size = 0;

    @Override
    @SuppressWarnings("unchecked")
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> curr = head.nextNode;

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
        if (index == size - 1 && index != -1)
            return tail;

        var obj = head;
        for (int i = 0; i <= index; ++i)
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

        var prev = getHelper(index - 1);
        var next = prev.nextNode;
        prev.nextNode = new Node<>(element);
        prev.nextNode.nextNode = next;

        if (index == size)  //insertion at the end of the list
            tail = prev.nextNode;

        ++size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (!saneIndex(index))
            return null;

        var t = getHelper(index - 1);
        Node<E> res = t.nextNode;
        t.nextNode = res.nextNode;
        if (index == size - 1)
            tail = t;

        --size;
        return res.element;
    }

    @Override
    public void clear() {
        head.nextNode = tail = null; //so, we have no references to the head object,
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
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        if (size == 0)
            return null;

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