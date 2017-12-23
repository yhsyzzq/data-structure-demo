package com.zzq.demo.charpter7;

/**
 * Created by yhsyzzq on 2017-12-20.
 */
public class BinarySearchMethod {
    private static int[] data = {1, 2, 3, 4, 6, 8, 9, 13, 17, 22, 24, 26, 27, 31, 35};

    /**
     * 二分法查找
     *
     * @param data
     * @param key
     * @return
     */
    public static int binarySearch(int[] data, int key) {
        int low = 0, high = data.length - 1;  //定义最低下标为数组首位，最高下标为数组末位
        int mid = 0;
        while (low <= high) {
            mid = (high + low) / 2; //折半
            if (key < data[mid]) {       //查找值比中值小，则最高下标移到中值前一位
                high = mid - 1;
            } else if (key > data[mid]) {  //查找值比中值大，则最低下标移到中值后一位
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 插值查找法
     *
     * @param data
     * @param key
     * @return
     */
    public static int insertValueSearch(int[] data, int key) {
        int low = 0, high = data.length - 1;  //定义最低下标为数组首位，最高下标为数组末位
        int mid = 0;
        while (low <= high) {
            mid = low + (key - data[low]) * (high - low) / (data[high] - data[low]); //插值
            if (key < data[mid]) {       //查找值比中值小，则最高下标移到中值前一位
                high = mid - 1;
            } else if (key > data[mid]) {  //查找值比中值大，则最低下标移到中值后一位
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 斐波那契查找法
     * 斐波那契数列数组【0,1,1,2,3,5,8,13,21,34,55,...】
     * @param data
     * @param key
     */
//    public static int fibonacciSearch(int[] data, int key) {
//
//    }

    public static void main(String[] args) {
        System.out.println(BinarySearchMethod.binarySearch(data, 26));

        System.out.println(BinarySearchMethod.insertValueSearch(data, 26));

    }
}
