package com.example.algorithm.sort;

public class InsertionSort {

    void insertionSort(int[] arr){
        for(int i =1; i<arr.length; i++){
            int temp = arr[i];
            for(int j =i; j>=0; j--){
                if(j>0 && arr[j-1]> temp){
                    arr[j]= arr[j-1];
                }else{
                    arr[j] = temp;
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {1, 3, 2, 45, 65, 33, 12};
        InsertionSort sort = new InsertionSort();
        System.out.println("交换之前：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        sort.insertionSort(arr);
        System.out.println("交换后：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
