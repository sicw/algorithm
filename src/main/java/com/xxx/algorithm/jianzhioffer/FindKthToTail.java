package com.xxx.algorithm.jianzhioffer;

import org.junit.Test;

/**
 * @author sicwen
 * @date 2019/03/08
 */
public class FindKthToTail {
    @Test
    public void testCase(){
        ListNode e = new ListNode(5);
        ListNode d = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode a = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println(Solution(a,0).val);
    }

    public ListNode Solution(ListNode head,int k){
        if(k < 1){
            return null;
        }
        int j = k - 1;
        ListNode tempNode = head;
        while(tempNode != null && j > 0){
            tempNode = tempNode.next;
            j--;
        }
        if(tempNode == null){
            return null;
        }
        ListNode result = head;
        while(tempNode.next != null){
            result = result.next;
            tempNode = tempNode.next;
        }
        return result;
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
