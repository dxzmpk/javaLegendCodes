package com.company.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        queue.offer(3);
        System.out.println(Arrays.toString(queue.toArray()));
        queue.offer(1);
        System.out.println(Arrays.toString(queue.toArray()));
        queue.offer(4);
        System.out.println(Arrays.toString(queue.toArray()));
        queue.offer(2);
        System.out.println(Arrays.toString(queue.toArray()));
        queue.offer(5);
        System.out.println(Arrays.toString(queue.toArray()));
        queue.offer(6);
        System.out.println(Arrays.toString(queue.toArray()));
    }
}
