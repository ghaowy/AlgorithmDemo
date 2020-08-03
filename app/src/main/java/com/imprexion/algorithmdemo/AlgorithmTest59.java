package com.imprexion.algorithmdemo;

import java.util.ArrayList;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * 将给定的单链表L： L 0→L 1→…→L n-1→L n,
 * 重新排序为： L 0→L n →L 1→L n-1→L 2→L n-2→…
 * 要求使用原地算法，并且不改变节点的值
 * 例如：
 * 对于给定的单链表{1,2,3,4}，将其重新排序为{1,4,2,3}.
 *
 *
 * 解题思路，找到链表中间节点，剪开，然后将后面部分节点 翻转， 最后 合并两个链表
 */
public class AlgorithmTest59 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.addNode(new ListNode(2));
        node.addNode(new ListNode(3));
        node.addNode(new ListNode(4));
        node.addNode(new ListNode(5));
        node.addNode(new ListNode(6));
        node.addNode(new ListNode(7));
        reorderList(node);
    }

    /**
     * 1、找出链表的长度， 查找到 中间元素
     *
     * @param head
     */
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            return;
        }

        // 查找出链表长度
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        ListNode realSlow = null;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
                realSlow = slow;
                slow = slow.next;
            } else {
                break;
            }
        }

        nodeShowHelper(slow);
        if (fast == null) {
            slow = realSlow;
        }
        // 找到链表中点节点，并且找到 所需要走的长度
        ListNode currentNode = head;
        System.out.println("val = " + slow.val);

        while (currentNode != slow) {
            // 保存 下一个节点
            ListNode next = currentNode.next;
            // 查找到 需要 处理的节点位置
            ListNode node = slow;
            ListNode preNode = null;
            while (node.next != null) {
                preNode = node;
                node = node.next;
            }

            if (preNode != null) {
                preNode.next = null;
            }
            currentNode.next = node;
            node.next = next;
            currentNode = next;
            nodeShowHelper(head);
        }
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


