package com.paru;


import com.paru.sorting.MergeSortAlgorithm;
import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {

    @Test
    public void testMergeSort() {

        Integer[] input = new Integer[]{3, 2, 9, 4, 7, 1};

        System.out.println(Arrays.toString(input));
        // MergeSortAlgorithm.mergeSort(input);
        System.out.print("risultato: ");
        System.out.println(Arrays.toString(input));
    }
}
