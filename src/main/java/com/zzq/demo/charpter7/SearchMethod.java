package com.zzq.demo.charpter7;

import java.util.Random;

/**
 * Created by yhsyzzq on 2017-12-19.
 */
public class SearchMethod {

    private final static int SIZE = 100000000;

    //    private static int[] data = {1, 2, 4, 3, 6, 8, 7, 5, 9};
    private static int[] data = new int[SIZE];

    static {
        for (int i = 0; i < SIZE; i++) {
            data[i] = SearchMethod.produceRandomData();
        }
    }

    /**
     * 产生随机数
     */
    public static int produceRandomData() {
        return new Random().nextInt(SIZE);
    }

    /**
     * 顺序查找
     *
     * @param data
     * @param key
     * @return
     */
    public static int search1(int[] data, int key) {
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == key) {
                endTime = System.currentTimeMillis();
                System.out.println("要查找的值key=" + key + "是数组data的第" + (i + 1) + "个元素,查找耗时：" + (endTime - startTime) + "ms");
                return i;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("要查找的值key=" + key + "在数组data中未找到,查找耗时：" + (endTime - startTime) + "ms");
        return -1;
    }

    /**
     * 顺序查找，加哨兵
     * @param data
     * @param key
     * @return
     */
    public static int search2(int[] data, int key) {
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        int temp = data[0];
        if (temp != key) {
            data[0] = key;
        } else {
            endTime = System.currentTimeMillis();
            System.out.println("要查找的值key=" + key + "是数组data的第1个元素,查找耗时：" + (endTime - startTime) + "ms");
            return 0;
        }
        int i = data.length - 1;
        while (data[i] != key) {
            i--;
        }
        data[0] = temp;
        if (i != 0) {
            endTime = System.currentTimeMillis();
            System.out.println("要查找的值key=" + key + "是数组data的第" + (i + 1) + "个元素,查找耗时：" + (endTime - startTime) + "ms");
        } else {
            i = -1;
            endTime = System.currentTimeMillis();
            System.out.println("要查找的值key=" + key + "在数组data中未找到,查找耗时：" + (endTime - startTime) + "ms");
        }

        return i;
    }

    public static void main(String[] args) {
        int key = SearchMethod.produceRandomData();
        SearchMethod.search1(data, key);
        SearchMethod.search2(data, key);
    }
}
