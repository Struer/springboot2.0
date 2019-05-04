package com.lambda;

import java.util.function.Function;

public class CurryDemo {

    public static void main(String[] args) {
        Function<Integer,Function<Integer,Integer>> function = x ->y -> x + y ;
        System.out.println(function.apply(2));
        System.out.println(function.apply(2).apply(3));
    }

}
