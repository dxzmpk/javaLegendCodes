package com.company.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperations {
    //public static void main(String[] args){
    //    List<String> words = Arrays.asList("hello c++", "hello java", "hello python");
    //    List<String> result = words.stream()
    //                                  // 将单词按照空格切合，返回Stream<String[]>类型的数据
    //                                  .map(word -> word.split(" "))
    //                                  // 将Stream<String[]>转换为Stream<String>
    //                                  .flatMap(Arrays::stream)
    //                                  // 去重
    //                                  .distinct()
    //                                  .collect(Collectors.toList());
    //    System.out.println(result);
    //}
    
    public static void main(String[] args){
        List<Integer> integers = new ArrayList<Integer>() {
            {
                add(4);
                add(2);
                add(1);
                add(3);
            }
        };
        Integer sortedList = integers.stream().peek(System.out::println).sorted((x1, x2)-> x2-x1).min((x1,x2)->x1-x2).get();
        System.out.println("sorted list = " + sortedList);
        integers.stream().anyMatch(x->x%2==0);
        integers.stream().allMatch(x->x%2==1);
        integers.stream().noneMatch(x->x==0);

        IntStream.range(1,10).boxed().collect(Collectors.toList());
        Double avgSal = integers.stream()
                                .mapToDouble(x->x.doubleValue())
                                .average()
                                .orElseThrow(NoSuchElementException::new);

        Collectors.joining(", ");
    }

}
