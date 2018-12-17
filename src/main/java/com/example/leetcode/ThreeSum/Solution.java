package com.example.leetcode.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**YGiven an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:

 The solution set must not contain duplicate triplets.
 #############################ACCEPTED!###############################
 **/

public class Solution {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i>=1 && nums[i-1]==nums[i]) continue;
            int j = i+1;
            int k = nums.length-1;
            int sum2 = -nums[i];
            while(j<k){
                if(nums[j]+nums[k]==sum2){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; k--;
                    while(j<k && nums[j-1]==nums[j]){
                        j++;
                    }
                    while(j<k && nums[k+1]==nums[k]){
                        k--;
                    }
                }else if(nums[j]+nums[k]< sum2)
                    j++;
                else k--;
            }
        }
        return ans;
    }


    public static void main(String[] args){

        int[] nums = new int[]{-2,0,1,1,2};
        System.out.println(threeSum(nums));
    }
}
