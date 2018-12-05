package com.example.leetcode.RemoveElement;
/**The describe:
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 #############################ACCEPTED!###############################
 **/

public class Solution {


    public static int removeElement(int[] nums, int val) {
        int ans = 0;
        for(int i: nums){
            if(i!=val) ans++;
        }
        int origin_len = nums.length;
        for(int i=0; i<origin_len;){
            if(nums[i] == val){
                for(int j=i; j<nums.length-1; j++){
                    nums[j]= nums[j+1];
                }
                origin_len--;
            }else i++;
        }
        return ans;
    }

    public static void main(String[] args){

        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }

}
