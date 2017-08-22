package com.paru.hackerRankProblems;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;



import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class SparseArrays {

    private final static Logger LOGGER = Logger.getLogger(SparseArrays.class.getName());

    public static void main(String[] args) {



        String input = "4\n" +
                "aba\n" +
                "baba\n" +
                "aba\n" +
                "xzxb\n" +
                "3\n" +
                "aba\n" +
                "xzxb\n" +
                "ab";

        StringBuilder strings = new StringBuilder();
        List<String> queries = new LinkedList<>();
        // try (Scanner scanner = new Scanner(System.in)) {
        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {

            setUp(strings, queries, scanner);

            List<String> regexQueries = queries.stream().map(s -> "\\b"+s+"\\b").collect(Collectors.toList());

            for(String r: regexQueries){
                Pattern pattern = Pattern.compile(r, CASE_INSENSITIVE);

                Matcher match = pattern.matcher(strings.toString());
                int count = 0;
                while(match.find()){
                    count++;
                }
                System.out.println(count);
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private static void setUp(StringBuilder strings, List<String> queries, Scanner scanner) {

        int totalStrings = scanner.nextInt();
        for (int i = 0; i < totalStrings; i++) {
            strings.append(scanner.next()).append(" ");
        }
        int totalQueries = scanner.nextInt();
        for (int i = 0; i < totalQueries; i++) {
            queries.add(scanner.next());
        }
    }
}
