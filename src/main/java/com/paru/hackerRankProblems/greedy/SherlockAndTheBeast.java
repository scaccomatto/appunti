package com.paru.hackerRankProblems.greedy;


import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

//https://www.hackerrank.com/challenges/sherlock-and-the-beast/problem
public class SherlockAndTheBeast {

    private final static Logger LOGGER = Logger.getLogger(SherlockAndTheBeast.class.getName());
    //private final static Logger LOGGER = Logger.getLogger(Solution.class.getName());

    public static void main(String[] args) {
        String input = "4\n" +
                "1\n" +
                "3\n" +
                "5\n" +
                "11";

        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {
            //try (Scanner scanner = new Scanner(System.in)) {

            int testNumber = scanner.nextInt();

            for (int t = 0; t < testNumber; t++) {
                int magicNumber = scanner.nextInt();

                System.out.println(calculateDecentNumber(magicNumber));
            }


        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private static int calculateDecentNumber(int magicNumber) {

        if (magicNumber < 3) {
            return -1;
        }

        int maxNumbersOfPossible5 = (magicNumber / 3) * 3;
        int maxNumbersOfPossible3 = (magicNumber / 5) * 5;
        boolean done = false;

        int number5 = maxNumbersOfPossible5;
        int number3 = maxNumbersOfPossible3;

        while (!done) {
            Integer instancesOf5 = -1;
            Integer instancesOf3 = -1;

            if (number5 > 2) {
                int decentNumberOf5s = calculateDecentNumberPerDigit(5, number5);
                boolean multipleOfThree = isMultipleOfDigit(decentNumberOf5s, 3);
                if (multipleOfThree) {
                    instancesOf5 = decentNumberOf5s;
                    if (number5 == magicNumber) {
                        return decentNumberOf5s;
                    } else {
                        number3 = magicNumber - number5;
                    }
                }
            }

            if (number3 > 4) {
                int decentNumberOf3s = calculateDecentNumberPerDigit(3, number3);
                boolean multipleOfFive = isMultipleOfDigit(decentNumberOf3s, 5);
                if (multipleOfFive) {
                    instancesOf3 = decentNumberOf3s;
                }
            }
            if (number3 + number5 == magicNumber) {
                StringBuilder res = new StringBuilder().append(instancesOf5).append(instancesOf3);
                done = true;
                return Integer.valueOf(res.toString());
            } else {
                number3 = -5;
                number5 = -3;
            }

        }

        return 0;
    }

    private static int calculateDecentNumberPerDigit(int digit, int numberOfTime) {
        if (numberOfTime == 0) {
            return 0;
        }

        StringBuilder digits = new StringBuilder();
        IntStream.range(1, numberOfTime + 1).forEach(i -> digits.append(digit));

        return Integer.valueOf(digits.toString());
    }

    private static boolean isMultipleOfDigit(int number, int digit) {
        return number % digit == 0;
    }
}
