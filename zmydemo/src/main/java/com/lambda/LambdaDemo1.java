package com.lambda;

public class LambdaDemo1 {

    public static void main(String[] args) {
        //����ӿڵ����
        Interface1 interface1 = (int a,int b) -> a + b;
        int sum = interface1.sum(1, 2);
        System.out.println(sum);

        //������ӿ�

    }

}

@FunctionalInterface
interface Interface1{
    int sum(int a,int b);
}
