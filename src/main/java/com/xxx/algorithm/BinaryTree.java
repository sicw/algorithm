package com.xxx.algorithm;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BinaryTree {

    public Node createTree(){
        Node e = new Node("E",null,null);
        Node f = new Node("F",e,null);
        Node a = new Node("A",null,null);
        Node d = new Node("D",a,f);
        Node h = new Node("H",null,null);
        Node z = new Node("Z",null,null);
        Node m = new Node("M",h,z);
        Node root = new Node("G",d,m);
        return root;
    }

    @Test
    public void testCase(){
        Node root = createTree();
        front(root);
        System.out.println();
        front2(root);
        System.out.println();

        middle(root);
        System.out.println();
        middle2(root);
        System.out.println();

        end(root);
        System.out.println();
        end2(root);
        System.out.println();
        layList(root);
    }

    /**
     * 递归遍历
     * @param root
     */
    public void front(Node root){
        if (root != null) {
            System.out.print(root);
            front(root.left);
            front(root.right);
        }
    }

    public void middle(Node root){
        if (root != null) {
            middle(root.left);
            System.out.print(root);
            middle(root.right);
        }
    }

    public void end(Node root){
        if (root != null) {
            end(root.left);
            end(root.right);
            System.out.print(root);
        }
    }

    /**
     * 非递归遍历
     */
    public void front2(Node root){
        Stack<Node> stack = new Stack<Node>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                System.out.print(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                Node node = stack.pop();
                root = node.right;
            }
        }
    }

    /**
     * 非递归遍历
     */
    public void middle2(Node root){
        Stack<Node> stack = new Stack<Node>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                Node node = stack.pop();
                System.out.print(node);
                root = node.right;
            }
        }
    }

    public void end2(Node root){
        Stack<Node> stack = new Stack<Node>();
        Node mark = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                //没有右孩子 或者 右边的孩子已经处理完了。根据左右根顺序，直接打印根节点。
                if(stack.peek().right == null || stack.peek().right == mark){
                    mark = stack.pop();
                    System.out.print(mark);
                } else{
                   root = stack.peek().right;
                }
            }
        }
    }

    /**
     * 层序遍历
     * @param root
     */
    public void layList(Node root){
        Deque<Node> queue = new ArrayDeque<Node>(16);
        if (root != null) {
            queue.add(root);
            while(!queue.isEmpty()){
                Node node = queue.pop();
                System.out.print(node);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    private class Node{
        private Node left;
        private Node right;
        private String data;
        public Node(String data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
        @Override
        public String toString() {
            return data;
        }
    }
}