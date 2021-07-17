package com.company.design_pattern;

public class SingletonStaticInner {

    public static SingletonStaticInner getInstance() {
        return SinletonHolder.INSTANCE;
    }
    
    private SingletonStaticInner(){
        System.out.println("Sinleton is inited");
    };

    static class SinletonHolder {
        public static final SingletonStaticInner INSTANCE = new SingletonStaticInner();
        
    }
}
