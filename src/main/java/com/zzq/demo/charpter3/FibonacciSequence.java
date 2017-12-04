package com.zzq.demo.charpter3;

/**
 * 斐波那契数列
 * Created by yhsyzzq on 2017-12-04.
 */
public class FibonacciSequence {
    static int[] a = new int[40];

    public static int getFibSeqence(int i) {
        if (i <= 2) {
            return i == 0 ? 0 : 1;
        } else {
            return getFibSeqence(i - 1) + getFibSeqence(i - 2);
        }
    }

    public static void main(String[] args) {
        /*int[] a = new int[40];
        a[0] = 0;
        System.out.print(a[0]+", ");
        a[1] = 1;
        System.out.print(a[1]+", ");
        for(int i=2;i<40;i++){
            a[i] = a[i-1]+a[i-2];
            System.out.print(a[i]+", ");
        }*/

        //递归调用
        for (int i = 0; i < 40; i++) {
            System.out.println(getFibSeqence(i));
        }

    }

}
