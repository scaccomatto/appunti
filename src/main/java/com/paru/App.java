package com.paru;

import com.paru.dynamicDrogramming.KnapsackProblem;

import java.util.Scanner;
import java.util.logging.Logger;

public class App {

    private final static Logger LOGGER = Logger.getLogger(App.class.getName());
    private final static int inputParameterExpected = 2;

    public static void main(String[] args) {

        startInputScanner(args);
    }

    private static void startInputScanner(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("please insert more then " + inputParameterExpected + " parameters");
                args = getInputParameters(scanner, args);
            } while (args.length < inputParameterExpected);


        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            e.printStackTrace();
        }
    }

    private static String[] getInputParameters(Scanner scanner, String[] args) {
        System.out.print("Enter your input: ");
        String username = scanner.next();

        System.out.print("Enter your number: ");
        int age = scanner.nextInt();

        System.out.println(String.format("%s, your number is %d", username, age));

        return new String[]{username, String.valueOf(age)};
    }
}
