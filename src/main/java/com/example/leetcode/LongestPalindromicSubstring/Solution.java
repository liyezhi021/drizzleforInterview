package com.example.leetcode.LongestPalindromicSubstring;
/**Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s
 * is 1000.
 Example 1:
 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:
 Input: "cbbd"
 Output: "bb"

 #############################ACCEPTED!###############################
 **/

public class Solution {

    //ACCEPTED!
    public static int expandAroundCenter(String s, int start, int end){
        int L = start;
        int R = end;
        while(L>=0 && R<s.length() && s.charAt(L) == s.charAt(R)){
            L--;R++;
        }
        return R-L+1;
    }

    public static String longestPalindrome(String s) {
        if(s.equals("")) return "";
        int slen = s.length();
        int start = 0;
        int end = 0;
        for(int i=0; i<slen; i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1,len2);
            if(len> end-start){
                start = i- (len-1)/2;
                end = i+ len/2;
            }
        }
        return s.substring(start+1,end);
    }


    //my first answer  timeLimit
    public static boolean isPalindromic(String s){
        int len = s.length();
        if(len==1) return true;
        for(int i=0; i<len/2; i++){
            if(!((s.charAt(i)+"").equals(s.charAt(len-i-1)+""))){
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome1(String s) {
        int len = s.length();
        if(len==0)
            return "";
        String ans = s.charAt(0)+"";
        int ans_len = 1;
        for(int i=0; i<len; i++){
            for(int j=len-1; j>=i; j--){
                if(s.substring(i,j+1).length()>ans_len && s.charAt(i)==s.charAt(j) && isPalindromic(s.substring(i,j+1))){
                    ans = s.substring(i,j+1);
                    ans_len = ans.length();
                    break;
                }
            }
            if(ans_len >= len-i-1) break;
        }
        return ans;
    }

    public static void main(String[] args){
        long startTime=System.currentTimeMillis();
        String s = "cbbd";
        String s2 = "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg";
        String s3 = "gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg";
        String s4 = "gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg";
        System.out.println("-->"+ longestPalindrome(s));
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }

}
