package com.example.leetcode.TwoSum;
/**The describe:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,
 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].

 #############################ACCEPTED!###############################
 **/

public class Solution {


    public static int[] twoSum(int[] nums, int target){
        int[] arr = new int[2];
        for(int i=0; i< nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    arr[0] =i;arr[1] = j; return arr;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] answer = twoSum(nums, target);
        System.out.println("The solutions:"+ answer.length + "value.." + answer[0] + answer[1]);
    }

}
