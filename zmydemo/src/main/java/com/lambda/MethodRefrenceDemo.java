package com.lambda;


import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodRefrenceDemo {

    public static void main(String[] args) {
        Consumer<String> consumer = str -> System.out.println(str);
        //��������
        //lanmbdaʵ������һ����������������Ǻ����Ĳ������Ҳ��Ǻ�����ִ����
        //��������ִ��������ֻ��һ���������ã����Һ����Ĳ��������һ��
        //��ô������д�ɷ������õķ�ʽ
        // str -> System.out.println(str)  >>>  System.out::println
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("���Է�������");

        //===�������õ���ʽ===
        //1.��̬����������  ����::������
        Consumer<Dog> dogConsumer = Dog::bark;
        dogConsumer.accept(new Dog());

        //2.�Ǿ�̬������ʹ�ö���ʵ���ķ�������
        Dog dog = new Dog();
        //ʹ��Function�����ӿ�
        Function<Integer, Integer> function = dog::eat;
        dog = null;
        System.out.println(function.apply(2));
        //ʹ��UnaryOperatorһԪ�����ӿڣ�
        UnaryOperator<Integer> unaryOperator = dog::eat;
        System.out.println(unaryOperator.apply(2));
        IntUnaryOperator intUnaryOperator = dog::eat;
        System.out.println(intUnaryOperator.applyAsInt(2));

        //3.�Ǿ�̬������ʹ����������������
        //JDKĬ�ϰѵ�ǰʵ�����뵽�Ǿ�̬������������Ϊthis��λ���ǵ�һ��
        BiFunction<Dog, Integer, Integer> biFunction = Dog::eat;
        System.out.println(biFunction.apply(dog, 3));

        //4.���캯���ķ������ã��뾲̬����ʹ��һ������������������ɣ��޲ι��캯��ֻ�����û������
        Supplier<Dog> supplier = Dog::new;
        System.out.println(supplier.get()); //���ض���ʵ��
        //�вι��죺12Ϊ���������3Ϊ�������
        BiFunction<String, Integer, Dog> dogFunction = Dog::new;
        System.out.println(dogFunction.apply("����Ȯ", 9));
    }
}

class Dog {
    private String name = "����";
    private int food = 10; //Ĭ��10�ﹷ��

    public Dog() {
    }

    public Dog(String name, int food) {
        this.name = name;
        this.food = food;
    }

    // ���У���̬����
    public static void bark(Dog dog) {
        System.out.println(dog + "����");
    }

    // �Թ������Ǿ�̬����
    //JDKĬ�ϰѵ�ǰʵ�����뵽�Ǿ�̬������������Ϊthis��λ���ǵ�һ��
    // public int eat(Dog this ,int num){
    public int eat(int num) {
        System.out.println("����" + num + "�ﹷ��");
        return this.food -= num;
    }

    @Override
    public String toString() {
        return "name:" + this.name + ", food:" + food;
    }
}
