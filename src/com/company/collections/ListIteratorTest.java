package com.company.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(0);
                add(1);
                add(2);
                add(3);
                add(4);
            }
        };
        Iterator<Integer> iterator = list.iterator();
        ListIterator<Integer> listIterator = list.listIterator();
        while (iterator.hasNext()) {
            int val = iterator.next();
            iterator.remove();
            System.out.println("val = " + val);
        }



    }

}
