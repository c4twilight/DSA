package com.example.test.problem445;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BiDirectionMap {
    private static BiMap<Integer, String> biMap; // {uniqueKey  -> uniqueValue}

    public static void main(String[] args) {
        biMap = HashBiMap.create();
        // Adding entries
        biMap.put(1, "One");
        biMap.put(2, "Two");
        biMap.put(3, "Three");
        System.out.println("Value for key 1: " + biMap.get(1));
        System.out.println("Value for key 2: " + biMap.get(2));
        System.out.println("Key for value 'One': " + biMap.inverse().get("One"));
        System.out.println("Key for value 'Two': " + biMap.inverse().get("Two"));
    }
}
