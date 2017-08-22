package com.paru.hackerRankProblems;

import java.io.*;
import java.util.*;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TwoDArray {

    private final static Logger LOGGER = Logger.getLogger(TwoDArray.class.getName());

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        try (Scanner scanner = new Scanner(System.in)) {

            int[][] initialArray = getArray2D(scanner);
            int arraySize = initialArray.length;
            int maxSum = Integer.MIN_VALUE;
            if (arraySize < 3) {
                System.out.println(maxSum);
                return;
            }

            for (int i = 1; i < arraySize - 1; i++) {
                for (int j = 1; j < arraySize - 1; j++) {
                    int sum = initialArray[i - 1][j - 1] + initialArray[i - 1][j] + initialArray[i - 1][j + 1] +
                            initialArray[i][j] +
                            initialArray[i + 1][j - 1] + initialArray[i + 1][j] + initialArray[i + 1][j + 1];
                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
            System.out.println(maxSum);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            System.out.println(0);
        }
    }

    private static int[][] getArray2D(Scanner scanner) {
        int size = 0;
        int index = 0;
        int[][] data = null;
        do {
            String line = scanner.nextLine().trim();
            String[] stringLine = line.split("\\s+");
            size = stringLine.length;
            if (data == null) {
                data = new int[size][size];
            }

            for (int i = 0; i < size; i++) {
                data[index][i] = Integer.valueOf(stringLine[i]);
            }
            index++;

        } while (scanner.hasNextLine());
        return data;
    }

}
