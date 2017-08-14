package com.paru.stringsUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class StringsUtils {




    public static List<String> matchStringRegex(String regex, String input){

        Pattern pattern = Pattern.compile(regex, CASE_INSENSITIVE);

        Matcher match = pattern.matcher(input);
        List<String>  results = new LinkedList<>();

        while(match.find()){
            results.add(match.group());
        }
        return results;
    }
}
