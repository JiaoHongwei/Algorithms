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

    /**
     *  递归调用
     * @param head
     * @return
     */
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

    /**
     * 非递归调用
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = p.next;
        ListNode r = q.next;
        q.next = p;
        p.next = null;
        while (r != null) {
            p = q;
            q = r;
            r = r.next;
            q.next = p;
        }
        return q;
    }

    @Test
    public void testReverseList() {

    }

}
