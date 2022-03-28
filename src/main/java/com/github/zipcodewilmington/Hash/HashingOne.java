package com.github.zipcodewilmington.Hash;

public class HashingOne implements HashingAlg<String>{
    @Override
    public Integer HashFunction(String input) {
        if (input.length() > 0) {
            return Integer.valueOf(Character.toLowerCase(input.charAt(0)));
        }
        return null;
    }
}
