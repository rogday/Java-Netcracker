package com.rogday.Task4;

import java.util.Arrays;
import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E> {
    class Node<E> {
        private E element;
        private Node nextNode;

        public Node(E element) {
            this.element = element;
            this.nextNode = null;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        /*protected void finalize() {
            System.out.println("I'm dead: " + element);
        }*/ //tests of memory freeing
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<E> getHelper(int index) {
        if (index == size - 1)
            return tail;

        var obj = head;
        for (int i = 0; i < index; ++i)
            obj = obj.getNextNode();

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
    public void add(int index, E element) {
        if (!saneIndex(index) && index != size)
            return;

        if (index == 0) { //insertion at the begging of the list
            var tmp = head;
            head = new Node<>(element);
            head.setNextNode(tmp);
            if (size == 0)
                tail = head;
        } else {
            if (index == size) { //insertion at the end of the list
                tail.setNextNode(new Node<>(element));
                tail = tail.getNextNode();
            } else {  //insertion in other places  of the list
                var prev = getHelper(index - 1);
                var next = prev.getNextNode();
                prev.setNextNode(new Node<>(element));
                prev.getNextNode().setNextNode(next);
            }
        }
        ++size;
    }

    @Override
    public E remove(int index) {
        if (!saneIndex(index))
            return null;

        Node<E> res;
        if (index == 0) {
            res = head;
            head = head.getNextNode();
        } else {
            var t = getHelper(index - 1);
            res = t.getNextNode(); //Why cant I use var here?
            t.setNextNode(res.getNextNode());
            if (index == size - 1)
                tail = t;
        }
        --size;
        return res.getElement();
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
        return getHelper(index).getElement();
    }

    @Override
    public E set(int index, E element) {
        if (!saneIndex(index))
            return null;
        getHelper(index).setElement(element);
        return element;
    }

    @Override
    public int indexOf(E element) {
        var tmp = head;
        for (int i = 0; i < size; ++i) {
            if (element.equals(tmp.getElement()))
                return i;
            tmp = tmp.getNextNode();
        }
        return -1;
    }

    @Override
    public E[] toArray() {
        if (size == 0)
            return null;

        @SuppressWarnings("unchecked")
        E[] arr = (E[]) new Object[size];
        var tmp = head;
        for (int i = 0; i < size; ++i) {
            arr[i] = tmp.getElement();
            tmp = tmp.getNextNode();
        }

        return Arrays.copyOf(arr, size); //idk how to copy it manually.
    }

    @Override
    public String toString() {
        var sb = new StringBuilder("MyLinkedList{");
        var obj = head;
        for (int i = 0; i < size - 1; ++i) {
            sb.append(obj.getElement()).append(", ");
            obj = obj.getNextNode();
        }
        if (size != 0)
            sb.append(tail.getElement());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public E next() {
                var res = curr.getElement();
                curr = curr.getNextNode();
                return res;
            }
        };
    }
}
