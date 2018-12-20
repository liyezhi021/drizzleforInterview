package com.example.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestParallelStream {

    public static void main(String[] args){

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        numbers.parallelStream().forEach(System.out::println);
        //numbers.stream().forEach(System.out::println);

    }

    public static String query(String q, List<String> engines) {
        Optional<String> result = engines.stream().parallel().map((base) -> {
        String url = base + q;
        //return WS.url(url).get();
            return "";
    }).findAny();
        return result.get();
    }

}
