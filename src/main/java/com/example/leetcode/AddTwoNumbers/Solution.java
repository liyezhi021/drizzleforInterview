package com.example.leetcode.AddTwoNumbers;

import java.math.BigDecimal;

/**You are given two non-empty linked lists representing two non-negative integers. The digits are stored in
 * reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 Example:
 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.

 这道题不用大数 int存不下 第一次RuntimeError 第二次AC
 #############################ACCEPTED!###############################
 **/

public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        BigDecimal n1 = new BigDecimal(0);
        BigDecimal n2 = new BigDecimal(0);
        BigDecimal dig = new BigDecimal(1);
        while(l1.next!= null){
            n1 = n1.add(new BigDecimal(l1.val).multiply(dig));
            l1 = l1.next;
            dig = dig.multiply(new BigDecimal(10));
        }
        n1 = n1.add(new BigDecimal(l1.val).multiply(dig));
        dig =new BigDecimal(1);
        while(l2.next!= null){
            n2 = n2.add(new BigDecimal(l2.val).multiply(dig));
            l2 = l2.next;
            dig = dig.multiply(new BigDecimal(10));
        }
        n2 = n2.add(new BigDecimal(l2.val).multiply(dig));
        BigDecimal n3 = n1.add(n2);
        String s = String.valueOf(n3);
        ListNode l3 = new ListNode(Integer.valueOf(s.charAt(s.length()-1)+""));
        for(int i=s.length()-2; i>=0; i--){
            ListNode l5 = l3;
            ListNode l4 = new ListNode(Integer.valueOf(s.charAt(i)+""));
            while(true){
                if(l5.next!=null){
                    l5 = l5.next;
                }else{
                    l5.next = l4;
                    break;
                }
            }
        }

        return l3;
    }


    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next.next.next = new ListNode(9);
        ListNode l2 = l1;
        System.out.println(addTwoNumbers(l1,l2));

    }

}
