package com.paru.dynamicDrogramming;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HanoiTower {

    private final static Logger LOGGER = Logger.getLogger(HanoiTower.class.getName());
    //private final static Logger LOGGER = Logger.getLogger(Solution.class.getName());

    public static void main(String[] args) {
        String input = "3";

        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {
            //try (Scanner scanner = new Scanner(System.in)) {
            int numberOfTowers = scanner.nextInt();

            Tower[] towers = new Tower[numberOfTowers];
            for(int i=0; i<numberOfTowers; i++){
                towers[i]= new Tower(i);
            }
            // set up

            for(int j =numberOfTowers-1; j>=0;j--){
                towers[0].add(j);
            }
            Arrays.stream(towers).forEach(Tower::printSizeTower);

            towers[0].moveDisks(numberOfTowers, towers[2], towers[1]);

            Arrays.stream(towers).forEach(Tower::printSizeTower);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}

class Tower {

    private Stack<Integer> disks;
    private int index;

    public Tower(int i){
        this.index = i;
        disks = new Stack<>();
    }

    public int getIndex() {
        return index;
    }

    public void add(int i){
        if(!disks.isEmpty() && disks.peek()<=i){
            System.out.println("illegal movment");
        } else {
            disks.push(i);
        }
    }

    public void moveTopTo(Tower t){
        int top = disks.pop();
        t.add(top);
    }

    public void moveDisks(int n, Tower destination, Tower buffer){
        if(n>0){
            moveDisks(n-1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n-1, destination, this);
        }
    }

    public void printSizeTower(){
        System.out.println(disks.size());
    }
}
