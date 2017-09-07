package com.paru.hackerRankProblems;


import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;


import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MostVisitedCity {

    private final static Logger LOGGER = Logger.getLogger(MostVisitedCity.class.getName());

    public static void main(String[] args) {
        String input = "6\n" +
                "Barcelona\n" +
                "Edinburgh\n" +
                "Barcelona\n" +
                "Miami\n" +
                "Miami\n" +
                "Barcelona";

        String input2="5\n" +
                "Singapore\n" +
                "Bangkok\n" +
                "Singapore\n" +
                "Bangkok\n" +
                "Singapore";

        mapSolution(input);

    }

    private static void mapSolution(String input) {

        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {
            //try (Scanner scanner = new Scanner(System.in)) {
            int sizeList = scanner.nextInt();

            Map<String,Integer> cities = new LinkedHashMap<>();
            for(int i=0; i<sizeList;i++){
                String city = scanner.next();
                if(cities.containsKey(city)){
                    cities.put(city,cities.get(city)+1);
                } else {
                    cities.put(city, 1);
                }
            }
            int max = 0;
            String cityMostVisited ="";

            for(Map.Entry<String,Integer> entry :cities.entrySet()){

                if(entry.getValue()>max){
                    max = entry.getValue();
                    cityMostVisited=entry.getKey();
                }

            }

            System.out.println(cityMostVisited);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }


}

