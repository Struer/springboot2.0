package com.lambda;

import java.util.ArrayList;
import java.util.List;

public class TestReference {

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        //list = null;
        //System.out.println(list);  //输出null

        changeList(list);
        System.out.println(list);  // 输出空数组：[]
    }

    public static void changeList(List list) {
        list = null;
    }
}
