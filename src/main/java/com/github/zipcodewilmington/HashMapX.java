package com.github.zipcodewilmington;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public interface HashMapX<K, V> {
    // fundamentals
//    void set(String key, String value);
//    String delete(String key);
    void set(K key, V value);
    boolean delete(K key);
//    String get(String key);
    V get(K key);
    boolean isEmpty();
    long size();

    // testing access
    boolean bucketSize(String key); // used for tests
}
