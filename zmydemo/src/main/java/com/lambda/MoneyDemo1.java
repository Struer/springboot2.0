package com.lambda;

import java.text.DecimalFormat;

// ʹ�ýӿڵķ�ʽ
public class MoneyDemo1 {
    public static void main(String[] args) {
        MyMoney1 myMoney1 = new MyMoney1(9999999);
        IMoneyFormat moneyFormat = i -> new DecimalFormat("#,###").format(i);
        myMoney1.printMoney(moneyFormat);
    }
}
class MyMoney1 {

    private final int money;

    MyMoney1(int money) {
        this.money = money;
    }

    public void printMoney(IMoneyFormat moneyFormat){
        System.out.println(String.format("���Ϊ��" + moneyFormat.format(this.money)));
    }
}
@FunctionalInterface
interface IMoneyFormat{
    String format(int money);
}
//���Ϊ��9,999,999