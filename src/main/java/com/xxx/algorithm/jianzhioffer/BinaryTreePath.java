package com.xxx.algorithm.jianzhioffer;

import com.xxx.algorithm.Node;
import org.junit.Test;

/**
 * 打印出二叉树所有路径
 * @author sicwen
 * @date 2019/03/14
 */
public class BinaryTreePath {

    @Test
    public void testCase(){
        findPath(Node.createTree(),new Integer[4],0);
    }

    /**
     * 如果根节点为null，直接返回，不打印任何数据
     * 根节点不为null，存入数组中，路径长度++
     * 如果是叶子节点了，打印路径
     * 不是叶子节点，继续处理左右节点
     */
    public void findPath(Node root,Integer[] path,int pathLength){
        if(root == null){ return; }
        path[pathLength++] = root.data;
        if(root.left == null && root.right == null){
            printArray(path,pathLength);
        }
        findPath(root.left,path,pathLength);
        findPath(root.right,path,pathLength);
    }

    private void printArray(Integer[] ints, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }
}