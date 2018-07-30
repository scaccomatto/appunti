package com.paru.stringsUtils;

import java.util.Arrays;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharAndStings {

    private static Logger logger = LoggerFactory.getLogger( CharAndStings.class );


    public static String convertFormStringToCharBackToString(String test) {

        char[] converted = test.toCharArray();
        String revert = new String(converted);

        assert (test.equalsIgnoreCase(revert));

        return revert;
    }

    public static void convertStringToStreamCharAndReverse(String test) {

        Stream<Character> charStream = test.chars().mapToObj(i -> (char) i);
        String backToString = charStream.map(Object::toString).sorted().reduce((a, b) -> (a + b)).get();

        logger.info("original string: {} and the converted one sorted: {}", test ,backToString);


    }


}
