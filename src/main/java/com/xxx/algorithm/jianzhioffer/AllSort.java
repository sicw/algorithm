package com.xxx.algorithm.jianzhioffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sicwen
 * @date 2019/03/21
 */
public class AllSort {

    private ArrayList<String> list = new ArrayList<String>(6);

    private char[] arr = new char[4];

    @Test
    public void testCase(){
        allSort("1234",arr,0);
        System.out.println(list);
    }


    //注意length+1和++length作为参数的区别
    //在进行递归调用时，要注意回溯时，变量的是不是原来的值。 这时不能使用引用，只能用基本数据类型。
    private void allSort(String str,char[] arr,int length){
        for (int i = 0; i < str.length(); i++) {
            arr[length] = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            allSort(newStr,arr,length+1);
            if(length == arr.length-1){
                list.add(new String(arr));
            }
        }
    }
}