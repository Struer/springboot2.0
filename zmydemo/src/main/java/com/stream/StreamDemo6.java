package com.stream;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class StreamDemo6 {

    public static void main(String[] args) {
        // ������ʹ�õ��̳߳�: ForkJoinPool.commonPool
        // Ĭ�ϵ��߳����� ��ǰ������cpu����
        // ʹ��������Կ����޸�Ĭ�ϵ��߳���
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
