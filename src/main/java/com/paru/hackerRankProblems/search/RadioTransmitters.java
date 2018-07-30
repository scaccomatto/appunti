package com.paru.hackerRankProblems.search;

import com.paru.hackerRankProblems.SolutionTemplate;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RadioTransmitters {

    private final static Logger LOGGER = Logger.getLogger(RadioTransmitters.class.getName());
    //private final static Logger LOGGER = Logger.getLogger(Solution.class.getName());

    public static void main(String[] args) {
        String input = "8 2\n" +
                "7 2 4 6 5 9 12 11";


        try (Scanner in = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {
            //try (Scanner scanner = new Scanner(System.in)) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] x = new int[n];
            List<Integer> homes = new ArrayList();
            for (int x_i = 0; x_i < n; x_i++) {
                x[x_i] = in.nextInt();
                homes.add(x[x_i]);
            }


            int coverage = 0;
            int radios = 0;

            if (x.length == 1) {
                System.out.println(1);
                return;
            }

            Collections.sort(homes);

            for (int j = 0; j < homes.size(); j++) {

                if (coverage < homes.get(j)) {
                    int dx = dx(homes, j);
                    int sx = sx(homes, j);

                    if (sx <= k & j != 0) {
                        if (coverage <= homes.get(j - 1)) {
                            radios++;
                            coverage = homes.get(j) + k;
                            // System.out.println("sx="+homes.get(j));
                        }
                    } else if ((dx > k) || (j == homes.size() - 1)) {
                        radios++;
                        coverage = homes.get(j) + k;
                        //System.out.println("dx="+homes.get(j));
                    }

                }
            }
            System.out.println(radios);
        }
    }

    private static int dx(List<Integer> array, int index) {
        if (index + 1 == array.size()) {
            return 0;
        } else {
            return Integer.sum(array.get(index + 1), -array.get(index));

        }
    }

    private static int sx(List<Integer> array, int index) {
        if (index == 0) {
            return 0;
        } else {
            return Integer.sum(array.get(index), -array.get(index - 1));
        }
    }

}
