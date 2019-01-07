package com.hw.chapter_1;

import org.junit.jupiter.api.Test;

/**
 * @Description 反转链表
 * @Author hw
 * @Date 2019/1/7 14:04
 * @Version 1.0
 */
public class ReverseListNode {

    /**
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        head.next = null;
        ListNode reverse = reverseList(node);
        node.next = head;
        return reverse;
    }

    @Test
    public void testReverseList() {

    }

}
