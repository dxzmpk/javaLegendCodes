package com.company.multi_thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// one java thread = one OS thread
// fixed num of threads and start 1000 tasks
// a blocking queue store all the tasks, T0 to T9 fetch and execute concurrently
public class ThreadPoolTest {

    public static void main(String[] args) {

        int nProcessers = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(nProcessers);

        for (int i = 0; i < 10000; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread Name: " + Thread.currentThread().getName());
                }
            });
        }
    }

}
