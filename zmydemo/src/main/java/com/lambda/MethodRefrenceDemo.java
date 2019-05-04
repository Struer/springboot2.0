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
        //方法引用
        //lanmbda实际上是一个匿名函数，左侧是函数的参数，右侧是函数的执行体
        //当函数的执行体里面只有一个函数调用，并且函数的参数与左侧一样
        //那么可以缩写成方法引用的方式
        // str -> System.out.println(str)  >>>  System.out::println
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("测试方法引用");

        //===方法引用的形式===
        //1.静态方法的引用  类名::方法名
        Consumer<Dog> dogConsumer = Dog::bark;
        dogConsumer.accept(new Dog());

        //2.非静态方法，使用对象实例的方法引用
        Dog dog = new Dog();
        //使用Function函数接口
        Function<Integer, Integer> function = dog::eat;
        dog = null;
        System.out.println(function.apply(2));
        //使用UnaryOperator一元函数接口，
        UnaryOperator<Integer> unaryOperator = dog::eat;
        System.out.println(unaryOperator.apply(2));
        IntUnaryOperator intUnaryOperator = dog::eat;
        System.out.println(intUnaryOperator.applyAsInt(2));

        //3.非静态方法，使用类名来方法引用
        //JDK默认把当前实例传入到非静态方法，参数名为this，位置是第一个
        BiFunction<Dog, Integer, Integer> biFunction = Dog::eat;
        System.out.println(biFunction.apply(dog, 3));

        //4.构造函数的方法引用，与静态方法使用一样，分析输入输出即可：无参构造函数只有输出没有输入
        Supplier<Dog> supplier = Dog::new;
        System.out.println(supplier.get()); //返回对象实例
        //有参构造：12为输入参数，3为输出参数
        BiFunction<String, Integer, Dog> dogFunction = Dog::new;
        System.out.println(dogFunction.apply("哮天犬", 9));
    }
}

class Dog {
    private String name = "阿黄";
    private int food = 10; //默认10斤狗粮

    public Dog() {
    }

    public Dog(String name, int food) {
        this.name = name;
        this.food = food;
    }

    // 狗叫，静态方法
    public static void bark(Dog dog) {
        System.out.println(dog + "叫了");
    }

    // 吃狗粮，非静态方法
    //JDK默认把当前实例传入到非静态方法，参数名为this，位置是第一个
    // public int eat(Dog this ,int num){
    public int eat(int num) {
        System.out.println("吃了" + num + "斤狗粮");
        return this.food -= num;
    }

    @Override
    public String toString() {
        return "name:" + this.name + ", food:" + food;
    }
}
