package com.zz.leetCode;

import java.util.List;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}

public class SwapNodesInParis {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1); //建立辅助节点
        ListNode pre = dummy;
        ListNode curr = head;
        dummy.next = head;

        // curr = 1 , pre = 0 , (0,1,2,3)表示位置
        while (curr != null && curr.next != null){
            pre.next = curr.next;  // 0 ----> 2
            curr.next = pre.next.next; // 1 ---> 3
            pre.next.next = curr; // 2 ---> 1

            //位置后移
            pre = curr;
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        ListNode node = new SwapNodesInParis().swapPairs(head1);

        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
