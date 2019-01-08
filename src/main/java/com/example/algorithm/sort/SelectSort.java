package com.example.algorithm.sort;

public class SelectSort {

    void selectSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int k = i;
            for(int j = k+1; j<arr.length; j++){
                if(arr[j]<arr[k]){
                    k = j;
                }
            }
            if(i!= k){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 45, 65, 33, 12};
        SelectSort selectSort = new SelectSort();
        System.out.println("交换之前：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        selectSort.selectSort(arr);
        System.out.println("交换后：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
