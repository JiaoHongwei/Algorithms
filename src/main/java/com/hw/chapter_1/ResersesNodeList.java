package com.hw.chapter_1;

import java.util.Stack;

/**
 * @Description 反转链表
 * @Author hw
 * @Date 2019/3/11 14:47
 * @Version 1.0
 */
class NodeList {
    String value;
    NodeList next;

    NodeList(String value, NodeList pop) {
        this.value = value;
        this.next = pop;
    }

    @Override
    public String toString() {
        return "NodeList{" +
                "value='" + value + '\'' +
                ", next=" + next +
                '}';
    }
}

public class ResersesNodeList {
    public static void main(String[] args) {
        NodeList head = new NodeList("a", new NodeList("b", new NodeList("c", new NodeList("d", null))));
        print(head);
//        head = reserseNodeList(head);

//        head = reserseNodeListFor(head);
        head = reserseNodeListNotFor(head);
        print(head);
    }

    private static NodeList reserseNodeListNotFor(NodeList head) {
//        a>b>c>d>
//        d>c>b>a>
        NodeList prev = null;
        NodeList now = head;
        while (now != null) {
            NodeList next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }
        return prev;
    }

    private static NodeList reserseNodeListFor(NodeList head) {
        if (head == null || head.next == null) {
            return head;
        }
        NodeList next = head.next;
        head.next = null;
        NodeList newHead = reserseNodeListFor(next);
        next.next = head;
        return newHead;
    }

    private static void print(NodeList head) {
        while (head != null) {
            System.out.print(head.value + ">");
            head = head.next;
        }
        System.out.println();
    }

    private static void reserseNodeList(NodeList head) {
        Stack<NodeList> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }


}
