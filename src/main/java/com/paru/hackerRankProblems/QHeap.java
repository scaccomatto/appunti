package com.paru.hackerRankProblems;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class QHeap {

    private final static Logger LOGGER = Logger.getLogger(QHeap.class.getName());




    public static void main(String[] args) {
        String test0="22\n" +
                "1 286789035\n" +
                "1 255653921\n" +
                "1 274310529\n" +
                "1 494521015\n" +
                "3\n" +
                "2 255653921\n" +
                "2 286789035\n" +
                "3\n" +
                "1 236295092\n" +
                "1 254828111\n" +
                "2 254828111\n" +
                "1 465995753\n" +
                "1 85886315\n" +
                "1 7959587\n" +
                "1 20842598\n" +
                "2 7959587\n" +
                "3\n" +
                "1 -51159108\n" +
                "3\n" +
                "2 -51159108\n" +
                "3\n" +
                "1 789534713";

        PriorityQueue<Long> prq = new PriorityQueue<Long>();
        try (Scanner scanner = new Scanner(new ByteArrayInputStream(test0.getBytes(StandardCharsets.UTF_8)))) {
        //try (Scanner scanner = new Scanner(System.in)) {
            int queries = scanner.nextInt();

            for (int i = 0; i < queries; i++) {
                int operation = scanner.nextInt();

                switch (operation) {
                    case 1:
                        prq.add(scanner.nextLong());
                        break;
                    case 2:
                        prq.remove(scanner.nextLong());
                        break;
                    case 3:
                        System.out.println(prq.peek());
                        break;
                    default:
                        break;
                }
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
