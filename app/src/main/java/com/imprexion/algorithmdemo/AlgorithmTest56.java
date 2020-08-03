package com.imprexion.algorithmdemo;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * 在O(n log n)的时间内使用常数级空间复杂度对链表进行排序。
 */
public class AlgorithmTest56 {
    private static ArrayDeque<Character> arrayDeque;

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.addNode(new ListNode(4));
        listNode.addNode(new ListNode(2));
        listNode.addNode(new ListNode(1));
        listNode.addNode(new ListNode(5));
        insertionSortList(listNode);
    }


    public static ListNode insertionSortList(ListNode head) {
        // 当链表为null 或者长度为1时不需要排序，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newList = new ListNode(head.val);
        ListNode currentNode = head.next;
        while (currentNode != null) {
            newList = insertHelper(currentNode, newList);
            nodeShowHelper(newList);
            currentNode = currentNode.next;
        }

        return newList;
    }

    private static ListNode insertHelper(ListNode insertNode, ListNode newList) {
        if (newList == null || insertNode == null) {
            return newList;
        }

        ListNode currentNode = newList;
        ListNode preNde = null;
        boolean isAdd = false;
        while (currentNode != null) {
            if (currentNode.val < insertNode.val) {
                preNde = currentNode;
                currentNode = currentNode.next;
            } else {
                // 不为最后 也不为最前
                isAdd = true;
                ListNode listNode = new ListNode(insertNode.val);
                if (preNde != null) {// 不为最前
                    preNde.next = listNode;
                    listNode.next = currentNode;
                } else {
                    listNode.next = currentNode;
                    newList = listNode;
                }
                break;
            }
        }

        if (!isAdd) {
            preNde.next = new ListNode(insertNode.val);
        }
        return newList;
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


