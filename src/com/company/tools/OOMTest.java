package com.company.tools;

import java.util.ArrayList;
import java.util.List;

public class OOMTest {
    
    static class OOMObject {
        
        public byte[] placeholder = new byte[64 * 1024];
        
    }
    
    public static void fillHeap(int num) throws InterruptedException {
        Thread.sleep(7000);
        System.out.println("Starting creation of OOM object");
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i<num; i++) {
            // 延时的目的是让曲线变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.out.println("Doing gc");
        System.gc();
    }  
    
    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
        System.out.println("Stay for 5 sec");
        Thread.sleep(5000);
        System.out.println("Doing gc outside of fillHeap");
        System.gc();
        System.out.println("Stay for 5 sec");
        Thread.sleep(5000);

    }
    
    
}
