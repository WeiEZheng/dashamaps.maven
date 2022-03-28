package com.github.zipcodewilmington;

import com.github.zipcodewilmington.Hash.HashingAlg;
import com.github.zipcodewilmington.Hash.HashingDefault;


/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMap<K, V> implements HashMapX<K, V>{
    private MyLinkedList<MyEntry>[] myMap = new MyLinkedList[10];
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
        if (size>= myMap.length)
            resize();
        int index = (hashingAlg.HashFunction(key)) % myMap.length;
        if (myMap[index] == null){
            myMap[index] = new MyLinkedList<>();
            myMap[index].add(new MyEntry<>(key, value));
            size++;
        } else {
            for (MyEntry entry : myMap[index]) {
                if (entry.getKey().equals(key)){
                    entry.setValue(value);
                    return;
                }
            }
            myMap[index].add(new MyEntry<>(key, value));
            size++;
        }
    }

    @Override
    public boolean delete(K key) {
        int index = (hashingAlg.HashFunction(key)) % myMap.length;
        if (myMap[index]==null)
            return false;
        MyEntry<K,V> entryToRemove = null;
        for (MyEntry<K,V> entry : myMap[index]) {
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
    public V get(K key) {
        int index = (hashingAlg.HashFunction(key)) % myMap.length;
        if (myMap[index] == null)
            return null;
        for (MyEntry<K,V> entry : myMap[index]){
            if (entry.getKey().equals(key))
                return entry.getValue();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        if (size>0)
            return false;
        return true;
    }

    @Override
    public long size() {
        return size;
    }

    @Override
    public boolean bucketSize(String key) {
        return false;
    }

    public void resize() {
        MyLinkedList<MyEntry>[] oldMap = myMap;
        myMap = new MyLinkedList[(int)size+10];
        size=0;
        for (int i=0; i<oldMap.length;i++) {
            if (oldMap[i]==null)
                continue;
            for (MyEntry<K, V> entry : oldMap[i]) {
                set(entry.getKey(), entry.getValue());
            }
        }
    }
}
