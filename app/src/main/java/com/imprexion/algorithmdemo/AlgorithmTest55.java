package com.imprexion.algorithmdemo;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * 在O(n log n)的时间内使用常数级空间复杂度对链表进行排序。
 */
public class AlgorithmTest55 {
    private static ArrayDeque<Character> arrayDeque;

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.addNode(new ListNode(4));
        listNode.addNode(new ListNode(2));
        listNode.addNode(new ListNode(1));
        listNode.addNode(new ListNode(5));
        sortList(listNode);
    }


    public static ListNode sortList(ListNode head) {
        // 当链表为null 或者长度为1时不需要排序，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 找到中点 拆分链表
        ListNode tmpNode = null;
        ListNode font = null;
        ListNode after = null;
        ListNode slowNode = null;
        ListNode fastNode = null;
        // 特殊情况，长度为2 则中点即为head
        if (head.next.next == null) {
            tmpNode = head.next;
            head.next = null;
        } else {
            slowNode = head.next;
            fastNode = head.next.next;
            while (fastNode != null) {
                if (fastNode.next != null) {
                    fastNode = fastNode.next.next;
                    slowNode = slowNode.next;
                } else {
                    fastNode = null;
                }
            }
            //通过快慢指针确定了中点node即为 slowNode
            tmpNode = slowNode.next;
            slowNode.next = null;
        }
        font = sortList(head);
        after = sortList(tmpNode);
        System.out.println("------------------------------------------------");
        nodeShowHelper(font);
        nodeShowHelper(after);
        System.out.println("------------------------------------------------");
        ListNode newNodeHead = null;
        ListNode node = null;
        while (font != null || after != null) {
            if (font == null && node != null) {
                node.next = after;
                break;
            }

            if (after == null && node != null) {
                node.next = font;
                break;
            }
            ListNode newNode = null;
            System.out.println("-------------------------->");
            System.out.println("原链表 ");
            nodeShowHelper(newNodeHead);
            if (font.val < after.val) {
                newNode = new ListNode(font.val);
                font = font.next;
            } else {
                newNode = new ListNode(after.val);
                after = after.next;
            }
            if (newNodeHead == null) {
                newNodeHead = newNode;
                node = newNode;
            } else {
                node.next = newNode;
                node = node.next;
            }
            System.out.println("链表加入 " + newNode.val + "节点");
            nodeShowHelper(newNodeHead);
            System.out.println("-------------------------->");

        }

        System.out.println("-----------------------总结果-------------------------------");
        nodeShowHelper(newNodeHead);
        System.out.println("-----------------------总结果-------------------------------");
        return newNodeHead;
    }

    public static class ListNode {
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


