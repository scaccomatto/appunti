package com.paru.dynamicDrogramming;


public class KnapsackProblem {

    // http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/

    public static int knappSackRecursive(int[] weight, int[] values, int capacity, int index) {

        if (index == 0 || capacity <= 0)
            return 0;

        if (weight[index - 1] > capacity) {
            return knappSackRecursive(weight, values, capacity, index - 1);
        } else {
            return Math.max(values[index - 1] + knappSackRecursive(weight, values, capacity - weight[index - 1], index - 1),
                    knappSackRecursive(weight, values, capacity, index - 1));
        }
    }

    public static int knappSackDynamicProgrammingSolution(int[] weight, int[] values, int capacity, int index) {

        int capacityMatrix[][] = new int[index+1][capacity+1];

        for(int i=0;i<=index;i++){
            for(int w=0;w<=capacity;w++){
                //
                if (i==0 || w==0) {
                    capacityMatrix[i][w] = 0;
                }else if(weight[i-1]<=w){
                    capacityMatrix[i][w] = Math.max( values[i-1]+capacityMatrix[i-1][w -weight[i-1]] ,capacityMatrix[i-1][w]);
                } else {
                    capacityMatrix[i][w] = capacityMatrix[i-1][w];
                }
            }
        }

        return capacityMatrix[index][capacity];

    }


}
