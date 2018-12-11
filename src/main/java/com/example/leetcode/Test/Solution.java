package com.example.leetcode.Test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import java.util.*;

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

    public static int Example(int e){


        return 0;
    }

    public static void main(String[] args){
        List<Student> list = new ArrayList<>();
        Student s = new Student();
        s.setTime(1233399);
        s.setName("a");
        list.add(s);
        Student s1 = new Student();
        s1.setTime(1233344);
        s1.setName("b");
        list.add(s1);
        Student s2 = new Student();
        s2.setTime(1233355);
        s2.setName("c");
        list.add(s2);
        /*Comparator<Student> comparator = (Student d1, Student d2) -> d1.getDate().compareTo(d2.getDate());
        Collections.sort(list, comparator);*/
        list.sort((a,b)-> (b.getTime()).compareTo(a.getTime()));
        System.out.println(list);

    }


    public static class Student{
        private Long time;
        private String name;

        public Long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
