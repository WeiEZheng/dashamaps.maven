package com.github.zipcodewilmington;

public class MyLinkedList<T> {
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private long listSize;

    public static class LinkedListNode<T> {
        T currentData;
        LinkedListNode<T> nextData;

        LinkedListNode(T currentData){
            this.currentData = currentData;
            this.nextData = null;
        }

        void setNext(LinkedListNode<T> next){
            nextData = next;
        }

        LinkedListNode<T> getNext(){
            return nextData;
        }

        T getData(){
            return currentData;
        }

        void setCurrentData(T data){
            currentData=data;
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

    public void remove(int index){
        int count=0;
        if (index>listSize)
            return;
        if (index==0) {
            head = head.getNext();
            listSize--;
        }
        else {
            LinkedListNode<T> current = head;
            LinkedListNode<T> previous = null;
            while (count != index) {
                previous = current;
                current = current.getNext();
                count++;
            }
            previous.setNext(current.getNext());
            listSize--;
        }
    }

    public int find(T element){
        LinkedListNode<T> current = head;
        int index = 0;
        while (current != null){
            if (current.getData().equals(element)){
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public T get(int index){
        int count=0;
        LinkedListNode<T> current = head;
        while (count!=index){
            current=current.getNext();
            count++;
        }
        return current.getData();
    }

    public long size() {
        return listSize;
    }
}
