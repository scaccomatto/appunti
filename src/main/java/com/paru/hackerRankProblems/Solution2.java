package com.paru.hackerRankProblems;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Solution2 {

    private final static Logger LOGGER = Logger.getLogger(SolutionTemplate.class.getName());
    //private final static Logger LOGGER = Logger.getLogger(Solution.class.getName());

    public static void main(String[] args) {

        String input ="5\n" +
                "Gareth\n" +
                "Alex\n" +
                "June Alex\n" +
                "June Qing\n" +
                "Qing Paul\n" +
                "Qing Gareth";

        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {
            //try (Scanner scanner = new Scanner(System.in)) {
            int total = scanner.nextInt();
            scanner.nextLine();
            String firstEmployed = scanner.nextLine();
            String secondEmployed = scanner.nextLine();

            Employed company1 = new Employed();
            List<String> company = new ArrayList<>();
            int level = 0;
            while(scanner.hasNextLine()){

                String[] line = scanner.nextLine().split("\\s");
                if(!company.contains(line[0])){
                    company.add(level,line[0]);
                    company.add(level*2 + 1,line[1]);
                } else{
                    company.add(level*2 + 2,line[1]);
                }


            }

            System.out.println(findCommonManager(company,company.get(0), firstEmployed,secondEmployed ));

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private static String findCommonManager(List<String> company,String root, String firstEmployed, String secondEmployed){
        int indexFirst = company.indexOf(firstEmployed);
        int indexSecond = company.indexOf(secondEmployed);
        int indexRoot=root.indexOf(secondEmployed);
        if(root==null)
            return null;

        findCommonManager(company,company.get(indexRoot*2 + 1),firstEmployed,secondEmployed);
        findCommonManager(company,company.get(indexRoot*2 + 2),firstEmployed,secondEmployed);

        return null;
    }
}

class Employed{
    private int level;
    private Employed subEmployedLeft;
    private Employed subEmployedRight;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Employed getSubEmployedLeft() {
        return subEmployedLeft;
    }

    public void setSubEmployedLeft(Employed subEmployedLeft) {
        this.subEmployedLeft = subEmployedLeft;
    }

    public Employed getSubEmployedRight() {
        return subEmployedRight;
    }

    public void setSubEmployedRight(Employed subEmployedRight) {
        this.subEmployedRight = subEmployedRight;
    }
}
