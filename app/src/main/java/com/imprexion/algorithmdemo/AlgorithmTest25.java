package com.imprexion.algorithmdemo;

import java.util.HashMap;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class AlgorithmTest25 {


    public static void main(String[] args) {

    }

    /**
     * // 经分析, 当链表存在公共节点,则存在相同的尾结点
     * 1种思路,找到两个链表的长度差 , 让长的链表先走到长度差的位置,再两个链表一起走,比较两个链表节点是否相等
     * 2种思路,将两个链表拼接到一起,分别另一个链表拼在前面,再一起走,当节点相等及为公共节点
     *
     * @param pHead1
     * @param pHead2
     * @return
     */

    public static ListNode FindFirstCommonNodeTwo(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2) {
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }

        return p1;

    }
    //----------------------------------------------------------------------------------------------

    /**
     * @param pHead1
     * @param pHead2
     * @return 将链表1的值已value -> index 方式存储到hashMap
     * 再遍历第二个数组，找到对应的索引值，找到相同的第一个元素
     */
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode currentNode = pHead1;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        int index = 0;
        while (currentNode != null) {
            // 排序将数据存入list集合
            hashMap.put(currentNode.val, index);
            currentNode = currentNode.next;
            index++;
        }

        currentNode = pHead2;
        int min = -1;
        while (currentNode != null) {
            int indexValue = (int) hashMap.get(currentNode.val);
            if (indexValue != -1 && min == -1) {
                min = indexValue;
            } else {
                min = Math.min(min, indexValue);
            }
            currentNode = currentNode.next;
        }

        int currentIndex = 0;
        if (min != -1) {
            currentNode = pHead2;
            while (currentNode != null) {
                if (currentIndex == min) {
                    return currentNode;
                }
                currentNode = currentNode.next;
                currentIndex++;
            }
        }

        return null;
    }


    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
