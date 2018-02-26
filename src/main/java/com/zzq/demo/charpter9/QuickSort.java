package com.zzq.demo.charpter9;

import java.util.Arrays;

/**
 * Created by 332406 on 2018-02-26.
 */
public class QuickSort {

//    private static int[] array = {50, 10, 90, 30, 70, 40, 80, 60, 20};

    private static int[] array = {9, 1, 5, 8, 3, 7, 4, 6, 2};

    /**
     * 快速排序
     *
     * @param array
     */
    private static void quickSort(int[] array) {
        quickSort0(array, 0, array.length - 1);
        System.out.print("quickSort排序结果：" + Arrays.toString(array));
    }

    private static void quickSort0(int[] array, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = partition(array, low, high);
            quickSort0(array, low, pivot - 1);
            quickSort0(array, pivot + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivotValue = initPivot(array, low, high); //用子序列的第一个元素作为枢轴基准元素
        while (low < high) {
            while (low < high && array[high] >= pivotValue) {
                high--;
            }
            //将比基准元素小的值换到低端
            if (low < high) {
                array[low] = array[high];
//                array[high] = pivotValue;
            }

            while (low < high && array[low] < pivotValue) {
                low++;
            }
            //将比基准元素大的值换到高端
            if (low < high) {
                array[high] = array[low];
//                array[low] = pivotValue;
            }
        }
        array[low] = pivotValue;
        return low;
    }

    private static int initPivot(int[] array, int low, int high) {
        if (high - low > 3) {   //三数取中法确定基准元素
            int middle = low + (high - low) / 2;
            if (array[high] < array[low]) {
                swap(array, low, high);
            }
            if (array[high] < array[middle]) {
                swap(array, middle, high);
            }
            if (array[low] < array[middle]) {
                swap(array, low, middle);
            }
        }
        return array[low];
    }

    private static void swap(int[] array, int i, int j) {
        if (j >= array.length || j < 0 || i >= array.length || i < 0) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort.quickSort(array);
    }
}
