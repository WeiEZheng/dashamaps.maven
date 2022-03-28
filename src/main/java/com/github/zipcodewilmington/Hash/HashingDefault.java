package com.github.zipcodewilmington.Hash;

public class HashingDefault<K> implements HashingAlg<K, Integer>{
    @Override
    public Integer HashFunction(K input) {
        return input.hashCode();
    }
}