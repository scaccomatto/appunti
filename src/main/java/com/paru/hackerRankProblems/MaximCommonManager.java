package com.paru.hackerRankProblems;

        import java.io.ByteArrayInputStream;
        import java.nio.charset.StandardCharsets;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.Scanner;
        import java.util.logging.Level;
        import java.util.logging.Logger;
        import java.util.stream.Collectors;

public class MaximCommonManager {

    private final static Logger LOGGER = Logger.getLogger(SolutionTemplate.class.getName());
    //private final static Logger LOGGER = Logger.getLogger(Solution.class.getName());

    public static void main(String[] args) {

        String input ="5\n" +
                "Gareth\n" +
                "Paul\n" +
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

            com.paru.hackerRankProblems.Employed company1 = new com.paru.hackerRankProblems.Employed();
            String[] company = new String[total];
            int level = 0;
            while(scanner.hasNextLine()){

                String[] line = scanner.nextLine().split("\\s");
                String manager = line[0];
                int count =0;
                int managerIndex = findIndex(company, manager);
                if(managerIndex ==-1){
                    company[level]=manager;
                    int j=level*2 + 1;
                    company[j]=line[1];
                    System.out.println("manager:"+line[0]+"left="+j);
                }
                if(company[managerIndex*2 + 1] ==null){
                    company[managerIndex*2 + 1]=line[1];
                }else{
                    company[managerIndex*2 + 2]=line[1];
                }
                level++;
            }

            System.out.println(findCommonManager(company,company[0], firstEmployed,secondEmployed ));

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private static int findIndex(String[]arr, String target) {
        for(int k=0;k<arr.length;k++){
            if(target.equalsIgnoreCase(arr[k])){
                return k;
            }
        }
        return -1;
    }

    private static String findCommonManager(String[] company, String root, String firstEmployed, String secondEmployed){
        int indexFirst = findIndex(company,firstEmployed);
        int indexSecond = findIndex(company,secondEmployed);
        int indexRoot=findIndex(company,root);
        if(root==null)
            return null;

        if(root.equalsIgnoreCase(firstEmployed) || root.equalsIgnoreCase(secondEmployed))
            return root;
        int nextLeft=indexRoot*2 + 1;
        int nextRight=indexRoot*2 + 2;
        findCommonManager(company,company[indexRoot*2 + 1],firstEmployed,secondEmployed);
        findCommonManager(company,company[indexRoot*2 + 2],firstEmployed,secondEmployed);

        if(company[indexRoot*2 + 1]!=null&&company[indexRoot*2 + 2]!=null){
            return root;
        }else if(company[indexRoot*2 + 1]==null&&company[indexRoot*2 + 2]==null){
            return null;
        }else{
            return company[indexRoot*2 + 1]==null?company[indexRoot*2 + 2]:company[indexRoot*2 + 1];
        }
    }
}

class Employed2{
    private int level;
    private com.paru.hackerRankProblems.Employed subEmployedLeft;
    private com.paru.hackerRankProblems.Employed subEmployedRight;
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

    public com.paru.hackerRankProblems.Employed getSubEmployedLeft() {
        return subEmployedLeft;
    }

    public void setSubEmployedLeft(com.paru.hackerRankProblems.Employed subEmployedLeft) {
        this.subEmployedLeft = subEmployedLeft;
    }

    public com.paru.hackerRankProblems.Employed getSubEmployedRight() {
        return subEmployedRight;
    }

    public void setSubEmployedRight(com.paru.hackerRankProblems.Employed subEmployedRight) {
        this.subEmployedRight = subEmployedRight;
    }
}

