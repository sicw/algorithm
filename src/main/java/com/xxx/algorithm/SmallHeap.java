package com.xxx.algorithm;

import org.junit.Test;

public class SmallHeap {

    /**
     * 链表存储节点元素需要维护额外的指针，所以使用数组存储该数据。
     * 最小堆是完全二叉树(只允许最后一层节点不满，但是左孩子必须有节点)，满足以下关系：
     * i节点的父节点为      (i-1)/2
     * i节点的左孩子为      i*2+1
     * i节点的右孩子为      i*2+2
     */
    private int[] nodes = new int[100];

    /**
     * 最后元素的位置
     */
    private int lastPos = -1;

    /**
     * 向堆中插入数据，插入到最后一个位置
     * 判断是否满足最小堆的要求 即:根节小于根节点
     * 若不满足则与根节点交换，直到下标为0(最小堆得根)
     * @param node
     */
    public void insert(int node){
        nodes[++lastPos] = node;
        int i = lastPos;
        while(i > 0 && nodes[i] < nodes[p(i)]){
            swap(i,p(i));
            i = p(i);
        }
    }

    /**
     * 将最后一个元素放到根元素上
     * 从根元素开始判断是否满足根元素大于左右孩子元素
     * 若不满足则与最小的那个交换
     * 返回最小值
     * @return
     */
    public int get(){
        int i = 0;
        int result = nodes[0];
        nodes[i] = nodes[lastPos--];
        while(r(i) <= lastPos){
            int min = nodes[l(i)] < nodes[r(i)]?l(i):r(i);
            if(nodes[i] > nodes[min]){
                swap(i,min);
                i = min;
            }else {
                break;
            }
        }
        if(l(i) == lastPos){
            if(nodes[l(i)] < nodes[i]){
                swap(l(i),i);
            }
        }
        return result;
    }

    private void swap(int index1,int index2){
        int temp = nodes[index1];
        nodes[index1] = nodes[index2];
        nodes[index2] = temp;
    }

    /**
     * i的父节点下标
     * @return
     */
    private int p(int i){
        return (i-1) >> 1;
    }

    /**
     * 返回i的左孩子下标
     * @param i
     * @return
     */
    private int l(int i){
        return i*2+1;
    }

    /**
     * 返回i的右孩子下标
     * @param i
     * @return
     */
    private int r(int i){
        return i*2+2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(50);
        for (int i = 0; i <= lastPos; i++) {
            sb.append(get()+" ");
        }
        return sb.toString();
    }

    @Test
    public void testCase(){
        SmallHeap sh = new SmallHeap();
        sh.insert(1);
        sh.insert(4);

        System.out.println(sh);
    }
}