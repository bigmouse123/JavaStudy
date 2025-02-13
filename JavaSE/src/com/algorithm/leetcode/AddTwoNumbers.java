package com.algorithm.leetcode;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/12 10:21
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = null;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = null;
        ListNode listNode = addTwoNumbers(listNode1, listNode4);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        StringBuilder str1 = new StringBuilder();
//        StringBuilder str2 = new StringBuilder();
//        while (l1 != null) {
//            str1 = str1.append(l1.val);
//            l1 = l1.next;
//        }
//        str1.reverse();
//        while (l2 != null) {
//            str2 = str2.append(l2.val);
//            l2 = l2.next;
//        }
//        str2.reverse();
//        BigInteger i1 = new BigInteger(str1.toString());
//        BigInteger i2 = new BigInteger(str2.toString());
//        BigInteger sum = i1.add(i2);
//        String sumStr = sum + "";
//        ListNode head = new ListNode(Integer.parseInt(sumStr.substring(0, 1)));
//        ListNode listNode = null;
//        for (int i = 1; i < sumStr.length(); i++) {
//            listNode = new ListNode(Integer.parseInt(sumStr.substring(i, i + 1)));
//            listNode.next = head;
//            head = listNode;
//        }
//        return head;
//    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry;
            ListNode newNode = new ListNode(sum % 10);
            temp.next = newNode;
            temp = temp.next;
            carry = sum / 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            temp.next = newNode;
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
