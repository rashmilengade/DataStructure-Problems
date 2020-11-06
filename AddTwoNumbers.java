package com.example;

import javax.swing.*;

public class AddTwoNumbers {

    public static class ListNode {
      int value;
      ListNode next;
      ListNode() {}
      ListNode(int value) { this.value = value; }
      ListNode(int value, ListNode next) { this.value = value; this.next = next; }
      ListNode getNext(){return this.next;}
        static ListNode newNode(int data)
        {
            ListNode temp = new ListNode();

            temp.value = data;
            temp.next = null;
            return temp;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode dummyHead = ListNode.newNode(0);
        ListNode current = dummyHead;
        int carry =0;
        ListNode p=l1, q=l2;

        while(p != null || q != null)
        {
            int x = (p !=null) ? p.value : 0;
            int y = (q !=null) ? q.value : 0;
            int sum = x+y+carry;
            carry = sum/10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }

        if(carry > 0)
        {
            current.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    public static void printList(ListNode head)
    {
        while(head.next != null)
        {
            System.out.println(head.value + " ");
            head = head.getNext();
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        ListNode l1 = ListNode.newNode(1);
        l1.next = ListNode.newNode(2);
        l1.next.value = 2;
        //l1.next.next = new ListNode(3);
        ListNode l2 = ListNode.newNode(7);
        l2.next = ListNode.newNode( 6);
        l2.next.value=6;
        //l2.next.next = new ListNode(9);
        printList(l1);
        printList(l2);
        ListNode l3 = addTwoNumbers(l1,l2);
        printList(l3);

    }
}
