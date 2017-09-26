package com.paru.dynamicDrogramming;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChildRunning123FibonacciVersion {

    private final static Logger LOGGER = Logger.getLogger(ChildRunning123FibonacciVersion.class.getName());
    //private final static Logger LOGGER = Logger.getLogger(Solution.class.getName());

    public static void main(String[] args) {
        String input = "3";
        // con 37 il metodo ricorsivo non finisce....

        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {
            //try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();

            System.out.println(countWays(n));
            System.out.println(countWaysRecursive(n));

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private static int countWaysRecursive(int n){
        if(n<0){
            return 0;
        } else if(n==0){
            return 1;
        } else {
            return countWaysRecursive(n-1)+countWaysRecursive(n-2)+countWaysRecursive(n-3);
        }
    }

    private static int countWays(int n) {

        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return countWaysWithArray(memo, n);
    }

    private static int countWaysWithArray(int[] memo, int n) {

        if(n<0){
            return 0;
        } else if (n==0){
            return 1;
        } else if(memo[n]>-1){
            return memo[n];
        } else {
            memo[n] = countWaysWithArray(memo,n-1)+ countWaysWithArray(memo, n-2)+countWaysWithArray(memo, n-3);
            return memo[n];
        }


    }
}
