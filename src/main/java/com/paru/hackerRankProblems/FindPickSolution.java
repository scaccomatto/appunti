package com.paru.hackerRankProblems;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FindPickSolution {

    private final static Logger LOGGER = Logger.getLogger(FindPickSolution.class.getName());
    //private final static Logger LOGGER = Logger.getLogger(Solution.class.getName());

    public static void main(String[] args) {
        String input = "3\n" +
                "11\n" +
                "1 2 3 4 5 6 5 4 3 2 1\n" +
                "9\n" +
                "1 9 8 7 6 5 4 3 1 \n" +
                "9\n" +
                "1 3 4 5 7 8 9 5 2 ";

        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {
            //try (Scanner scanner = new Scanner(System.in)) {

            int numberTest = scanner.nextInt();

            for (int i = 0; i < numberTest; i++) {
                int totNumber = scanner.nextInt();
                int[] numbers = new int[totNumber];

                for (int j = 0; j < totNumber; j++) {
                    numbers[j] = scanner.nextInt();
                }

                System.out.println(findHighestN(numbers));

            }

            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    //this is a O(n) solution

    private static int findHighestN(int[] numbers) {
        int max = Integer.MIN_VALUE;

        if (numbers.length == 1) {
            return numbers[0];
        }

        for (int j = 1; j < numbers.length - 1; j++) {
            if (numbers[j] > numbers[j - 1] && numbers[j] > numbers[j + 1]) {
                return numbers[j];
            }
        }
        if (numbers[0] > numbers[1]) {
            return numbers[0];
        }
        if (numbers[numbers.length - 1] > numbers[numbers.length - 2])
            return numbers[numbers.length - 1];

        return 0;
    }

    //this is O(log n) solution
    private static int findHighest(int[] numbers) {

        boolean found = false;
        int target = Integer.MIN_VALUE;

        int end = numbers.length;
        int start = 0;
        while (!found) {

            target = (end + start) / 2;
            if (numbers[target] > numbers[target - 1] && numbers[target] > numbers[target + 1]) {
                found = true;
            } else if (numbers[target] < numbers[target + 1]) {
                start = target;
            } else {
                end = target;
            }
        }

        return numbers[target];
    }
}
