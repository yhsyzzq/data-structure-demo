package com.zzq.demo.charpter1;

/**
 * 计算1到100的累加值
 * Created by yhsyzzq on 2017-11-13.
 */
public class SumDemo {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1到100的累加求和值为：" + sum);
    }
}
