package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc : TODO 计算数的 原 反 补
 */
public class AlgorithmTest14 {

    public static void main(String[] args) {
        RandomListNode randomListNode = new RandomListNode(10);
        randomListNode.next = new RandomListNode(5);
        randomListNode.random = new RandomListNode(13);
        System.out.println(Clone(randomListNode));
    }

    // 1、在当前链表上创建新的链表节点
    // 2、复制对应链表指针
    // 3、拆分链表
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 在当前链表创建链表复制节点

        RandomListNode currentNode = pHead;

        while (currentNode != null) {
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            cloneNode.next = currentNode.next;
            currentNode.next = cloneNode;
            currentNode = cloneNode.next;
        }

        // 复制对应的指针联系
        currentNode = pHead;
        while (currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            cloneNode.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = cloneNode.next;
        }

        currentNode = pHead;
        RandomListNode cloneHead = pHead.next;
        while (currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = currentNode.next == null ? null : currentNode.next.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return cloneHead;
    }


    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

        public void show() {
            System.out.println(" label= " + label);
            while (next != null) {
                next.show();
            }

            System.out.println(" random= " + label);
        }

        @Override
        public String toString() {
            return "RandomListNode{" +
                    "label=" + label +
                    ", next=" + (next == null ? "null" : next.label) +
                    ", random=" + (random == null ? "null" : random.label) +
                    '}';
        }
    }

}
