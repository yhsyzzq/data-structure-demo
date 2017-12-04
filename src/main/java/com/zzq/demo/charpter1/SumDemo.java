package com.zzq.demo.charpter1;

import java.util.LinkedList;

/**
 * 计算1到100的累加值
 * Created by yhsyzzq on 2017-11-13.
 */
public class SumDemo {

    public static void main(String[] args) {
//        int sum = 0;
//        for (int i = 1; i <= 100; i++) {
//            sum += i;
//        }
//        System.out.println("1到100的累加求和值为：" + sum);

//        int i = 0;
//        int a = ++i;
//
//        int j = 0;
//        int b = j++;
//        System.out.println("i=" + i + ", a=" + a + ", j=" + j + ", b=" + b);

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println(linkedList);

    }
}
