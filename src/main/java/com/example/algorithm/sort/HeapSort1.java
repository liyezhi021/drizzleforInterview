package com.example.algorithm.sort;

public class HeapSort1 {

    void heapAdjust(int[] arr, int parent, int length){
        int temp = arr[parent];
        int child = 2*parent+1;
        while(child<length){
            if(child+1<length && arr[child]<arr[child+1])
                child++;
            if(temp>arr[child]) break;
            arr[parent] = arr[child];
            parent = child;
            child = 2*parent+1;
        }
        arr[parent] = temp;
    }

    void sort(int[] arr){
        for(int i= arr.length/2; i>=0; i--){
            heapAdjust(arr, i, arr.length);
        }
        for(int i= arr.length-1; i>=0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapAdjust(arr, 0, i);
        }
    }

    public static void main(String[] args){
        HeapSort1 sort = new HeapSort1();
        int[] arr = {
                1, 3, 2, 45, 65, 33, 12, 9, 8
        };
        sort.sort(arr);
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+ " ");
        System.out.println();
    }
}
