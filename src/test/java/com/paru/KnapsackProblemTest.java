package com.paru;


import com.paru.dynamicDrogramming.KnapsackProblem;
import org.junit.Test;

public class KnapsackProblemTest {

    @Test
    public void runTest(){

        int val[] = new int[]{120, 100, 60};
        int wt[] = new int[]{30, 20, 10};
        int  W = 50;
        int n = val.length;
        System.out.println(KnapsackProblem.knappSackRecursive(wt, val,W, n));
        System.out.println(KnapsackProblem.knappSackDynamicProgrammingSolution(wt, val,W, n));
    }
}
