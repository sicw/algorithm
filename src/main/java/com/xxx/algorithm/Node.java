package com.xxx.algorithm;

/**
 * @author sicwen
 * @date 2019/03/14
 */
public class Node {
    public Node left;
    public Node right;
    public Integer data;
    public Node(Integer data,Node left,Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    @Override
    public String toString() {
        return data.toString();
    }

    public static Node createTree(){
        Node e = new Node(7,null,null);
        Node f = new Node(8,e,null);
        Node a = new Node(4,null,null);
        Node d = new Node(2,a,f);
        Node h = new Node(6,null,null);
        Node z = new Node(16,null,null);
        Node m = new Node(1,h,z);
        Node root = new Node(3,d,m);
        return root;
    }
}
