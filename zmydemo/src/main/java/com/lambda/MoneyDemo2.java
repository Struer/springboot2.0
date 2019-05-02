package com.lambda;

import java.text.DecimalFormat;
import java.util.function.Function;
// 不定义接口的方式：
// lambda表达式不关心实现的是哪个接口，不需要知道接口的名字和方法，只需要知道输入和输出是什么。
// 因此完全不需要定义一个接口，只需要知道是int，输出是String的函数（Function）就行了。
// 使用函数接口的好处：1、不需要定义接口 2、支持链式调用
public class MoneyDemo2 {

    public static void main(String[] args) {
        MyMoney2 myMoney = new MyMoney2(9999999);
        Function<Integer, String> moneyFormat = i -> new DecimalFormat("#,###").format(i);
        myMoney.printMoney(moneyFormat);
        // 函数接口通过Function.andThen链式调用
        myMoney.printMoney(moneyFormat.andThen( s -> "人民币" + s));
    }
}
class MyMoney2 {

    private final int money;

    MyMoney2(int money) {
        this.money = money;
    }

    public void printMoney(Function<Integer, String> function) {
        System.out.println(String.format("金额为：" + function.apply(this.money)));
    }
}
//金额为：9,999,999