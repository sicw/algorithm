package com.xxx.algorithm.jianzhioffer;

import com.xxx.algorithm.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sicwen
 * @date 2019/03/14
 */
public class BintrySomePathSum {

    private ArrayList<ArrayList<Integer>> allList = new ArrayList<ArrayList<Integer>>();

    private ArrayList<Integer> list = new ArrayList<Integer>();

    @Test
    public void testCase(){
        //findPath(Node.createTree(),new Integer[4],0,20);
        //findPathPlus1(Node.createTree(),new Integer[4],0,20);
        findPathPlus2(Node.createTree(),20);
        for (ArrayList<Integer> list : allList) {
            System.out.println(list);
        }
    }

    public void findPath(Node root,Integer[] path,int pathLength,int target){
        if(root == null) {
            return;
        }
        //或者用list来代替
        //不用加法用减法来判断
        path[pathLength++] = root.data;
        if(root.left == null && root.right == null){
            if(sum(path,pathLength) == target){
                Integer[] tmp = Arrays.copyOfRange(path,0,pathLength);
                List<Integer> list = Arrays.asList(tmp);
                allList.add(new ArrayList<Integer>(list));
                //printArray(path,pathLength);
            }
        }
        findPath(root.left,path,pathLength,target);
        findPath(root.right,path,pathLength,target);
    }

    public void findPathPlus1(Node root,Integer[] path,int pathLength,int target){
        if(root == null) {
            return;
        }
        //不用加法用减法来判断
        path[pathLength++] = root.data;
        target -= root.data;
        if(root.left == null && root.right == null){
            if(0 == target){
                Integer[] tmp = Arrays.copyOfRange(path,0,pathLength);
                List<Integer> list = Arrays.asList(tmp);
                allList.add(new ArrayList<Integer>(list));
                //printArray(path,pathLength);
            }
        }
        findPathPlus1(root.left,path,pathLength,target);
        findPathPlus1(root.right,path,pathLength,target);
    }

    public void findPathPlus2(Node root,int target){
        if (root == null) {
            return;
        }
        list.add(root.data);
        target -= root.data;
        if(root.left == null && root.right == null && target == 0){
            allList.add(new ArrayList<Integer>(list));
        }
        findPathPlus2(root.left,target);
        findPathPlus2(root.right,target);
        //在回退上一级时，从栈中pop数据
        //在数组中，用的是int参数传递的 他是存储在栈中，所以不需要回退，他会自动回退的
        list.remove(list.size()-1);
    }

    private void printArray(Integer[] arr,int length){
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private int sum(Integer[] arr,int length){
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}