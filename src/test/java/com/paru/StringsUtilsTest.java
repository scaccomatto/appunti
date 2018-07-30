package com.paru;


import com.paru.stringsUtils.RegexPatterns;
import com.paru.stringsUtils.StringsUtils;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

public class StringsUtilsTest {

    @Test
    public void printResultMatchFromRegex() {

        String input = "Reya is is the the best player in eye eye game";
        String regex = "[aeiou]";

        List<String> output = StringsUtils.matchStringRegex(regex, input);
        output.forEach(s -> System.out.println(s));
    }

    @Test
    public void printListStringSeparatedBySpace() {

        String input = "I want a list where all the words are displayed one by one";

        List<String> output = StringsUtils.matchStringRegex(RegexPatterns.WORD, input);

        output.forEach(s -> System.out.println(s + "|"));
    }

    @Test
    public void printStreamSeparatedBySpace() {
        String input = "I want a list where all the words are displayed one by one";
        Stream st = StringsUtils.getStreamOfStringFromRegex(RegexPatterns.SPACE, input);
        st.forEach(s -> System.out.println(s + "|"));
    }
}
