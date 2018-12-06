package com.example.leetcode.ImplementStrStr;
/**The describe:
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 #############################ACCEPTED!###############################
 **/

public class Solution {


    public static int strStr(String haystack, String needle) {
        int hay_len = haystack.length();
        int nee_len = needle.length();
        if(nee_len==0) return 0;
        for(int i=0; i< hay_len-nee_len+1; i++){
            int j = i;
            int k = 0;
            while(true){
                if(haystack.charAt(j) == needle.charAt(k)){
                    k++; j++;
                    if(k==nee_len){
                        return i;
                    }
                }else break;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        String haystack = "a";
        String needle = "";
        System.out.println(strStr(haystack, needle));
    }

}
