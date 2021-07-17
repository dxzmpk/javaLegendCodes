package com.company.design_pattern;

public class SingletonFull {
    private static SingletonFull SINLETON = new SingletonFull();
    private SingletonFull(){};
    public static SingletonFull getInstance(){
        return SINLETON;
    }
}
