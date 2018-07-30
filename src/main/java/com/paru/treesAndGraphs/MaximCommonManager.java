package com.paru.treesAndGraphs;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaximCommonManager {

    private final static Logger LOGGER = Logger.getLogger(MaximCommonManager.class.getName());
    //private final static Logger LOGGER = Logger.getLogger(Solution.class.getName());

    public static void main(String[] args) {

        String input = "5\n" +
                "madonna\n" +
                "Gareth\n" +
                "June Alex\n" +
                "June Qing\n" +
                "June Pinco\n" +
                "June Pallino\n" +
                "Qing Paul\n" +
                "Qing Gianni\n" +
                "Gianni madonna\n" +
                "Gianni bastilana\n" +
                "Qing Gareth";

        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {
            //try (Scanner scanner = new Scanner(System.in)) {
            int total = scanner.nextInt();
            scanner.nextLine();
            Employed firstEmployed = new Employed(scanner.nextLine());
            Employed secondEmployed = new Employed(scanner.nextLine());
            Employed company = null;
            while (scanner.hasNextLine()) {

                String[] line = scanner.nextLine().split("\\s");
                Employed manager = new Employed(line[0]);
                Employed employed = new Employed(line[1]);

                if (company == null) {
                    company = manager;
                }
                //in this case it is known that the input will not be empty and
                Employed managerToUpdate = EmployedHelper.findEmployedByNameBFS(company, manager.getName());
                //Employed managerToUpdate = EmployedHelper.findEmployedByNameDFS(company, manager.getName());
                if (managerToUpdate != null) {
                    managerToUpdate.addManagedEmployed(employed);
                }
            }

            List<Employed> firstPath = EmployedHelper.findPath(company, firstEmployed);
            List<Employed> secondPath = EmployedHelper.findPath(company, secondEmployed);


            System.out.print("First: ");
            firstPath.forEach(p -> System.out.print(p.getName() + " "));
            System.out.println();
            System.out.print("Second: ");
            secondPath.forEach(p -> System.out.print(p.getName() + " "));
            System.out.println();

            int maxLength = Math.min(firstPath.size(), secondPath.size());
            Employed commonManager = null;
            for (int i = 0; i < maxLength; i++) {
                if (firstPath.get(i).equals(secondPath.get(i))) {
                    commonManager = firstPath.get(i);
                } else {
                    break;
                }
            }

            System.out.println("common manager is: " + commonManager.getName());

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}

class EmployedHelper {

    static Employed findEmployedByNameBFS(Employed root, String name) {

        //BFS search
        if (root == null)
            return null;

        if (name.equalsIgnoreCase(root.getName())) {
            return root;
        }

        Queue<Employed> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Employed target = queue.remove();
            for (Employed managed : target.getManagedEmployed()) {
                if (name.equalsIgnoreCase(managed.getName())) {
                    return managed;
                } else {
                    queue.add(managed);
                }
            }
        }
        return null;
    }

    static final Employed findEmployedByNameDFS(Employed root, String name) {

        if (root == null)
            return null;

        if (name.equalsIgnoreCase(root.getName())) {
            return root;
        }
        Employed found = null;
        for (Employed managed : root.getManagedEmployed()) {
            found = findEmployedByNameDFS(managed, name);
            if (found != null)
                return found;
        }
        return null;

    }

    public static List<Employed> findPath(Employed root, Employed target) {

        if (root == null)
            return null;

        if (root.equals(target)) {
            List<Employed> path = new LinkedList();
            path.add(root);
            return path;
        }

        for (Employed managed : root.getManagedEmployed()) {

            List<Employed> path = findPath(managed, target);
            if (path != null) {
                path.add(0, root);
                return path;
            }
        }

        return null;
    }
}

class Employed {

    // the name is the id as well...
    private String name;
    private List<Employed> managedEmployed;

    public Employed(String personalName) {
        this.name = personalName;
        managedEmployed = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public List<Employed> getManagedEmployed() {
        return managedEmployed;
    }

    public void addManagedEmployed(Employed managedEmployed) {
        this.managedEmployed.add(managedEmployed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employed)) return false;

        Employed employed = (Employed) o;

        return getName().equals(employed.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
