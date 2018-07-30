package com.paru.hackerRankProblems;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class TestFra {

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


    private static List<List<Integer>> getClosestLocation(int totalCreates, List<List<Integer>> locations, int truckCapacity) {

        Map<Integer, Double> distances = new LinkedHashMap<>();

        for (int i = 0; i < totalCreates; i++) {
            List<Integer> location = locations.get(i);
            int x = location.get(0);
            int y = location.get(1);
            double distance = Math.sqrt((x * x) + (y * y));
            distances.put(i, distance);
        }

        distances = distances.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        final List<List<Integer>> closestLocations = new LinkedList<>();
        distances.keySet()
                .stream()
                .limit(truckCapacity).forEach(index -> {
            closestLocations.add(locations.get(index));
        });

        return closestLocations;
    }

}
