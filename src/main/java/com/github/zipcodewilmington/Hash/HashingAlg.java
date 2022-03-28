package com.github.zipcodewilmington.Hash;

public interface HashingAlg<K> {
    Integer HashFunction(K input);
}
