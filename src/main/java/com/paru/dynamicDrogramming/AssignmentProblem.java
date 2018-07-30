package com.paru.dynamicDrogramming;

import com.paru.hackerRankProblems.SolutionTemplate;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

public class AssignmentProblem {

    private final static Logger LOGGER = Logger.getLogger(AssignmentProblem.class.getName());
    //private final static Logger LOGGER = Logger.getLogger(Solution.class.getName());

    public static void main(String[] args) {
        String input = "2\n" +
                "2\n" +
                "3 5 10 1\n" +
                "3\n" +
                "2 1 2 9 8 1 1 1 1";

        String input2 = "1\n" +
                "16\n" +
                "19 22 22 79 31 2 77 47 8 28 9 57 54 81 18 8 2 61 78 98 51 47 63 55 7 93 27 59 49 24 56 27 4 22 70 68 93 75 68 35 68 13 27 80 29 87 9 72 36 87 60 76 5 98 5 37 50 29 52 73 18 17 77 95 87 68 9 9 29 94 93 28 25 65 62 50 73 77 22 92 1 71 94 71 71 36 36 20 66 88 95 76 23 39 84 73 96 28 19 50 54 81 31 67 50 2 34 65 22 77 16 51 100 24 30 17 27 45 54 60 14 43 29 6 50 66 80 43 43 93 23 52 13 54 7 87 95 18 70 100 40 77 40 30 53 16 60 68 19 48 88 37 73 86 69 10 13 74 26 84 88 9 14 18 51 38 44 52 27 34 39 40 95 6 66 35 97 29 49 16 57 3 17 96 37 29 37 81 94 42 73 33 75 34 31 65 44 25 20 19 68 21 48 19 83 96 57 37 78 72 41 63 19 40 50 44 81 4 61 22 8 55 98 88 29 52 51 87 4 78 35 75 49 73 50 44 69 14 66 33 33 37 11 95 80 88 82 46 97 62 14 13 67 33 97 47 \n";

        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input2.getBytes(StandardCharsets.UTF_8)))) {
            //try (Scanner scanner = new Scanner(System.in)) {
            int testsNumber = scanner.nextInt();

            for (int i = 0; i < testsNumber; i++) {
                int totEmployers = scanner.nextInt();
                int[][] jobsMatrix = new int[totEmployers][totEmployers];

                int[] assigned = new int[totEmployers];
                int[] employeeWeight = new int[totEmployers];
                setUp(assigned);

                for (int empl = 0; empl < totEmployers; empl++) {
                    for (int j = 0; j < totEmployers; j++) {
                        jobsMatrix[empl][j] = scanner.nextInt();
                        employeeWeight[empl] = employeeWeight[empl] + jobsMatrix[empl][j];
                    }
                }

                Set<Integer> employers = IntStream.range(0, totEmployers).mapToObj(Integer::new).collect(Collectors.toSet());
                Set<Integer> jobs = IntStream.range(0, totEmployers).mapToObj(Integer::new).collect(Collectors.toSet());

                setUp(assigned);

                while (!employers.isEmpty()) {
                    findMinIntoMatrix(jobsMatrix, employers, jobs, assigned, employeeWeight);
                }
                System.out.println(Arrays.stream(assigned).sum());

            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private static void findMinIntoMatrix(int[][] jobsMatrix, Set<Integer> employers, Set<Integer> jobs, int[] assigned, int[] employeeWeight) {

        Integer minEmployee = null;
        Integer minJob = Integer.MAX_VALUE;

        for (Integer employee : employers) {
            for (Integer job : jobs) {
                if (jobsMatrix[employee][job] < minJob) {
                    minJob = jobsMatrix[employee][job];
                    minEmployee = employee;
                } else if (jobsMatrix[employee][job] == minJob) {
                    if (employeeWeight[employee] < employeeWeight[minEmployee]) {
                        minJob = jobsMatrix[employee][job];
                        minEmployee = employee;
                    }
                }
            }
        }
        employers.remove(minEmployee);
        jobs.remove(minJob);
        System.out.println("Found employee=" + minEmployee + " and job=" + minJob);
        assigned[minEmployee] = minJob;
    }

    private static void setUp(int[] assigned) {
        for (int k = 0; k < assigned.length; k++) {
            assigned[k] = -1;
        }
    }

}
