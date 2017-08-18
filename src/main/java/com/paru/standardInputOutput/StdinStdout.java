package com.paru.standardInputOutput;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StdinStdout {
    private final static Logger LOGGER = Logger.getLogger(StdinStdout.class.getName());


    public static void readInputByLine(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {

            while(scanner.hasNextLine()){
                System.out.println(scanner.next());
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
