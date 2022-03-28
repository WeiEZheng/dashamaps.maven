package com.github.zipcodewilmington;

import com.github.zipcodewilmington.Hash.HashingAlg;
import com.github.zipcodewilmington.Hash.HashingDefault;

import java.util.LinkedList;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMap<K, V> implements HashMapX<K, V>{
//    private MyLinkedList<myEntry>[] myMap = new MyLinkedList[1000];
    private LinkedList<myEntry<K,V>> [] myMap = new LinkedList[1000];
    private long size;
    private HashingAlg hashingAlg;

    public DashaMap(){
        hashingAlg=new HashingDefault<K>();
    }

    public DashaMap(HashingAlg hashingAlg){
        this.hashingAlg = hashingAlg;
    }

    @Override
    public void set(K key, V value) {
        //need to consider size issue, resize method needed and need to check for size
        int index = ((int) hashingAlg.HashFunction(key)) % myMap.length;
        if (myMap[index] == null){
//            myMap[index] = new MyLinkedList<>();
            myMap[index] = new LinkedList<>();
            myMap[index].add(new myEntry<>(key, value));
            size++;
        } else {
            for (myEntry<K,V> entry : myMap[index]) { //implement iterable to mylinkedlist
                if (entry.getKey().equals(key)){
                    entry.setValue(value);
                    size++;
                    return;
                }
            }
            myMap[index].add(new myEntry<>(key, value));
            size++;
        }
    }

    @Override
    public boolean delete(K key) {
        int index = ((int) hashingAlg.HashFunction(key)) % myMap.length;
        if (myMap[index]==null)
            return false;
        myEntry<K,V> entryToRemove = null;
        for (myEntry<K,V> entry : myMap[index]) {
            if (entry.getKey().equals(key)) {
                entryToRemove = entry;
                break;
            }
        }
        if (entryToRemove == null) return false;
        myMap[index].remove(entryToRemove);
        size--;
        return true;
    }

    @Override
    public V get(String key) {
        int index = ((int) hashingAlg.HashFunction(key)) % myMap.length;
        if (myMap[index] == null)
            return null;
        for (myEntry<K,V> entry : myMap[index]){
            if (entry.getKey().equals(key))
                return entry.getValue();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        if (size>0)
            return true;
        return false;
    }

    @Override
    public long size() {
        return size;
    }

    @Override
    public boolean bucketSize(String key) {
        return false;
    }
}
