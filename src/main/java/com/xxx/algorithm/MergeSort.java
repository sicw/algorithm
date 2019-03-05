package com.xxx.algorithm;

import org.junit.Test;

/**
 * @author sicwen
 * @date 2019/03/05
 */
public class MergeSort {

    @Test
    public void testCase(){
        int[] arr = {123,4,54,1,75,56};
        mergeSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    public void mergeSort(int[] arr,int l,int r){
        if(l < r){
            int mid = (l + r) >> 1;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,mid+1,r);
        }
    }

    public void merge(int[] arr,int l1,int r1,int l2,int r2){
        int temp[] = new int[r2-l1+1];
        int destPos = l1;
        int k = 0;
        while(l1 <= r1 && l2 <= r2){
            if(arr[l1] < arr[l2]){
                temp[k++] = arr[l1++];
            }else{
                temp[k++] = arr[l2++];
            }
        }
        while(l1 <= r1){
            temp[k++] = arr[l1++];
        }
        while(l2 <= r2){
            temp[k++] = arr[l2++];
        }
        System.arraycopy(temp,0,arr,destPos,temp.length);
    }
}