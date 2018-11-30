package com.example.leetcode.LongestSubStringWithOut;


import java.util.HashSet;
import java.util.Set;

/**Given a string, find the length of the longest substring without repeating characters.
 Example 1:
 Input: "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.
 Example 2:
 Input: "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.
 Example 3:
 Input: "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 用set来做  效率似乎有点低？

 #############################ACCEPTED!###############################
 **/

public class Solution {



    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for(int i=0; i<len; i++){
            for(int j=i; j<len; j++){
                if(set.contains(s.charAt(j))){
                    if(ans<set.size()){
                        ans = set.size();
                    }
                    set.clear();
                    break;
                }else{
                    set.add(s.charAt(j));
                }
            }
        }
        if(ans<set.size()){
            ans = set.size();
        }
        return ans;
    }

    public static void main(String[] args){
        String s = "jbpnbwwd";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
