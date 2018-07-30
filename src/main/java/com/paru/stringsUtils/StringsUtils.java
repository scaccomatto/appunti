package com.paru.stringsUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class StringsUtils {


    //NB! questo fa lo split con il match della regex(cioe' spazio se spazio, pipe se pipe etc)
    public static Stream getStreamOfStringFromRegex(String regex, String input) {

        return Pattern.compile(regex).splitAsStream(input);

    }

    //NB! questo ritrna la lista della selezione della regex
    public static List<String> matchStringRegex(String regex, String input) {

        Pattern pattern = Pattern.compile(regex, CASE_INSENSITIVE);

        Matcher match = pattern.matcher(input);
        List<String> results = new LinkedList<>();

        while (match.find()) {
            results.add(match.group());
        }

        return results;
    }


}
