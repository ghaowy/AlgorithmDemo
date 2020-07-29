package com.imprexion.algorithmdemo;

/**
 * @author : gongh
 * @date : 2020/5/26 17:24
 * <p>
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class AlgorithmTest51 {

    public static void main(String[] args) {

    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4?f=discussion
     * 来源：牛客网
     *
     * 1、设置快慢指针，假如有环，他们最后一定相遇。
     * 2、两个指针分别从链表头和相遇点继续出发，每次走一步，最后一定相遇与环入口。
     * 证明结论1：设置快慢指针fast和low，fast每次走两步，low每次走一步。假如有环，两者一定会相遇（因为low一旦进环，可看作fast在后面追赶low的过程，每次两者都接近一步，最后一定能追上）。
     * @param pHead
     * @return
     */
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while (fast != slow) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (slow.next != null) {
                slow = slow.next;
            } else {
                return null;
            }
        }

        fast = pHead;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}


