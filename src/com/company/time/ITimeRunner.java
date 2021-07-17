package com.company.time;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface ITimeRunner {

    void run1();

    default void run2(){
        throw new NotImplementedException();
    }

}
