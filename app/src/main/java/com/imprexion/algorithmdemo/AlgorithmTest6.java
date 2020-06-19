package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * @desc : TODO 计算数的 原 反 补
 */
public class AlgorithmTest6 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.addNode(new ListNode(3));
        listNode.addNode(new ListNode(5));
        listNode.addNode(new ListNode(7));
        listNode.addNode(new ListNode(10));

        ListNode listNode1 = new ListNode(2);
        listNode1.addNode(new ListNode(4));
        listNode1.addNode(new ListNode(6));
        listNode1.addNode(new ListNode(8));
        listNode1.addNode(new ListNode(9));
        listNode1.addNode(new ListNode(13));

        Merge(listNode, listNode1);
    }




    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode p = list1;
        ListNode q = list2;
        ListNode mergeHead = null;

        if (p.val > q.val) {
            mergeHead = q;
            q = q.next;
        } else {
            mergeHead = p;
            p = p.next;
        }
        ListNode node = mergeHead;


        while (p != null && q != null) {
            System.out.println(" q.val= " + q.val + " p.val= " + p.val);
            if (p.val > q.val) {
                node.next = q;
                q = q.next;
            } else {
                node.next = p;
                p = p.next;
            }
            node = node.next;
            System.out.println("node.val= " + node.val);
        }

        if (p == null) {
            node.next = q;
        }

        if (q == null) {
            node.next = p;
        }
        mergeHead.show();
        return mergeHead;
    }


    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        pre.show();
        return pre;

    }

    public static int FindKthToTail(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;
        int i = 0;
        while (p != null) {
            p = p.next;
            if (i >= k) {
                q = q.next;
            }
            i++;
        }
        return q.val;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public void addNode(ListNode node) {
            ListNode next = this;
            while (next.next != null) {
                next = next.next;
            }
            next.next = node;
        }

        public void show() {
            ListNode node = this;
            while (node != null) {
                System.out.println("value= " + node.val);
                node = node.next;
            }
        }
    }
}
