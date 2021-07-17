package com.company.useless;

public interface FieldOfInterface {

    /**
     * 成员变量默认为public static final
     */
    int a = 0;
    int c = 0;
    static int b = 0;


    default int geta() {
        return a;
    }

    /**
     * All the methods in an interface are public and abstract (except static and default).
     * @return
     */
    static int getB() {
        return b;
    }

    public static void main(String[] args) {
        // write your code here
        FieldOfInterface fieldOfInterface = new FieldOfInterface() {
        };
        FieldOfInterface.getB();
        int c = FieldOfInterface.a;

        int a = fieldOfInterface.geta();
    }

}
