package com.zzq.demo.charpter9;

import java.util.Arrays;

/**
 * 插入排序法
 * Created by yhsyzzq on 2018-02-26.
 */
public class InsertSort {

    private static int[] array = {9, 1, 5, 8, 3, 7, 4, 6, 2};

    public static void insertSort(int[] array) {
        int i, j, target;
        int positionChangeCount = 0;
        for (i = 1; i < array.length; i++) {
            target = array[i];
            j = i;
            while (j > 0 && target < array[j - 1]) {
                array[j] = array[j - 1]; //记录后移
                j--;
            }
            array[j] = target; //插入正确的位置
            positionChangeCount++;
        }

        System.out.print("insertSort排序结果：" + Arrays.toString(array));
        System.out.println("\r\ninsertSort位置变动次数：" + positionChangeCount);
    }

    public static void main(String[] args) {
        InsertSort.insertSort(array);
    }
}
