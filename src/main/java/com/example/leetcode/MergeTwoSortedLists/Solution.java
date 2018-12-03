package com.example.leetcode.MergeTwoSortedLists;

import java.util.*;

/**The describe:
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

 #############################ACCEPTED!###############################
 **/

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        if(l1==null && l2==null) return null;
        if(l1==null && l2!=null) return l2;
        if(l1!=null && l2==null) return l1;
        list.add(l1.val); list.add(l2.val);
        while(l1.next!=null){
            list.add(l1.next.val);
            l1 = l1.next;
        }
        while(l2.next!=null){
            list.add(l2.next.val);
            l2= l2.next;
        }

        list.sort((Integer t1, Integer t2)-> t1.compareTo(t2));
        ListNode l = new ListNode(list.get(0));
        ListNode lcp = l;
        for(int i=1; i<list.size(); i++){
            lcp.next = new ListNode(list.get(i));
            lcp = lcp.next;
        }
        return l;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        mergeTwoLists(l1,l2);
    }

}
