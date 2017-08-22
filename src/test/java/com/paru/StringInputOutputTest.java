package com.paru;

import com.paru.standardInputOutput.StdinStdout;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class StringInputOutputTest {

    @Test
    public void testInput(){

        String input = "primo secondo \n nuova linea";

        StdinStdout.readInputByLine(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
        StdinStdout.readInputByToken(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));

    }
}
