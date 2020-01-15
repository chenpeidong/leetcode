package site.syso.leetcode.medium;

import site.syso.bean.ListNode;

/**
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class M0002_AddTwoNumbers {


    public static void main(String[] args) {
        CustomLinkedList linkedList1 = new CustomLinkedList();
        linkedList1.add(new ListNode(2));
        linkedList1.add(new ListNode(4));
        linkedList1.add(new ListNode(3));
        System.out.println(linkedList1);
        CustomLinkedList linkedList2 = new CustomLinkedList();
        linkedList2.add(new ListNode(5));
        linkedList2.add(new ListNode(6));
        linkedList2.add(new ListNode(4));
        System.out.println(linkedList2);
        M0002_AddTwoNumbers m0002_addTwoNumbers = new M0002_AddTwoNumbers();
        ListNode node = m0002_addTwoNumbers.addTwoNumbers2(linkedList1.head, linkedList2.head);
        System.out.println(node);
        ListNode node1 = m0002_addTwoNumbers.addTwoNumbers(linkedList1.head, linkedList2.head);
        System.out.println(node1);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    private ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        boolean increase = false;
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        while (p != null || q != null || increase) {
            int sum = 0;
            if (p != null) sum += p.val;
            if (q != null) sum += q.val;
            if (increase) sum += 1;
            increase = sum / 10 == 1;
            int val = increase ? sum - 10 : sum;
            curr.next = new ListNode(val);
            curr = curr.next;
            p = p == null ? null : p.next;
            q = q == null ? null : q.next;
        }
        return dummyHead.next;
    }

}

class CustomLinkedList {
    ListNode head;
    ListNode tail;

    void add(ListNode node) {
        if (node == null) return;
        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
    }
}
