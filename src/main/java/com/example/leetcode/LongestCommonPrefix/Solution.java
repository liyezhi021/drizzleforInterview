package com.example.leetcode.LongestCommonPrefix;
/**Write a function to find the longest common prefix string amongst an array of strings.
 If there is no common prefix, return an empty string "".
 Example 1:
 Input: ["flower","flow","flight"]
 Output: "fl"
 Example 2:
 Input: ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.

 #############################ACCEPTED!###############################
 **/

public class Solution {


    public static String longestCommonPrefix(String[] strs) {
        int min_len = 0xfffffff;
        String target_s = "";
        StringBuilder ans = new StringBuilder();
        for(String s : strs){
            if(min_len> s.length()){
                min_len = s.length();
                target_s = s;
            }
        }
        for(int i=0; i<target_s.length(); i++){
            Character c = target_s.charAt(i);
            for(String s: strs){
                while(s.charAt(i)!= c){
                    return ans.toString();
                }
            }
            ans.append(c);
        }
        return ans.toString();
    }

    public static void main(String[] args){
        String[] stars = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(stars));
    }

}
