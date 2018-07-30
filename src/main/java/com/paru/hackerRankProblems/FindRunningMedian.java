package com.paru.hackerRankProblems;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FindRunningMedian {

    private final static Logger LOGGER = Logger.getLogger(FindRunningMedian.class.getName());

    public static void main(String args[]) throws Exception {
        //List<Double> numbers = new ArrayList();

        //try (Scanner scanner = new Scanner(System.in)) {
        String inputS = "6\n" +
                "12\n" +
                "4\n" +
                "5\n" +
                "3\n" +
                "8\n" +
                "7";
        String input2 = "4\n" +
                "5\n" +
                "15\n" +
                "1 \n" +
                "3";

        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input2.getBytes(StandardCharsets.UTF_8)))) {
            int size = scanner.nextInt();
            List<Integer> list = new ArrayList();

            for (int i = 0; i < size; i++) {
                Integer input = scanner.nextInt();
                list.add(input);
                Collections.sort(list);
                printMedian(list, i + 1);
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private static void printMedian(List<Integer> numbers, int end) {

        //
        int half = end / 2;
        if (end % 2 == 0) {
            //Double sum = (list[half].add(list[half-1])).divide(two);
            Double sum = ((double) numbers.get(half) + (double) numbers.get(half - 1)) / 2.0;
            System.out.println(sum);
        } else {
            System.out.println(numbers.get(half).doubleValue());
        }
    }


    public static void main2(String[] args) {
        String input2 = "4\n" +
                "5\n" +
                "15\n" +
                "1 \n" +
                "3";

        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input2.getBytes(StandardCharsets.UTF_8)))) {
            int size = scanner.nextInt();
            int[] list = new int[size];

            for (int i = 0; i < size; i++) {
                int input = scanner.nextInt();
                list[i] = input;
                Arrays.sort(list);
                printMedian(list, i + 1);
            }

        } catch (Exception e) {

        }
    }

    private void setUp(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.MAX_VALUE;
        }
    }

    private static void insertionSort(int toInsert, int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            if (toInsert < numbers[i]) {
                int temp = numbers[i];
                numbers[i] = toInsert;
            }
        }

    }

    private static void printMedian(int[] numbers, int end) {

        //
        int half = (end - 1) / 2;
        if (end % 2 == 0) {
            //Double sum = (list[half].add(list[half-1])).divide(two);
            int sum = (numbers[half] + numbers[half - 1]) / 2;
            System.out.println(sum);
        } else {
            System.out.println(numbers[half]);
        }
    }
}
