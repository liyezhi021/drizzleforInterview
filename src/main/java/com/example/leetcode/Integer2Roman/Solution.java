package com.example.leetcode.Integer2Roman;

/**Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

 Symbol       Value
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000

 For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

 Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

 I can be placed before V (5) and X (10) to make 4 and 9.
 X can be placed before L (50) and C (100) to make 40 and 90.
 C can be placed before D (500) and M (1000) to make 400 and 900.

 Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 #############################ACCEPTED!###############################
 **/

public class Solution {

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while(num/1000>0){
            sb.append("M");num-=1000;
        }
        if(num>=900){
            sb.append("CM"); num-=900;
        }

        while(num/500>0){
            sb.append("D");num-=500;
        }
        if(num>=400){
            sb.append("CD"); num-=400;
        }

        while(num/100>0){
            sb.append("C"); num-=100;
        }
        if(num>=90){
            sb.append("XC"); num-=90;
        }

        while(num/50>0){
            sb.append("L"); num-=50;
        }
        if(num>=40){
            sb.append("XL"); num-=40;
        }

        while(num/10>0){
            sb.append("X"); num-=10;
        }
        if(num>=9){
            sb.append("IX"); num-=9;
        }

        while(num/5>0){
            sb.append("V"); num-=5;
        }
        if(num>=4){
            sb.append("IV"); num-=4;
        }

        while(num>0){
            sb.append("I"); num-=1;
        }

        return sb.toString();
    }


    public static void main(String[] args){

        int num = 1;
        System.out.println(intToRoman(num));
    }
}
