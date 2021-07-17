package com.company.multi_thread;

public class PrintOddEven {
    public static void main(String[] args) throws InterruptedException {
        final Integer[] a = {0};
        Thread thread1 = new Thread(() -> {
            int formal = 0;
            while (true) {
                synchronized (a) {
                    if (a[0] != formal) {
                        if (a[0]%2!=0){
                            System.out.println(Thread.currentThread().getName() + ": " +a[0]);
                            formal = a[0];
                        }
                    }
                    //try {
                    //    a.wait();
                    //} catch (InterruptedException e) {
                    //    e.printStackTrace();
                    //}
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            int formal = 0;
            while (true) {
                synchronized (a) {
                    if (a[0] != formal) {
                        if (a[0]%2==0){
                            System.out.println(Thread.currentThread().getName() + ": " +a[0]);
                            formal = a[0];
                        }
                    }
                    //try {
                    //    a.wait();
                    //} catch (InterruptedException e) {
                    //    e.printStackTrace();
                    //}
                }
            }
        });
        thread1.setName("thread1");
        thread2.setName("thread2");
        thread1.start();
        thread2.start();

        for(int i = 1; i <= 9; i++) {
            Thread.sleep(1000);
            //synchronized (a) {
                a[0] ++;
                //a.notifyAll();
            //}
        }
    }

}
