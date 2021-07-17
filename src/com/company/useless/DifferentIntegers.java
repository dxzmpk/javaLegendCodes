package com.company.useless;

import java.util.concurrent.atomic.AtomicInteger;

public class DifferentIntegers {
    public static void main(String[] args){
        AtomicInteger atom = new AtomicInteger();
        atom.set(12);
        atom.addAndGet(5);
        Integer integer = Integer.valueOf(4);
    }
}
