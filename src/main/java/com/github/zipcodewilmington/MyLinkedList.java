package com.github.zipcodewilmington;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private long listSize;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            LinkedListNode<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T data = current.getData();
                    current = current.getNext();
                    return data;
                }
                return null;
            }
        };
    }

    public static class LinkedListNode<T> {
        T currentData;
        LinkedListNode<T> nextData;

        LinkedListNode(T currentData) {
            this.currentData = currentData;
            this.nextData = null;
        }

        void setNext(LinkedListNode<T> next) {
            nextData = next;
        }

        LinkedListNode<T> getNext() {
            return nextData;
        }

        T getData() {
            return currentData;
        }

        void setCurrentData(T data) {
            currentData = data;
        }
    }

    public void add(T data) {
        LinkedListNode<T> thisNode = new LinkedListNode<T>(data);
        if (head == null)
            head = thisNode;
        else {
            tail.setNext(thisNode);
        }
        tail = thisNode;
        listSize++;
    }

    public void remove(T value) {
        LinkedListNode<T> current = head;
        LinkedListNode<T> previous = null;
        while (current.getNext() != null) {
            if (current.getData() == value)
                break;
            previous = current;
            current = current.getNext();
        }
        if (previous != null)
            previous.setNext(current.getNext());
        else
            head = null;
        listSize--;
    }
}
