package com.lambda;

import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class FunctionDemo {

    public static void main(String[] args) {
        //断言函数
        Predicate<Integer> predicate = integer -> integer > 5;
        //如果泛型是JDK自带的类型，那么有对应的接口，可以省略泛型
        //IntPredicate predicate = integer -> integer > 5;
        System.out.println(predicate.test(5));

        //消费函数接口 IntConsumer
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("消费函数接口");
    }
}
