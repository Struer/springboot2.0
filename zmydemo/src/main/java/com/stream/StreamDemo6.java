package com.stream;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class StreamDemo6 {

    public static void main(String[] args) {
        // 并行流使用的线程池: ForkJoinPool.commonPool
        // 默认的线程数是 当前机器的cpu个数
        // 使用这个属性可以修改默认的线程数
        // System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism",
        // "20");
        IntStream.range(1, 100).parallel().peek(StreamDemo6::debug).count();
    }


    public static void debug(int i) {
        System.out.println(Thread.currentThread().getName() + " debug " + i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
