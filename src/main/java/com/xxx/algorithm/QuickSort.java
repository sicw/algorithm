package com.xxx.algorithm;

import org.junit.Test;

/**
 * @author sicwen
 * @date 2019/03/01
 */
public class QuickSort {

    @Test
    public void testCase(){
        int[] ins = {2,3,5,1,23,6,78,34};
        int[] ins2 = QuickSort.s(ins,0,ins.length-1);
        for(int in: ins2) {
            System.out.print(in+" ");
        }
    }

    //将基准数据拿出来，就留了一个坑。
    //从右向左找，比基准数据小的放到坑中。
    //从左向右找，比基准数据大的放到坑中。
    //i,j中肯定有一个指向坑，然后另一个移动。
    //当i=j中时 说明i和j指向的就是坑。
    //将基准数据放到坑中。
    //然后递归的执行 基准数据左侧的序列和右侧的序列。
    public static int[] s(int[] ins ,int start,int end){
        if(start>=end){
            return ins;
        }
        int mid = ins[start];
        int low = start;
        int hight = end;
        while(low < hight){
            while(low < hight && ins[hight]>=mid){
                hight -=1;
            }
            ins[low] = ins[hight];

            while(low < hight && ins[low] < mid){
                low +=1;
            }
            ins[hight] = ins[low];
        }
        ins[low] = mid;
        s(ins, start, low-1);
        s(ins, low+1, end);
        return ins;
    }
}