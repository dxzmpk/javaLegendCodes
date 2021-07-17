package com.company.design_pattern;

public class SingletonLazy {
    private static SingletonLazy INSTANCE;
    private SingletonLazy(){};
    public static synchronized SingletonLazy getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonLazy();
        }
        return INSTANCE;
    }
}
