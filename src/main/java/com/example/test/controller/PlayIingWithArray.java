package com.example.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;


@RestController()
@RequestMapping(value = "/stream")
public class PlayIingWithArray {

    @GetMapping(value ="/arrays/sumOfAllNumbers")
    public String sumOfAllNumbers(@RequestParam(value ="list",required = true) String list){
//        List<Integer> list1 = Arrays.stream(list.split(","))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//        Optional<Integer> sum = list1.stream().reduce((a, b)->a+b);
//        return String.valueOf(sum.get());
        Integer sum = Arrays.stream(list.split(","))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        return  sum.toString();
    }

}
