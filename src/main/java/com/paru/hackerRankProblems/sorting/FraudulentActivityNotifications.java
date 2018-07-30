package com.paru.hackerRankProblems.sorting;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem

public class FraudulentActivityNotifications {

    static int activityNotifications(int[] expenditure, int d) {
        // I will consider starting from the element d+1;

        if (d >= expenditure.length)
            return 0;

        int start = 0;
        int end = d - 1;
        int totalNotifications = 0;

        for (int i = d; i < expenditure.length; i++) {
            start = Math.max(d - i, 0);
            end = Math.min(expenditure.length, i) - 1;
            int notification = findMeanSubArray(expenditure, start, end, d, i);
            totalNotifications += notification;

        }

        return totalNotifications;
    }

    private static int findMeanSubArray(int[] expenditure, int start, int end, int d, int i) {
        //int[] toSort = Arrays.copyOfRange(expenditure, start, end+1);
        int[] ordered = new int[end + 1 - start];
        System.arraycopy(expenditure, start, ordered, start, end + 1);
        Arrays.sort(ordered);
        mergeSort(ordered);

        int half = d / 2;
        int sendNotification = 0;
        double median;
        if (d % 2 == 0) {
            median = ((double) ordered[half - 1] + (double) ordered[half]) / 2.0;
        } else {
            median = (double) ordered[half];
        }
        double max = 2.0 * median;
        if ((double) expenditure[i] >= max) {
            sendNotification = 1;
        }

        return sendNotification;
    }

    public static void main(String[] args) {
        String input = "9 5\n" +
                "2 3 4 2 3 6 8 4 5";

        String input2 = "5 4\n" +
                "1 2 3 4 4";

        try (Scanner in = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {
            //try (Scanner scanner = new Scanner(System.in)) {

            int n = in.nextInt();
            int d = in.nextInt();
            int[] expenditure = new int[n];
            for (int expenditure_i = 0; expenditure_i < n; expenditure_i++) {
                expenditure[expenditure_i] = in.nextInt();
            }
            int result = activityNotifications(expenditure, d);
            System.out.println(result);
            in.close();
        }
    }

    static void mergeSort(int[] arrayToSort) {

        Integer[] copy = new Integer[arrayToSort.length];
        mergeSort(0, arrayToSort.length - 1, arrayToSort, copy);

    }

    private static void mergeSort(int start, int end, int[] arrayToSort, Integer[] copy) {
        if (start < end) {
            int middle = (end + start) / 2;

            mergeSort(start, middle, arrayToSort, copy);
            mergeSort(middle + 1, end, arrayToSort, copy);

            merge(start, end, middle, arrayToSort, copy);
        }
    }

    private static void merge(int start, int end, int middle, int[] arrayToSort, Integer[] copy) {

        copyArray(arrayToSort, copy);

        int left = start;
        int right = middle + 1;
        int k = start;

        while (left <= middle && right <= end) {
            if (copy[left] <= copy[right]) {
                arrayToSort[k] = copy[left];
                left++;
            } else {
                arrayToSort[k] = copy[right];
                right++;
            }
            k++;
        }
        while (left <= middle) {
            arrayToSort[k] = copy[left];
            left++;
            k++;
        }

        //System.out.println(" e poi "+ Arrays.toString(arrayToSort));

    }

    private static void copyArray(int[] arrayToSort, Integer[] copy) {
        for (int i = 0; i < arrayToSort.length; i++) {
            copy[i] = arrayToSort[i];
        }
    }
}
