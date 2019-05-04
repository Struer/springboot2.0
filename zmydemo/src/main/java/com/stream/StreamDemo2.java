package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        Stream<Object> stream = list.stream();
        Stream<Object> objectStream = list.parallelStream();

        Arrays.stream(new int[]{1,2});

        IntStream intStream = IntStream.of(2, 3, 4, 4);
        IntStream intStream1 = IntStream.rangeClosed(2, 3);


    }
}
