package com.paru.sorting;

import java.util.Arrays;


public class MergeSortAlgorithm {

    public static void mergeSort(Integer[] arrayToSort){

        Integer[] copy = new Integer[arrayToSort.length];
        mergeSort(0,arrayToSort.length-1, arrayToSort, copy);

    }

    private static void mergeSort(int start, int end, Integer[] arrayToSort, Integer[] copy) {
        if(start<end) {
            int middle = (end+start)/ 2;

            mergeSort(start, middle, arrayToSort, copy);
            mergeSort(middle + 1, end, arrayToSort, copy);

            merge(start, end, middle, arrayToSort, copy);
        }
    }

    private static void merge(int start, int end, int middle, Integer[] arrayToSort, Integer[] copy) {

        copyArray(arrayToSort, copy);

        int left= start;
        int right = middle+1;
        int k = start;

        while(left<=middle && right<=end){
            if(copy[left]<=copy[right]){
                arrayToSort[k]=copy[left];
                left++;
            }else{
                arrayToSort[k]=copy[right];
                right++;
            }
            k++;
        }
        while(left<=middle){
            arrayToSort[k]=copy[left];
            left++;
            k++;
        }

        System.out.println(" e poi "+ Arrays.toString(arrayToSort));

    }

    private static void copyArray(Integer[] arrayToSort, Integer[] copy) {
        for(int i=0; i< arrayToSort.length;i++){
            copy[i]=arrayToSort[i];
        }
    }


}
