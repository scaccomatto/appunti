package com.paru.dynamicDrogramming;

import com.paru.hackerRankProblems.SolutionTemplate;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PermutazioniCombinazioni {

    private final static Logger LOGGER = Logger.getLogger(PermutazioniCombinazioni.class.getName());
    //private final static Logger LOGGER = Logger.getLogger(Solution.class.getName());

    public static void main(String[] args) {
        String input = "a\n" +
                "b\n" +
                "c\n" +
                "d";

        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {
            //try (Scanner scanner = new Scanner(System.in)) {
            List<String> elements = new ArrayList<>();
            while (scanner.hasNext()) {
                elements.add(scanner.next());
            }

            ArrayList<ArrayList<String>> allsubsets = getAllSubsets(elements);
            for (ArrayList<String> list : allsubsets) {
                list.forEach(System.out::print);
                System.out.println("");
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private static ArrayList<ArrayList<String>> getAllSubsets(List<String> elements) {

        return getSubSets(elements, 0);
    }

    private static ArrayList<ArrayList<String>> getSubSets(List<String> set, int index) {
        ArrayList<ArrayList<String>> allSubsets;
        if (set.size() == index) {
            allSubsets = new ArrayList<ArrayList<String>>();
            allSubsets.add(new ArrayList<String>());
        } else {
            allSubsets = getSubSets(set, index + 1);
            String item = set.get(index);
            ArrayList<ArrayList<String>> moreSubsets = new ArrayList<ArrayList<String>>();

            for (ArrayList<String> subSet : allSubsets) {
                ArrayList<String> newSubsets = new ArrayList<String>();
                newSubsets.add(item);
                newSubsets.addAll(subSet);
                moreSubsets.add(newSubsets);

            }
            allSubsets.addAll(moreSubsets);

        }
        return allSubsets;
    }
}
