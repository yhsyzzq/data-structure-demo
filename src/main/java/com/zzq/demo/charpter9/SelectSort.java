package com.zzq.demo.charpter9;

import java.util.Arrays;

/**
 * 选择排序法示例
 * Created by yhsyzzq on 2018-02-26.
 */
public class SelectSort {

    private static int[] array = {9, 1, 5, 8, 3, 7, 4, 6, 2};

    public static void selectSort(int[] array) {
        int positionChangeCount = 0;
        int min;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
                positionChangeCount++;
            }
        }

        System.out.print("selectSort排序结果：" + Arrays.toString(array));
        System.out.println("\r\nselectSort位置变动次数：" + positionChangeCount);
    }

    public static void main(String[] args) {
        SelectSort.selectSort(array);
    }
}
