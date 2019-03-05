package com.xxx.algorithm;

import org.junit.Test;

/**
 * @author sicwen
 * @date 2019/03/05
 */
public class BinarySearch {

    @Test
    public void testCase(){
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(search(arr,0,arr.length-1,9));
    }

    /**
     * 在排序数组中返回目标数的下标
     * 没找到则返回-1
     * @param arr
     * @param data
     * @return
     */
    public int search(int[] arr,int data){
        int l = 0;
        int r = arr.length-1;
        while(l <= r){
            int mid = (l+r)>>1;
            if(data > arr[mid]){
                l = mid + 1;
            }else if(data < arr[mid]){
                r = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归算法
     */
    public int search(int[] arr,int l,int r,int data){
        if(l <= r) {
            int mid = (l + r) >> 1;
            if (data > arr[mid]){
                return search(arr,mid+1,r,data);
            }else if (data < arr[mid]){
                return search(arr,l,mid-1,data);
            }else{
                return mid;
            }
        }
        return -1;
    }
}
