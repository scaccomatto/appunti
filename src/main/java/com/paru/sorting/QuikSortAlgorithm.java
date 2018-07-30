package com.paru.sorting;


import java.util.List;
import java.util.Random;


public class QuikSortAlgorithm {

    public static void quickSortImpl(Integer[] arrayToSort) {

        if (arrayToSort == null || arrayToSort.length == 0)
            return;

        quickSort(arrayToSort, 0, arrayToSort.length - 1);

    }

    private static void quickSort(Integer[] arrayToSort, int start, int end) {

        int pivot = (end + start) / 2;
        int left = start;
        int right = end;

        while (left <= right) {
            while (arrayToSort[left] < pivot) {
                left++;
            }
            while (arrayToSort[right] > pivot) {
                right--;
            }
            if (left <= right) {
                exchange(arrayToSort, left, right);
                left++;
                right--;
            }

        }
        if (start < right) {
            quickSort(arrayToSort, start, right);
        }
        if (left < end) {
            quickSort(arrayToSort, left, end);
        }
    }

    private static void exchange(Integer[] arrayToSort, int left, int right) {
        int temp = arrayToSort[left];
        arrayToSort[left] = arrayToSort[right];
        arrayToSort[right] = temp;
    }

    private static List<Integer> merge(List<Integer> minor, List<Integer> major) {
        minor.addAll(major);
        return minor;
    }

    private static int getPivot(List<Integer> arrayToSort) {
        Random r = new Random();
        int middle = r.nextInt(arrayToSort.size());
        return arrayToSort.get(middle);
    }
}
