package com.github.zipcodewilmington.Hash;

public class HashingThree implements HashingAlg<String, String>{

    @Override
    public String HashFunction(String input) {
        if (input.length() > 1) {
            return (String.valueOf(input.charAt(0)+input.charAt(1))).toLowerCase();
        }
        return null;
    }
}
