package com.paru.stringsUtils;

import java.util.Arrays;
import java.util.stream.Stream;

public class CharAndStings {

    public static void main(String[] args){
        convertFormStringToChar();
        convertStringToStreamCharAndReverse();
    }

    public static void convertFormStringToChar(){
        String test = "test";
        char[] converted = test.toCharArray();

        String revert = new String(converted);
        assert(test.equalsIgnoreCase(revert));
    }

    public static void convertStringToStreamCharAndReverse(){

        String test = "test";
        char[] converted = test.toCharArray();

        System.out.println(test);

        Stream<Character> charStream = test.chars().mapToObj(i->(char)i);
        String backToString = charStream.map(Object::toString).sorted().reduce((a,b)->(a+b)).get();

        System.out.println(backToString);

        System.out.println(converted);
        Arrays.sort(converted);
        System.out.println(converted);

    }


}
