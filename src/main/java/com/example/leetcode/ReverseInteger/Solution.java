package com.example.leetcode.ReverseInteger;

import java.math.BigDecimal;

/**Given a 32-bit signed integer, reverse digits of an integer.
 Example 1:
 Input: 123
 Output: 321
 Example 2:
 Input: -123
 Output: -321
 Example 3:
 Input: 120
 Output: 21

 #############################ACCEPTED!###############################
 **/

public class Solution {


    public static int reverse(int x){
       String s = String.valueOf(x);
       boolean negetive = false;
       BigDecimal ans = new BigDecimal(0);
       BigDecimal dig = new BigDecimal(1);
       boolean flag = true;
       if(s.charAt(0)=='-') negetive = true;
       if(negetive){
           for(int i=1; i<s.length(); i++){
               if(!(s.charAt(i)+"").equals("0")) flag = false;
               if(!flag){
                   ans = ans.add(new BigDecimal(Integer.valueOf(s.charAt(i)+"")).multiply(dig));
                   dig= dig.multiply(new BigDecimal(10));
               }
           }
           if(ans.compareTo(new BigDecimal(-2147483648))==1 && ans.compareTo(new BigDecimal(2147483647))==-1)
                return ans.multiply(new BigDecimal(-1)).intValue();
           else return 0;
       }else {
           for(int i=0; i<s.length(); i++){
               if(!(s.charAt(i)+"").equals("0")) flag = false;
               if(!flag){
                   ans = ans.add(new BigDecimal(Integer.valueOf(s.charAt(i)+"")).multiply(dig));
                   dig= dig.multiply(new BigDecimal(10));
               }
           }
           if(ans.compareTo(new BigDecimal(-2147483648))==1 && ans.compareTo(new BigDecimal(2147483647))==-1)
               return ans.intValue();
           else return 0;
       }
    }

    public static void main(String[] args){
        System.out.println(reverse(123));
    }

}
