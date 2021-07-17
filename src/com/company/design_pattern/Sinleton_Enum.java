package com.company.design_pattern;


public enum Sinleton_Enum {
    INSTANCE;
    Sinleton_Enum() {
        // Initialization configuration which involves
        // overriding defaults like delivery strategy
    }


    public static Sinleton_Enum getInstance() {
        return INSTANCE;
    }
}