package com.company.basic;

import java.util.*;

public class EnumTest {
    public static void main(String[] args){
        System.out.println(PizzaStatus.ORDERED.name());//ORDERED
        System.out.println(PizzaStatus.ORDERED);//ORDERED
        System.out.println(PizzaStatus.ORDERED.name().getClass());//class java.lang.String
        System.out.println(PizzaStatus.ORDERED.getClass());//class shuang.kou.enumdemo.enumtest.PizzaStatus


        List<Pizza> pizzaList = new LinkedList<>();
        Iterator<Pizza> iterator = pizzaList.iterator();
        EnumMap<Pizza.PizzaStatus, List<Pizza>> pzByStatus = null;
        while (iterator.hasNext()) {
            Pizza pz = iterator.next();
            Pizza.PizzaStatus status = pz.getStatus();
            if (pzByStatus.containsKey(status)) {
                pzByStatus.get(status).add(pz);
            } else {
                List<Pizza> newPzList = new ArrayList<>();
                newPzList.add(pz);
                pzByStatus.put(status, newPzList);
            }
        }
    }
}
