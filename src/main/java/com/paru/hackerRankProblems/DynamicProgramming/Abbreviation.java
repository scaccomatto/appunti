package com.paru.hackerRankProblems.DynamicProgramming;


import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Abbreviation {


    public static void main(String[] args) {

        String input = "10\n" +
                "Pi\n" +
                "P\n" +
                "AfPZN\n" +
                "APZNC\n" +
                "LDJAN\n" +
                "LJJM\n" +
                "UMKFW\n" +
                "UMKFW\n" +
                "KXzQ\n" +
                "K\n" +
                "LIT\n" +
                "LIT\n" +
                "QYCH\n" +
                "QYCH\n" +
                "DFIQG\n" +
                "DFIQG\n" +
                "sYOCa\n" +
                "YOCN\n" +
                "JHMWY\n" +
                "HUVPW";

        //Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String a = in.next();
            String b = in.next();
            String result = abbreviation(a, b);
            System.out.println(result);
        }
        in.close();
    }

    static String abbreviation(String a, String b) {
        String toTest = a.toUpperCase();
        if (b.length() > a.length())
            return "NO";

        final Map<Character, Integer> stringToTest = new LinkedHashMap<>();
        final Map<Character, Integer> stringTarget = new LinkedHashMap<>();

        char[] toTestArray = toTest.toCharArray();
        char[] targetArray = b.toCharArray();

        for (int i = 0; i < a.length(); i++) {
            updateMap(toTestArray[i], stringToTest);
        }

        for (int i = 0; i < b.length(); i++) {
            updateMap(targetArray[i], stringTarget);
        }

        for (Map.Entry<Character, Integer> entry : stringTarget.entrySet()) {
            if (!(stringToTest.containsKey(entry.getKey()) && stringToTest.get(entry.getKey()).equals(stringTarget.get(entry.getKey())))) {
                return "NO";
            }
        }
        return "YES";
    }

    static void updateMap(Character c, Map<Character, Integer> map) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
    }
}
