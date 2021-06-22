package com.newcode;


public class RevertListNodeSolution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        printList(head);
        System.out.println("------------");
        ListNode res = ReverseList(head);
        printList(res);

    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


    public static ListNode ReverseList(ListNode head) {
        ListNode temp = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = temp;
            temp = head;
            if (next == null) {
                break;
            }
            head = next;

        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}