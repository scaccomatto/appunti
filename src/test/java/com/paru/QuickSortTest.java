package com.paru;

import com.paru.sorting.QuikSortAlgorithm;
import org.junit.Test;


public class QuickSortTest {

    @Test
    public void quickTest() {

        Integer[] input = new Integer[]{3, 2, 9, 4, 7, 1};

        QuikSortAlgorithm.quickSortImpl(input);
    }
}
