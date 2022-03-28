package com.github.zipcodewilmington.Hash;

public interface HashingAlg<K, ReturnType> {
    ReturnType HashFunction(K input);
}
