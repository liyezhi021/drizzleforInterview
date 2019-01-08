package com.example.algorithm.sort;

public class FastSort {

    void fastSort(int[] arr, int low, int high){
        int start = low;
        int end = high;
        int key = arr[low];

        while(end>start){
            while(end>start && arr[end]>=key)
                end --;
            if(arr[end]<=key){
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            while(end>start && arr[start]<=key)
                start++;
            if(arr[start]>=key){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        if(start>low) fastSort(arr, low, start-1);
        if(end< high) fastSort(arr, end+1, high);
    }

    public static void main(String[] args){
        FastSort fastSort = new FastSort();
        int[] arr = {12,20,5,16,15,1,30,45,23,9};
        fastSort.fastSort(arr, 0, arr.length-1);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}
