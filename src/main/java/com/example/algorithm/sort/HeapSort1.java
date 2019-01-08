package com.example.algorithm.sort;

public class HeapSort1 {

    public void HeapAdjust(int[] arr, int parent, int length){
        int temp = arr[parent];
        int child = 2* parent+1;// 先拿到左节点

        while(child<length){
            if(child+1<length && arr[child]<arr[child+1]){
                child ++;
            }
            if(temp> arr[child])
                break;

            arr[parent] = arr[child];

            parent = child;
            child = 2* parent+1;
        }
        arr[parent] = temp;

    }

    public void HeapSort(int[] array){
        //初始化最大堆
        for(int i =array.length/2; i>=0; i--){
            HeapAdjust(array, i, array.length);
        }

        for(int i=array.length-1; i>=0; i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            HeapAdjust(array, 0, i);
        }

    }


    public static void main(String[] args){
        int[] array = {
                1,3,4,5,2,17,9,7,8,0,10,6
        };
        HeapSort1 sort = new HeapSort1();
        System.out.println("sort start:");
        for(int i =0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        sort.HeapSort(array);
        System.out.println("sort end:");
        for(int i =0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();

    }

}
