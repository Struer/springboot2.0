package com.lambda;

import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class FunctionDemo {

    public static void main(String[] args) {
        //���Ժ���
        Predicate<Integer> predicate = integer -> integer > 5;
        //���������JDK�Դ������ͣ���ô�ж�Ӧ�Ľӿڣ�����ʡ�Է���
        //IntPredicate predicate = integer -> integer > 5;
        System.out.println(predicate.test(5));

        //���Ѻ����ӿ� IntConsumer
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("���Ѻ����ӿ�");
    }
}
