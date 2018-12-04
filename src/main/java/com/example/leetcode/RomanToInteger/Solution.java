package com.example.leetcode.RomanToInteger;
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

    public static int romanToInt(String s) {
        int ans = 0;
        boolean flag = false;
        for(int i=0; i<s.length();){
            flag = false;
            if(i+2<=s.length()){
                switch (s.substring(i, i+2)){
                    case "CM":
                        ans+=900;i+=2;break;
                    case "CD":
                        ans+=400;i+=2;break;
                    case "XC":
                        ans+=90;i+=2;break;
                    case "XL":
                        ans+=40;i+=2;break;
                    case "IX":
                        ans+=9;i+=2;break;
                    case "IV":
                        ans+=4;i+=2;break;
                    default:
                        flag = true;break;
                }
                if(flag){
                    switch (s.substring(i, i+1)){
                        case "M":
                            ans+=1000;i++;break;
                        case "D":
                            ans+=500;i++;break;
                        case "C":
                            ans+=100;i++;break;
                        case "L":
                            ans+=50;i++;break;
                        case "X":
                            ans+=10;i++;break;
                        case "V":
                            ans+=5;i++;break;
                        case "I":
                            ans++;i++;break;
                    }
                }
            }else{
                switch (s.substring(i, i+1)){
                    case "M":
                        ans+=1000;i++;break;
                    case "D":
                        ans+=500;i++;break;
                    case "C":
                        ans+=100;i++;break;
                    case "L":
                        ans+=50;i++;break;
                    case "X":
                        ans+=10;i++;break;
                    case "V":
                        ans+=5;i++;break;
                    case "I":
                        ans++;i++;break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

}
