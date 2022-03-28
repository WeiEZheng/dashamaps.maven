package com.github.zipcodewilmington;

import com.github.zipcodewilmington.Hash.HashingAlg;
import com.github.zipcodewilmington.Hash.HashingDefault;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMap<K, V> implements HashMapX{
    private MyLinkedList[] myMap = new MyLinkedList[1];
    private int size;
    private HashingAlg hashingAlg;

    public DashaMap(){
        hashingAlg=new HashingDefault<K>();
    }

    public DashaMap(HashingAlg hashingAlg){
        this.hashingAlg = hashingAlg;
    }

    @Override
    public void set(String key, String value) {
    }

    @Override
    public String delete(String key) {
        return null;
    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public long size() {
        return 0;
    }

    @Override
    public boolean bucketSize(String key) {
        return false;
    }
}
