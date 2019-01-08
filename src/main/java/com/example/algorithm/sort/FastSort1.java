package com.example.algorithm.sort;

public class FastSort1 {


    void fastSort(int[] list, int low, int high){
        int start = low;
        int end = high;
        int key = list[low];

        while(start<end){
            while(start<end && list[end]>=key) end--;
            if(list[end]<key){
                int temp = list[start];
                list[start] = list[end];
                list[end]= temp;
            }
            while(start<end && list[start]<=key) start++;
            if(list[start]>key){
                int temp = list[start];
                list[start] = list[end];
                list[end]= temp;
            }
        }
        //递归
        if(start>low) fastSort(list, low, start-1);
        if(end<high) fastSort(list, end+1, high);

    }

    public static void main(String[] args){
        FastSort1 fastSort = new FastSort1();
        int[] arr = {12,20,5,16,15,1,30,45,23,9};
        fastSort.fastSort(arr, 0, arr.length-1);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
