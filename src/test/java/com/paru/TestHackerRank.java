package com.paru;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TestHackerRank {


    @Test
    public void test12() {
        String input = "primo secondo \n nuova linea ";
        int[][] data = null;
        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {

            int size = 0;
            int index = 0;

            do {
                String line = scanner.nextLine().trim();
                Stream streamLine = getStreamOfStringFromRegex("\\s+", line);
                String[] stringLine = line.split("\\s+");
                size = stringLine.length;
                //size = (int)streamLine.count();
                System.out.println(size);
                if (data == null) {
                    data = new int[size][size];
                }

                for (int i = 0; i < size; i++) {
                    ///data[index][i]=Integer.valueOf(stringLine[i]);
                }

                index++;

            } while (scanner.hasNextLine());

            /*for(int j=0;j<size;j++){
                for(int k=0;k<size;k++){
                    System.out.print(data[j][k]+" ");
                }
                System.out.println("");
            }*/
            System.out.println("-----------" + (data.length));

        } catch (Exception e) {
            //LOGGER.log(Level.SEVERE, e.getMessage(), e);
            e.printStackTrace();
            System.out.println("-----------" + (data.length));
        }


    }

    private Stream getStreamOfStringFromRegex(String regex, String input) {

        return Pattern.compile(regex).splitAsStream(input);

    }


}
