package com.example.leetcode.String2Integer;

/**Implement atoi which converts a string to an integer.

 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

 The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned.


 #############################ACCEPTED!###############################
 **/

public class Solution {

    public static int myAtoi(String str) {
        str = str.replaceAll(" ","");
        if(str.length()==0) return 0;
        if(!(((str.charAt(0)=='+'|| str.charAt(0)=='-') && str.length()>1 && str.charAt(1)>47 && str.charAt(1)<58) ||
                str.charAt(0)>47 && str.charAt(0)<58))
            return 0;
        str = str.replaceAll("[^0-9\\-.]","");
        int dot = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='.') dot = i;
        }
        try {
            return Integer.parseInt(str);
        }catch (Exception e){
            if(str.charAt(0)=='-')
                return -2147483648;
            else
                return 2147483647;
        }
    }


    public static void main(String[] args){

        String str = "3.14159";
        System.out.println(myAtoi(str));
    }
}
