package com.imprexion.algorithmdemo;

import java.util.ArrayList;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
 * 拓展：
 * 你能给出不利用额外空间的解法么？
 */
public class AlgorithmTest60 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.addNode(new ListNode(2));
        node.addNode(new ListNode(3));
        ListNode listNode1 = new ListNode(4);
        node.addNode(listNode1);
        node.addNode(new ListNode(5));
        node.addNode(new ListNode(6));
        node.addNode(new ListNode(7));
        ListNode listNode = new ListNode(8);
        listNode.next = listNode1;
        node.addNode(listNode);
        detectCycle(node);
    }

    /**
     * 1、找出链表的长度， 查找到 中间元素
     *
     * @param head
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        // 找到相遇点
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }

        ListNode node = head;
        while (node != slow) {
            node = node.next;
            slow = slow.next;
        }
        System.out.println(slow.val);
        return slow;
    }

    static class ListNode {
        public ListNode(int val) {
            this.val = val;
        }

        public void addNode(ListNode node) {
            if (node == null) {
                return;
            }
            ListNode currentNode = this;
            ListNode pre = null;
            while (currentNode != null) {
                pre = currentNode;
                currentNode = currentNode.next;
            }
            pre.next = node;
        }

        int val;
        ListNode next = null;
    }

    public static void nodeShowHelper(ListNode node) {
        if (node == null) {
            System.out.println("空链表");
            return;
        }

        ListNode currentNode = node;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (currentNode != null) {
            arrayList.add(currentNode.val);
            currentNode = currentNode.next;
        }

        System.out.println(arrayList);
    }
}


