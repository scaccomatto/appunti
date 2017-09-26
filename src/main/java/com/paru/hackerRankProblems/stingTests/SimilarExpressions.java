package com.paru.hackerRankProblems.stingTests;


import com.paru.stringsUtils.RegexPatterns;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SimilarExpressions {

    private final static Logger LOGGER = Logger.getLogger(SimilarExpressions.class.getName());
    //private final static Logger LOGGER = Logger.getLogger(Solution.class.getName());
    private static Character inizioTonda = '(';
    private static Character fineTonda = ')';
    private static Character meno = '-';
    private static Character piu = '+';


    public static void main(String[] args) {
        String input ="5\n" +
                "r+c+a+b+c+d+o\n" +
                "(r+(c+(a+b+c)+d)+o)\n"+

                "-a+b+c\n" +
                "b+c-a\n"+
                "(a-(b-c))\n" +
                "a-b+c\n" +
                "-d+d-p+a\n" +
                "d+a-p-d\n"+
                "a-b-(c-d)\n" +
                "a-b-c-d";
        String input2 ="1\n"+
                "(-(-(-(-(a+b+c)))))\n" +
                "a+b+c";

        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input2.getBytes(StandardCharsets.UTF_8)))) {
            //try (Scanner scanner = new Scanner(System.in)) {

            int testNumber = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < testNumber; i++) {
                String firstExpression = scanner.nextLine();
                String secondExpression = scanner.nextLine();

                String convertedE1 = convertExpression(firstExpression);
                String convertedE2 = convertExpression(secondExpression);
                convertedE1=addingSign(convertedE1);
                convertedE2=addingSign(convertedE2);

//                List<Addendum> a = getAddendumOrdered(convertedE1);
//                List<Addendum> b = getAddendumOrdered(convertedE2);

                String convertedExpressionOrdered=getAddendumOrdered(convertedE1).stream().map(e->e.getSign().toString()+e.getAddendum().toString()).reduce((acc, e) -> acc  + e).get();
                String expressionToMatchOrdered=getAddendumOrdered(convertedE2).stream().map(e->e.getSign().toString()+e.getAddendum().toString()).reduce((acc, e) -> acc  + e).get();

                System.out.println(convertedExpressionOrdered+" "+expressionToMatchOrdered);

                if (convertedExpressionOrdered.equalsIgnoreCase(expressionToMatchOrdered)) {
                    System.out.println("YES");

                } else {
                    System.out.println("NO");
                }
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private static List<Addendum> getAddendumOrdered(String target){
        char[] expression = target.toCharArray();
        List<Addendum> ad = new LinkedList<>();
        for (int j = 0; j < expression.length-1; j++) {
            if(piu.equals(expression[j])||meno.equals(expression[j])){
                ad.add(new Addendum(expression[j], expression[j+1]));
            }
        }
        //Comparator<Addendum> alfabetico = (Addendum c1,Addendum c2)->(c1.getAddendum().compareTo(c2.getAddendum()));
        return ad.stream().sorted().collect(Collectors.toList());
    }

    private static String addingSign(String target){
        if(!target.substring(0,1).equalsIgnoreCase("-")){
            return "+"+target;
        }
        return target;
    }

    private static String convertExpression(String exp) {

        char[] expression = exp.toCharArray();
        Stack<Parentesi> sequence = new Stack<>();

        for (int j = 0; j < expression.length; j++) {

            if (inizioTonda.equals(expression[j])) {
                sequence.push(new Parentesi(expression[j], j));
            } else if (fineTonda.equals(expression[j])) {
                Parentesi start = sequence.pop();
                Character sign = piu;
                if (start.getIndex() - 1 >= 0) {
                    sign = expression[start.getIndex() - 1];
                }

                //modify the sign into that chunk of string
                for (int k = start.getIndex(); k <= j; k++) {
                    if (inizioTonda.equals(expression[k]) || fineTonda.equals(expression[k])) {
                        expression[k] = ' ';
                    } else if(meno.equals(sign)){
                        if (meno.equals(expression[k])) {
                            expression[k] = piu;
                        } else if (piu.equals(expression[k])) {
                            expression[k] = meno;
                        }
                    }
                }

            }
        }

        return new String(expression).replaceAll("\\s", "");
    }
}

class Parentesi {

    private Character contentChar;
    private int index;

    Parentesi(Character contentChar, int i) {
        index = i;
        this.contentChar = contentChar;

    }

    public Character getContentChar() {
        return contentChar;
    }

    public int getIndex() {
        return index;
    }

}

class Addendum implements Comparable<Addendum>{
    private Character sign;
    private Character addendum;

    public Addendum(char sign, Character addendum) {
        this.sign = sign;
        this.addendum = addendum;
    }

    public Character getSign() {
        return sign;
    }

    public Character getAddendum() {
        return addendum;
    }

    @Override
    public int compareTo(Addendum c2) {
        String a =this.getAddendum().toString()+this.getSign().toString();
        String b =c2.getAddendum().toString()+c2.getSign().toString();

        return a.compareTo(b);
    }
}
