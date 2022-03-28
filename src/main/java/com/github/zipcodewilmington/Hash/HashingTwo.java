package com.github.zipcodewilmington.Hash;

public class HashingTwo implements HashingAlg<String>{
    @Override
    public Integer HashFunction(String input) {
        if (input.length() > 0) {
            return Integer.valueOf(Character.toLowerCase(input.charAt(1)));
        }
        return null;
    }
}
