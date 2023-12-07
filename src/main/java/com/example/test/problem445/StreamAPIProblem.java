package com.example.test.problem445;
import java.util.*;
import java.util.stream.Collectors;

public class StreamAPIProblem {
    public static void main(String[] args) {
        //1.even number
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
        List<Integer> list2 = list.stream().filter(n-> n%2== 0).collect(Collectors.toList());
        //list.stream().filter(n-> n%2== 0).forEach(System.out::println);

        System.out.println(list2);

        // 2. number starting with 1
        list =  Arrays.asList(11,12,3,41,115,6,7,8,9,0,11,41);

         list2  =   list.stream().map(n -> n+"")  //convert int to string;
                .filter(s -> s.startsWith("1")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(list2);

        //3. double each number in list, i.e. 2*num.
               list2 = list.stream().map(n->2*n).collect(Collectors.toList());
        System.out.println(list2);

        //4. find Duplicate elements
        HashSet<Integer>hs= new HashSet<>();
        list2 = list.stream().filter(n-> !hs.add(n)).collect(Collectors.toList());
        System.out.println(list2);

        //5.find first list.get(0);
        int first = list.stream().findFirst().get();
        System.out.println(first);

        //6. find length
        long length = list.stream().count();
        System.out.println(length);

        //7. max and min
        int max = list.stream().max(Integer::compare).get();
        System.out.println(max);

        int min = list.stream().min(Integer:: compare).get();
        System.out.println(min);



    }
}
