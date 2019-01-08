package com.example.algorithm.sort;

public class HeapSort2 {

    public void HeapAdjust(int[] list, int parent, int length){
        int temp = list[parent];
        int child = parent*2+1;
        while(child<length){
            if(child+1<length && list[child]<list[child+1]) child++;
            if(temp>list[child]) break;
            list[parent] = list[child];
            parent = child;
            child = 2*parent+1;
        }
        list[parent]= temp;
    }

    public void HeapSort(int[] list){
        //初始化最大堆
        for(int i= list.length/2-1; i>=0; i--){
            HeapAdjust(list, i, list.length);
        }
        for(int i=list.length-1; i>=0; i--){
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            HeapAdjust(list, 0, i);
        }
    }

    public static void main(String[] args){
        int[] array = {
                1,3,4,5,2,17,9,7,8,0,10,6
        };
        HeapSort2 sort = new HeapSort2();
        System.out.println("heap sort start:");
        for(int i =0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        sort.HeapSort(array);
        System.out.println("heap sort end:");
        for(int i =0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
