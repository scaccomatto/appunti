package com.paru.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class SortingOptions {

    public static void main(String[] args){
        int[] toSort1 = new int[]{1,5,8,3,7,89,0};
        sortArray(toSort1);
        System.out.println((Arrays.toString(toSort1)));

        List<Integer> toSort2 = new ArrayList<>();
        toSort2.add(9);
        toSort2.add(59);
        toSort2.add(29);
        toSort2.add(99);
        toSort2.add(19);

        List<Integer> toSort3 = new ArrayList<>();
        toSort3.add(4);
        toSort3.add(2);
        toSort3.add(8);
        toSort3.add(55);
        toSort3.add(0);
        System.out.println(sortListLambda(toSort3));
        List<Integer> orderedList = sortList1(toSort2);
        System.out.println(orderedList);

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(55, "John");
        map.put(22, "Apple");
        map.put(66, "Earl");
        map.put(77, "Pearl");
        map.put(12, "George");
        map.put(6, "Rocky");

        Map<Integer,String> orderedTree = sortMapsWithTreeMap(map);
        System.out.println(orderedTree);
        Map<Integer,String> ordered = sortMapsReversed(map);
        System.out.println(ordered);

    }

    static int[] sortArray(int[] toSort){
        //import java.util.Arrays;
        Arrays.sort(toSort);

        return toSort;
    }

    static <T extends Comparable> List<T> sortList1(List<T> list){
        Collections.sort(list);
        return list;
    }

    static List<Integer> sortListLambda(List<Integer> list){
        return list.stream().sorted().collect(Collectors.toList());
    }

    static Map<Integer,String> sortMapsReversed(Map<Integer,String> mp){
        Map<Integer,String> ordered = new LinkedHashMap<>();
        mp.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEachOrdered(x -> ordered.put(x.getKey(), x.getValue()));

        return ordered;
    }

    static Map<Integer,String> sortMapsWithTreeMap(Map<Integer,String> mp){
        Map<Integer,String> ordered = new TreeMap<>(mp);
        return ordered;
    }
}
