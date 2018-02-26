package com.zzq.demo.charpter9;

import java.util.Arrays;

/**
 * 冒泡排序示例
 * Created by yhsyzzq on 2018-02-26.
 */
public class BubbleSort {

    private static int[] array = {9, 1, 5, 8, 3, 7, 4, 6, 2};
//    private static int[] array = {2, 1, 3, 4, 5, 6, 8, 7, 9};

    /**
     * 非标准的冒泡排序
     *
     * @param array
     */
    public static void bubbleSort0(int[] array) {
        int positionChangeCount = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    positionChangeCount++;
                }
            }
        }
        System.out.print("bubbleSort0排序结果："+ Arrays.toString(array));
        System.out.println("\r\nbubbleSort0位置变动次数：" + positionChangeCount);
    }

    /**
     * 标准冒泡排序
     *
     * @param array
     */
    public static void bubbleSort1(int[] array) {
        int positionChangeCount = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    positionChangeCount++;
                }
            }
        }

        System.out.print("bubbleSort1排序结果："+ Arrays.toString(array));
        System.out.println("\r\nbubbleSort1位置变动次数：" + positionChangeCount);
    }

    /**
     * 标准冒泡排序的改进，如果内部循环没有发生位置变动，说明已经完成排序，则结束掉外循环
     *
     * @param array
     */
    public static void bubbleSort2(int[] array) {
        int positionChangeCount = 0;
        boolean flag = true;
        for (int i = 0; i < array.length && flag; i++) {
            flag = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    positionChangeCount++;
                    flag = true;
                }
            }
        }

        System.out.print("bubbleSort2排序结果："+ Arrays.toString(array));
        System.out.println("\r\nbubbleSort2位置变动次数：" + positionChangeCount);
    }

    public static void main(String[] args) {
//        BubbleSort.bubbleSort0(array);
//        BubbleSort.bubbleSort1(array);
        BubbleSort.bubbleSort2(array);
    }

}
