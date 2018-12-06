package com.example.leetcode.RemoveDuplicatesFromSortedArray;

import java.util.HashSet;
import java.util.Set;

/**The describe:
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 #############################ACCEPTED!###############################
 **/

public class Solution {


    public static int removeDuplicates(int[] nums) {
        Set set = new HashSet();
        int len = nums.length;
        for(int i=0; i<len; i++){
            while(set.contains(nums[i])){
                len--;
                if(i>=len) break;
                for(int k=i; k<len; k++){
                    nums[k] = nums[k+1];
                }
            }
            set.add(nums[i]);
        }
        return len;
    }

    public static void main(String[] args){

        int[] arr = new int[]{1, 1};
        System.out.println(removeDuplicates(arr));
    }

}
