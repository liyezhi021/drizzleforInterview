package com.example.leetcode.ValidParentheses;
/**The describe:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *
 * Note that an empty string is also considered valid.

 #############################ACCEPTED!###############################
 **/

public class Solution {

    private static int ii = 1;

    //ascII "("=40 ")"=41 "["=91 "]"=93 "{"=123 "}"=125
    public static boolean isValid(String s) {
        if(s.length()%2==1) return false;
        if(s.length()==0) return true;
        Character c = s.charAt(0);
        int flag = 1;
        if(s.length()>1){
            for(int i=1;i<s.length();i++){
                if(c==40){
                    if(s.charAt(i)==40)
                        flag ++;
                    else if(s.charAt(i)==41){
                        flag--;
                        if(flag==0){
                            if(i==ii) return true;
                            if(i>ii){
                                if(!isValid(s.substring(ii,i))){
                                    return false;
                                }
                                if(i+1 < s.length()){
                                    flag = 0;c= s.charAt(i+1); ii=i+2;
                                }
                            }
                        }
                    }
                }else {
                    if(s.charAt(i)==c)
                        flag ++;
                    else if(s.charAt(i)==c+2){
                        flag--;
                        if(flag==0){
                            if(i==ii) return true;
                            if(i>ii){
                                if(!isValid(s.substring(ii,i))){
                                    return false;
                                }
                                if(i+1 < s.length()){
                                    flag = 0;c= s.charAt(i+1); ii=i+2;
                                }
                            }
                        }
                    }
                }
            }
            if(flag!=0)
                return false;
        }

        return true;
    }

    public static void main(String[] args){
        String s = "{}{}()[]";
        System.out.println(isValid(s));
    }

}
