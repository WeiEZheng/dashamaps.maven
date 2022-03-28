package com.github.zipcodewilmington.Hash;

public class HashingTwo implements HashingAlg<String, String>{
    @Override
    public String HashFunction(String input) {
        if (input.length() > 0) {
            return (String.valueOf(input.charAt(1))).toLowerCase();
        }
        return null;
    }
}
