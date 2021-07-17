package com.company.oop;

import com.company.basic.ComputationOrder;

import java.util.ArrayList;
import java.util.List;

public class GenericArray<T> {
    public T[] getArray() {
        //return new T[10];
        List<T> list = new ArrayList<>();
        return null;
    }

    public static void main(String[] args){
        GenericArray<ComputationOrder> c = new GenericArray<>();
        ComputationOrder[] array = c.getArray();
        System.out.println("array [0] = " + array[0]);
    }
}
