package com.paru.hackerRankProblems;

import javafx.collections.transformation.SortedList;

import javax.swing.text.html.HTMLDocument;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedianUpdates {

    private final static Logger LOGGER = Logger.getLogger(MedianUpdates.class.getName());

    public static void main(String[] args) {
        String input = "7  \n" +
                "r 1  \n" +
                "a 1  \n" +
                "a 2  \n" +
                "a 1  \n" +
                "r 1  \n" +
                "r 2  \n" +
                "r 1";
        List<Integer> numbers = new ArrayList();
        Arrays.sort(new List[]{numbers});

        final String add = "a";
        final String remove = "r";
        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {

            int totalOperations = scanner.nextInt();
            for(int i=0; i<totalOperations;i++){
                String operation = scanner.next();
                Integer value = scanner.nextInt();

                switch(operation){
                    case add:
                            numbers.add(value);
                            calculateMedian(numbers);

                        break;
                    case remove:
                        if(!numbers.contains(value)){
                            System.out.println("Wrong!");
                        }else{
                            numbers.remove(value);
                            calculateMedian(numbers);
                        }
                        break;
                    default:
                        break;
                }
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private static void calculateMedian(List<Integer> numbers){
        Collections.sort(numbers);
        int size=numbers.size();
        if(size%2==0 && !numbers.isEmpty()){
            int half = size/2;
            Integer sum = numbers.get(half)+numbers.get(half-1);

            if(sum%2==0){
                System.out.println(sum/2);
            }else{
                Double result = ((double)sum)/2.0;
                System.out.println(result);
            }
        } else if(size%2!=0 && !numbers.isEmpty()){
            int half = size/2;
            Integer first = numbers.get(half);
            System.out.println(first);
        } else {
            System.out.println("Wrong!");
        }
    }

}
