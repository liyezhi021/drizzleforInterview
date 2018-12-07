package com.example.leetcode.StringToIntegerAtoi;
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


    public static int myAtoi(String str) {
        str = str.trim();
        boolean have_symbol = false;
        StringBuilder sb = new StringBuilder();
        if(str.length()<1) return 0;
        else {
            if(str.charAt(0)=='+' || str.charAt(0)=='-'){
                sb.append(str.charAt(0)); have_symbol = true;
            }
        }
        if(have_symbol){
            str = str.substring(1,str.length());
        }

        int flag = -1;
        for(int i=0; i<str.length(); i++){
            if(!(str.charAt(i)=='0')){
                flag = i; break;
            }
        }
        if(flag == -1) return 0;
        str = str.substring(flag, str.length());

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)>='0' && str.charAt(i)<='9')
                sb.append(str.charAt(i));
            else break;
        }
        if( !((sb.toString().length()>1 && (sb.toString().charAt(0)=='+'||
                sb.toString().charAt(0)=='-' || (sb.toString().charAt(0)>='0' && sb.toString().charAt(0)<='9')) &&
                (sb.toString().charAt(1)>='0' && sb.toString().charAt(1)<='9')) ||
                (sb.toString().length()==1 && ( sb.toString().charAt(0)>='0' && sb.toString().charAt(0)<='9'))) ) return 0;
        try{
            return Integer.parseInt(sb.toString());
        }catch (Exception e){
            if(have_symbol && sb.toString().charAt(0)=='-') return -2147483648;
            else return 2147483647;
        }
    }

    public static void main(String[] args){
        String str = "+0 123";
        System.out.println(myAtoi(str));
    }

}
