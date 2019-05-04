package com.stream;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class StreamDemo5 {

    public static void main(String[] args) {
        //IntStream.range(1,100).peek(StreamDemo5::debug).count(); //一行一行打印
        //调用parallel 产生一个并行流
        IntStream.range(1,100).parallel().peek(StreamDemo5::debug).count(); //一次打印8行，并行打印打印

        // 现在要实现一个这样的效果: 先并行,再串行
        // 多次调用 parallel / sequential, 以最后一次调用为准.
         IntStream.range(1, 100)
         // 调用parallel产生并行流
         .parallel().peek(StreamDemo5::debug)
         // 调用sequential 产生串行流
         .sequential().peek(StreamDemo5::debug2)
         .count();
    }

    public static void debug(int i){
        System.out.println("debug " + i);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void debug2(int i) {
        System.err.println("debug2 " + i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
