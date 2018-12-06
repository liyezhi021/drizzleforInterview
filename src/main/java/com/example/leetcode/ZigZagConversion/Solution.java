package com.example.leetcode.ZigZagConversion;
/**The describe:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);

 #############################ACCEPTED!###############################
 **/

public class Solution {


    public static String convert(String s, int numRows) {
        if(s.equals("")) return "";
        if(numRows==1) return s;
        int len = s.length();
        int len_1;
        if(len%((numRows-1)*2)!=0) len_1= (len/((numRows-1)*2))*numRows + numRows-1;
        else len_1= (len/((numRows-1)*2))*numRows;
        char[][] arr = new char[numRows][len_1];
        int m=0; int n=0;
        for(int i=0; i<len ; i++){
            arr[m][n] = s.charAt(i);
            if(m==numRows-1){
                m--; n++; continue;
            }
            if(n%(numRows-1)==0){
                m++;
            }else{
                m--; n++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<len_1; j++){
                if(arr[i][j]!=0)
                    sb.append(arr[i][j]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String s = "";
        int numRows = 1;
        System.out.println(convert(s, numRows));
    }

}
