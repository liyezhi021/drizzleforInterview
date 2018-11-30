package com.example.leetcode.PalindromeNumber;
/**Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 Example 1:
 Input: 121
 Output: true
 Example 2:
 Input: -121
 Output: false
 Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 Example 3:
 Input: 10
 Output: false
 Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

 #############################ACCEPTED!###############################
 **/

public class Solution {
//  1221  len/2= 2 len =4     12621 len/2 =2 len =5

    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        String s = String.valueOf(x);
        int len = s.length();
        if(len==1) return true;
        for(int i=0; i<len/2; i++){
            if(!((s.charAt(i)+"").equals(s.charAt(len-i-1)+""))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int x = 10;
        System.out.println(isPalindrome(x));
    }

}
