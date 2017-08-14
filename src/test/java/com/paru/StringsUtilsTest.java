package com.paru;


import com.paru.stringsUtils.StringsUtils;
import org.junit.Test;

import java.util.List;

public class StringsUtilsTest {

    @Test
    public void printResultMatchFromRegex(){

        String input = "Reya is is the the best player in eye eye game";
        String regex = "[aeiou]";

        List<String> output = StringsUtils.matchStringRegex(regex, input);
        output.forEach(s-> System.out.println(s));
    }
}
