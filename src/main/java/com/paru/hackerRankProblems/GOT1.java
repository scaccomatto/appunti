package com.paru.hackerRankProblems;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GOT1 {

    static String gameOfThrones(String s){
        Map<Character, Integer> letters = new HashMap();
        char[] input = s.toCharArray();
        for(int i=0; i<s.length();i++){
            char target = input[i];
            if(letters.containsKey(target)){
                letters.put(target, letters.get(target)+1);
            } else {
                letters.put(target, 1);
            }
        }

        if(s.length()%2==0){
            //all values must be even
            for(Integer count: letters.values()){
                if(count%2>0){
                    return "NO";
                }
            }
            return "YES";
        } else{
            //there must be 1 odd
            int odd =0;
            for(Integer count: letters.values()){
                if(count%2>0){
                    odd++;
                }
            }
            if(odd==1){
                return "YES";
            } else{
                return "NO";
            }
        }
    }

    public static void main(String[] args) {
        String input = "ab";

        Scanner in = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        String s = in.next();
        String result = gameOfThrones(s);
        System.out.println(result);
    }
}
