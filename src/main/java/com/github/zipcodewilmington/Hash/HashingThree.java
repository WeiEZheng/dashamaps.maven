package com.github.zipcodewilmington.Hash;

public class HashingThree implements HashingAlg<String>{
    //Does not support hashing of non-strings
    @Override
    public Integer HashFunction(String input) {
        if (input.length() > 1) {
            return Integer.valueOf(Character.toLowerCase(input.charAt(0))+Character.toLowerCase(input.charAt(1)));
        }
        return null;
    }
}
