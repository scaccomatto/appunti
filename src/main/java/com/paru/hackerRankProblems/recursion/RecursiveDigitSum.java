package com.paru.hackerRankProblems.recursion;

import com.paru.hackerRankProblems.SolutionTemplate;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class RecursiveDigitSum {
    private final static Logger LOGGER = Logger.getLogger(SolutionTemplate.class.getName());
    //private final static Logger LOGGER = Logger.getLogger(Solution.class.getName());

    public static void main(String[] args) {
        String input = "593 10";

        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {
            //try (Scanner scanner = new Scanner(System.in)) {
            String n = scanner.next();
            int k = scanner.nextInt();


            long calc = getSumDigits(n)*k;
            System.out.println(getSuperDigit(calc));

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private static long getSuperDigit(Long calc) {

        if(calc <10)
            return calc;
        String cifre = calc.toString();
        long result = getSumDigits(cifre);


        return getSuperDigit(result);

    }

    private static long getSumDigits(String s) {

        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += Character.digit(s.charAt(i), 10);
        }
        return result;
    }
}
