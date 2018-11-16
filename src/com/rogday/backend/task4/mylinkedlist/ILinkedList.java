package com.rogday.backend.task4.mylinkedlist;

public interface ILinkedList<E> extends Iterable<E> {
    void add(E element);
    void add(int index, E element);

    E get(int index);

    E set(int index, E element);

    int indexOf(E element);
    E remove(int index);

    int size();

    E[] toArray();
    String toString();

    void clear();
}
