package com.company.useless;

public class Son extends FatherClass implements FieldOfInterface{

    public static void main(String[] args){
        /**
         * interface是更低级别的继承。
         */
        FieldOfInterface son = new Son();


        System.out.println("a value is " + son.geta());
    }
}
