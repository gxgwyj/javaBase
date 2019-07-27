package com.xyz.java.base.sort;

import org.junit.Test;

/**
 * @author Administrator
 * @data 2019/7/27
 * @description 排序算法
 */
public class SortTest {


    private static int[] arr = {11,233,333,3333,444,2,12121,22,11,32323,1,12121,6555,666};


    /**
     * 自创排序法
     */
    @Test
    public void mySort() {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                count++;
                if (arr[j] > arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }

        System.out.printf("总共%d个数字，执行了%d次\n",arr.length,count);
        printOut(arr);
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
    }

    /**
     * 冒泡法排序，原理：每相邻的两个元素进行比较，找出最大的，向右移动
     * 本质上是按最大的向右移动，先找出第一大的，再找出第二大的，依次比较出结果
     */
    @Test
    public void bubbleSort() {

        /**
         * 比较n-1轮
         */
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("冒泡法排序");
        printOut(arr);

    }


    /**
     * 选择发排序
     */
    @Test
    public void switchSort() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
        System.out.println("选择法排序");
        printOut(arr);

    }

    @Test
    public void testQucikSort() {
        System.out.println("快速排序法");
        int narr[] = quickSort(arr, 0, arr.length - 1);
        printOut(arr);

    }


    /**
     * 快速排序法
     * 百度百科
     * https://blog.csdn.net/asdfsadfasdfsa/article/details/83009869
     */
    public int[] quickSort(int arr[],int start,int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            // 找出右面比基数小的数字
            while ((i < j) && (arr[j] > pivot)) {
                j--;
            }
            // 再找出左面比基数大的数字
            while ((i < j) && (arr[i] < pivot)) {
                i++;
            }
            if ((arr[i] == arr[j]) && (i < j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start) {
            arr = quickSort(arr, start, i - 1);
        }
        if (j + 1 < end) {
            arr = quickSort(arr, j+1, end);
        }
        return arr;

    }

    public void printOut(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(",");
        }
        sb.setLength(sb.length()-1);
        System.out.println("排序后的数据：" + sb.toString());
    }

}
