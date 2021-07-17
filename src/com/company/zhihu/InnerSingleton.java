package com.company.zhihu;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class InnerSingleton{

    private static InnerSingleton SINGLETON;


    private InnerSingleton() {

    }
    static class InnerClass{
        private static InnerSingleton singleton = new InnerSingleton();

    }
    public static InnerSingleton getInstance(){
        if (SINGLETON == null) {
            SINGLETON = new InnerSingleton();
        }
        return SINGLETON;
    }
}

class TestReflection{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<InnerSingleton> innerSingletonConstructor = InnerSingleton.class.getDeclaredConstructor();
        innerSingletonConstructor.setAccessible(true);
        InnerSingleton innerSingleton = innerSingletonConstructor.newInstance();
        InnerSingleton instance1 = InnerSingleton.getInstance();
        System.out.println(innerSingleton == instance1); //false

    }
}