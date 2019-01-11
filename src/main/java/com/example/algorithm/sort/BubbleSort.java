package com.example.algorithm.sort;

public class BubbleSort {

    public void BubbleSort(int[] list){
        boolean flag = true;
        int temp;
        for(int i=0; i<list.length-1; i++){
            for(int j=0; j<list.length-1-i; j++){
                if(list[j]>list[j+1]){
                    temp = list[j];
                    list[j]= list[j+1];
                    list[j+1] = temp;
                    flag = false;
                }
            }
            if(flag) break;
        }
    }

    public static void main(String[] args){
        int[] array = {
                1,3,4,5,2,17,9,7,8,0,10,6
        };
        BubbleSort bubble = new BubbleSort();
        bubble.BubbleSort(array);
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

}
