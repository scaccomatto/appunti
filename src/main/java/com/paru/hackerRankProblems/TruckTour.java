package com.paru.hackerRankProblems;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TruckTour {

    private final static Logger LOGGER = Logger.getLogger(TruckTour.class.getName());

    public static void main(String[] args) {
        String input = "3\n" +
                "7 5\n" +
                "1 3\n" +
                "4 4";
        //try (Scanner scanner = new Scanner(System.in)) {
        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {
            int queries = scanner.nextInt();

            List<PetrolPump> pumpsList = new ArrayList<>();
            Queue<PetrolPump> pumps = new ArrayBlockingQueue<PetrolPump>(queries);
            for (int i = 0; i < queries; i++) {
                Long petrol = scanner.nextLong();
                Long next = scanner.nextLong();
                //pumpsList.add(new PetrolPump(i, petrol, next));
                pumps.add(new PetrolPump(Long.valueOf(i) , petrol, next));
            }
            System.out.println(calculatePump(pumps));


        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private static Long calculatePump(Queue<PetrolPump> queue) {


        PetrolPump start = queue.peek();
        Long tank = 0L;
        Long size = Long.valueOf(queue.size());
        PetrolPump target = null;
        Long index = 0L;
        List<PetrolPump> visited = new LinkedList<>();

        while(!queue.isEmpty()&&index<size+1){
            target = queue.poll();
            tank += target.getPetrol();
            //queue.add(target);
            visited.add(target);
            if (tank < target.getNextPetrolPump()) {
                start = queue.peek();
                tank = 0L;
                queue.addAll(visited);
                visited = new ArrayList<>();
            } else{
                tank = tank - target.getNextPetrolPump();
            }
            index++;
        }

        if(queue.isEmpty())
            return   start.getIndex();
        else
            return -1L;

    }

}

class PetrolPump {
    private Long nextPetrolPump;
    private Long petrol;
    private Long index;

    public PetrolPump(Long i, Long petrol, Long next) {
        nextPetrolPump = next;
        this.petrol = petrol;
        index = i;
    }

    public Long getNextPetrolPump() {
        return nextPetrolPump;
    }

    public void setNextPetrolPump(Long nextPetrolPump) {
        this.nextPetrolPump = nextPetrolPump;
    }

    public Long getPetrol() {
        return petrol;
    }

    public void setPetrol(Long petrol) {
        this.petrol = petrol;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }
}