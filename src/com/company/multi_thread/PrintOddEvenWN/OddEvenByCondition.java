package com.company.multi_thread.PrintOddEvenWN;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenByCondition {

    Lock lock = new ReentrantLock();

    int val = 1;

    boolean idOddNum = true;

    Condition isOdd = lock.newCondition();

    Condition isEven = lock.newCondition();

    public void run() {
        while(val < 10) {
            if (idOddNum) {
                printOdd(val);
            } else {
                printEven(val);
            }
        }
    }

    private void printEven(int val) {
        while (val % 2 != 0) {
            try {
                isOdd.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(val);
        idOddNum = !idOddNum;
        isEven.signal();
    }

    private void printOdd(int val) {
        while (!idOddNum) {
            try {
                isEven.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(val);
        idOddNum = !idOddNum;
        isOdd.signal();
    }
    //CAS : 1 2 = 3 ABA
    public static void main(String[] args){
        //Thread threadOdd = new Thread(new OddEvenByCondition());
    }
}
