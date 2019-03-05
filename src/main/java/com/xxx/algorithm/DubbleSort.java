package com.xxx.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author sicwen
 * @date 2019/03/05
 */
public class DubbleSort {

    @Test
    public void testCase(){
        int[] arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * n个数 需要n-1次比较
     * 每次比较相邻的两个数，如果a < b就交换两个数。
     * @param arr
     */
    public void sort(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            boolean isSorted = true;
            for (int j = 0; j < n-i; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                    isSorted = false;
                }
            }
            if (isSorted = true) {
                break;
            }
        }
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}