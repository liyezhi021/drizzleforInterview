package com.example.leetcode.MostWater;

import java.util.Set;
import java.util.TreeSet;

/**Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.

 #############################ACCEPTED!###############################
 **/

public class Solution {

    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int max_val = 0;
        while(start<end){
            int v = height[start];
            int w = height[end];
            if(Math.min(v,w)*(end-start)>max_val){
                max_val = Math.min(v,w)*(end-start);
            }
            if(v>w) end--;
            else start++;
        }
        return max_val;
    }


    public static void main(String[] args){
        int[] height = new int[]{76,155,15,188,180,154,84,34,187,142,22,5,27,183,111,128,50,58,2,112,179,2,100,111,115,76,134,120,118,103,31,146,58,198,134,38,104,170,25,92,112,199,49,140,135,160,20,185,171,23,98,150,177,198,61,92,26,147,164,144,51,196,42,109,194,177,100,99,99,125,143,12,76,192,152,11,152,124,197,123,147,95,73,124,45,86,168,24,34,133,120,85,81,163,146,75,92,198,126,191};
        System.out.println(maxArea(height));
    }
}
