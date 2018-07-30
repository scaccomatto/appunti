package com.paru.hackerRankProblems;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SolutionTemplate {

    private final static Logger LOGGER = Logger.getLogger(SolutionTemplate.class.getName());
    //private final static Logger LOGGER = Logger.getLogger(Solution.class.getName());

    public static void main(String[] args) {
        String input = "4\n" +
                "aba\n" +
                "xzxb\n" +
                "ab";

        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {
            //try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
