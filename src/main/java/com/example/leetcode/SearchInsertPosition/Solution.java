package com.example.leetcode.SearchInsertPosition;
/**The describe:
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.

 #############################ACCEPTED!###############################
 **/

public class Solution {


    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(target > nums[len-1]) return len;
        if(target < nums[0]) return 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]<= target && target<=nums[i+1]){
                if(nums[i]== target) return i;
                else return i+1;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,3};
        int target = 3;
        System.out.println(searchInsert(nums, target));
    }

}
