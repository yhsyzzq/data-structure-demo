package com.zzq.demo.charpter7;

/**
 * Created by yhsyzzq on 2017-12-21.
 */
public class FibonacciUtils {

    /**
     * 计算0-50下标位上的fibonacci数列的值
     */
    public static long F(int n) {
        if (n < 0) {
            System.out.println("n值不能小于0");
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n >= 2) {
            return F(n - 1) + F(n - 2);
        } else if (n > 40) {
            System.out.println("n值不能大于40");
            return -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 40; i++) {
            System.out.println("F(" + i + ")=" + FibonacciUtils.F(i));
        }

    }
}
