package com.github.zipcodewilmington;

public class myEntry<K, V> {
    private K key;
    private V value;

    public myEntry(K key, V value) {
        this.key=key;
        this.value=value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }
}
