package com.lambda;

import java.text.DecimalFormat;
import java.util.function.Function;
// ������ӿڵķ�ʽ��
// lambda���ʽ������ʵ�ֵ����ĸ��ӿڣ�����Ҫ֪���ӿڵ����ֺͷ�����ֻ��Ҫ֪������������ʲô��
// �����ȫ����Ҫ����һ���ӿڣ�ֻ��Ҫ֪����int�������String�ĺ�����Function�������ˡ�
// ʹ�ú����ӿڵĺô���1������Ҫ����ӿ� 2��֧����ʽ����
public class MoneyDemo2 {

    public static void main(String[] args) {
        MyMoney2 myMoney = new MyMoney2(9999999);
        Function<Integer, String> moneyFormat = i -> new DecimalFormat("#,###").format(i);
        myMoney.printMoney(moneyFormat);
        // �����ӿ�ͨ��Function.andThen��ʽ����
        myMoney.printMoney(moneyFormat.andThen( s -> "�����" + s));
    }
}
class MyMoney2 {

    private final int money;

    MyMoney2(int money) {
        this.money = money;
    }

    public void printMoney(Function<Integer, String> function) {
        System.out.println(String.format("���Ϊ��" + function.apply(this.money)));
    }
}
//���Ϊ��9,999,999