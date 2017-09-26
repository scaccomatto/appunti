package com.paru.java8Stream;


import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static java.util.Comparator.*;

public class ComparatorExamples {

    //
    private static Comparator<DataClass> alphabetic = comparing(DataClass:: getName, nullsLast(naturalOrder()));
    private static Comparator<DataClass> numeric = comparing(DataClass::getNumber, nullsLast(reverseOrder())).reversed();
    private static Comparator<DataClass> alphabeticAndNumeric = comparing(DataClass::getName,
            nullsLast(String.CASE_INSENSITIVE_ORDER.reversed())).thenComparing(DataClass::getNumber, nullsLast(naturalOrder()));



    static Comparator<DataClass> alphabeticOldWay = (DataClass d1, DataClass d2) -> (d1.getName().compareTo(d2.getName()));
    private static Comparator<DataClass> alphabeticAndNumericOldWay = (DataClass d1, DataClass d2) -> {
        int result = d1.getName().compareTo(d2.getName());
        if(result != 0){
            return result;
        } else {
            return d1.getNumber().compareTo(d2.getNumber());
        }
    };



    public static void main(String[] args){

        List<DataClass> test = getList();

        test.forEach(d -> System.out.print(d.getName()+" "));
        System.out.println("");
        System.out.println("Sorting by name");

        test.stream().sorted(alphabetic).forEach(d -> System.out.print(d.toString()+" "));

        System.out.println("");
        System.out.println("Sorting by number");

        test.stream().sorted(numeric).forEach(d -> System.out.print(d.toString()+" "));

        System.out.println("");
        System.out.println("Sorting both");

        test.stream().sorted(alphabeticAndNumeric).forEach(d -> System.out.print(d.toString()+" "));

        Collections.sort(test, new Comparator<DataClass>() {
            @Override
            public int compare(DataClass h1, DataClass h2) {
                return h1.getName().compareTo(h2.getName());
            }
        });

    }

    private static List<DataClass> getList(){
        List<DataClass> n = new LinkedList<>();
        n.add(new DataClass("c",2));
        n.add(new DataClass("b",4));
        n.add(new DataClass("b",1));
        n.add(new DataClass("a",3));
        n.add(new DataClass(null,null));
        return n;
    }

}
class DataClass {// implements Comparable<DataClass>{

    private String name;
    private Integer number;

    public DataClass(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

//    @Override
//    public int compareTo(DataClass o) {
//        return this.getName().compareTo(o.getName());
//    }
}