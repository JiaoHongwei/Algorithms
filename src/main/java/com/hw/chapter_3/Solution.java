//package com.hw.chapter_3;
//
///**
// * @Description TODO
// * @Author hw
// * @Date 2019/5/5 18:09
// * @Version 1.0
// */
//public class Solution {
//
//
//    class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }
//
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//        l1 = reserve_Node(l1);
//        l2 = reserve_Node(l2);
//        ListNode ln = new ListNode(0);
//        int add = 0;
//        while ((l1 != null && l1.next != null) || (l2 != null && l2.next != null)) {
//            if (l1 == null) {
//                l1 =
//            }
//            ln.val = l1.val + l2.val + add;
//            if (ln.val > 9) {
//                ln.val = ln.val - 10;
//                add = 1;
//            }
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//
//
//    }
//
//    private ListNode reserve_Node(ListNode node) {
//        ListNode prev = null;
//        ListNode now = node;
//        while (now != null && now.next != null) {
//            ListNode next = now.next;
//            now.next = prev;
//            prev = now;
//            now = next;
//        }
//        return now;
//    }
//
//}
