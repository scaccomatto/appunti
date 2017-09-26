package com.paru.hackerRankProblems.stingTests;

import com.paru.hackerRankProblems.SolutionTemplate;
import com.paru.stringsUtils.StringsUtils;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringRegexTags {

    private final static Logger LOGGER = Logger.getLogger(StringRegexTags.class.getName());
    //private final static Logger LOGGER = Logger.getLogger(Solution.class.getName());
    final static String startTag = "^<(\\S+)>";
    String endTag = "</";

    public static void main(String[] args) {
        String input = "4\n" +
                "<h1>Nayeem loves counseling</h1>\n" +
                "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>\n" +
                "<Amee>safat codes like a ninja</amee>\n" +
                "<SA premium>Imtiaz has a secret crush</SA premium>";

        try (Scanner in = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {

            Stack stackTags = new Stack();


            int testCases = Integer.parseInt(in.nextLine());
            while(testCases>0){
                String line = in.nextLine();


                checkTags(line);

                testCases--;
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private static void checkTags(String line){
        List<String> startTags = StringsUtils.matchStringRegex(startTag, line);

        if(startTags.isEmpty() && !line.isEmpty()){
            System.out.println(line);
            return;
        } else {
            String tagEnd = "</"+startTags.get(0).substring(1);

            if(!StringsUtils.matchStringRegex(tagEnd, line).isEmpty()){
                Pattern p = Pattern.compile("[^"+startTags.get(0)+"](.*)[^"+tagEnd+"]");
                Matcher m = p.matcher(line);
                if(m.find()){
                    checkTags(m.group());
                }
            }

        }



    }
}
