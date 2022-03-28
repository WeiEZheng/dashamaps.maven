package com.github.zipcodewilmington.Hash;

public class HashingOne implements HashingAlg<String>{
    //Does not support hashing of non-strings
    @Override
    public Integer HashFunction(String input) {
        if (input.length() > 0) {
            return Integer.valueOf(Character.toLowerCase(input.charAt(0)));
        }
        return null;
    }
}
