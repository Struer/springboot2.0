package com.stream;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class StreamDemo5 {

    public static void main(String[] args) {
        //IntStream.range(1,100).peek(StreamDemo5::debug).count(); //һ��һ�д�ӡ
        //����parallel ����һ��������
        IntStream.range(1,100).parallel().peek(StreamDemo5::debug).count(); //һ�δ�ӡ8�У����д�ӡ��ӡ

        // ����Ҫʵ��һ��������Ч��: �Ȳ���,�ٴ���
        // ��ε��� parallel / sequential, �����һ�ε���Ϊ׼.
         IntStream.range(1, 100)
         // ����parallel����������
         .parallel().peek(StreamDemo5::debug)
         // ����sequential ����������
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
