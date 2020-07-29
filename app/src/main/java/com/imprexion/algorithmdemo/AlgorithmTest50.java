package com.imprexion.algorithmdemo;

import java.util.ArrayList;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class AlgorithmTest50 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        deleteDuplication(listNode);
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        pHead.show(arrayList);
        System.out.println(arrayList);
        boolean delete = false;
        ListNode currentNode = pHead;
        ListNode startNode = null;
        ListNode pre = null;
        // 找到队头
        while (startNode == null && currentNode != null) {
            ListNode next = currentNode.next;
            if (pre == null && next == null || pre == null && next.val != currentNode.val || pre != null && next == null && pre.val != currentNode.val || next != null && next.val != currentNode.val && pre != null && pre.val != currentNode.val) {
                startNode = currentNode;
                pHead = currentNode;
                break;
            }
            pre = currentNode;
            currentNode = next;
        }

        if (startNode == null) {
            return null;
        }

        // 执行删除
        while (currentNode != null) {
            ListNode next = currentNode.next;
            if (next != null && currentNode.val != next.val) {
                if (delete) {
                    startNode.next = currentNode.next;
                    delete = false;
                } else {
                    startNode = currentNode;
                }
            } else if (next != null) {
                delete = true;
            }

            if (next == null && delete) {
                startNode.next = null;
            }
            currentNode = next;
        }
        arrayList.clear();
        pHead.show(arrayList);
        System.out.println(arrayList);

        return pHead;
    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public void show(ArrayList<Integer> list) {
            list.add(val);
            if (next != null) {
                next.show(list);
            }
        }
    }
}


