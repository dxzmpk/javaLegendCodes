package com.company.collections;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class UseHashMap {
    public static void main(String[] args){
        java.util.HashMap<String, String> hashMap = new java.util.HashMap<>();
        hashMap.put("abc", "bcde");
        hashMap.put("abcd", "abcde");

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        String[] strings = new String[hashMap.size()];
        AtomicInteger i = new AtomicInteger();
        hashMap.forEach((key, value) ->
        {
            strings[i.getAndIncrement()] = key + value;
        });
        Stack<Integer> stack = new Stack<>();
        System.out.println(Arrays.toString(strings));
    }
}
