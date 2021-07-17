package com.company.multi_thread;

public class NoVisibility {

    private static boolean ready;

    private static int number;

    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args){
        Thread thread1 = new ReaderThread();
        thread1.start();
        number = 42;
        ready = true;
    }
}
