package com.paru.hackerRankProblems.search;


//https://www.hackerrank.com/challenges/count-luck/problem


import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountLuck {

    private final static Logger LOGGER = Logger.getLogger(CountLuck.class.getName());
    //private final static Logger LOGGER = Logger.getLogger(Solution.class.getName());

    public static void main(String[] args) {
        String input = "3\n" +
                "2 3\n" +
                "*.M\n" +
                ".X.\n" +
                "1\n" +
                "4 11\n" +
                ".X.X......X\n" +
                ".X*.X.XXX.X\n" +
                ".XX.X.XM...\n" +
                "......XXXX.\n" +
                "3\n" +
                "4 11\n" +
                ".X.X......X\n" +
                ".X*.X.XXX.X\n" +
                ".XX.X.XM...\n" +
                "......XXXX.\n" +
                "4\n";

        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {
            //try (Scanner scanner = new Scanner(System.in)) {

            int totSample = scanner.nextInt();
            for (int k = 0; k < totSample; k++) {

                int n = scanner.nextInt();
                int m = scanner.nextInt();
                String[][] matrix = new String[n][m];
                int[][] visited = new int[n][m];

                int mRow = -1;
                int mCol = -1;

                for (int row = 0; row < n; row++) {
                    String line = scanner.next();
                    char[] inputRow = line.toCharArray();
                    for (int col = 0; col < m; col++) {
                        matrix[row][col] = "" + inputRow[col];
                        if (matrix[row][col].equalsIgnoreCase("M")) {
                            mRow = row;
                            mCol = col;
                        }
                    }
                }
                int guess = scanner.nextInt();

                visited[mRow][mCol] = 1;
                List<Cord> path = findPath(matrix, visited, mRow, mCol, "*", n, m);

                int count = countPossiblePath(path, matrix, n, m);
                if (guess == count) {
                    System.out.println("Impressed");
                } else {
                    System.out.println("Oops!");
                }
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private static int countPossiblePath(List<Cord> path, String[][] matrix, int n, int m) {

        int count = 0;

        for (int j = 0; j < path.size() - 1; j++) {
            Cord now = path.get(j);

            if (now.row + 1 < n && matrix[now.row + 1][now.col].equalsIgnoreCase(".")) {
                Cord temp = new Cord(now.row + 1, now.col);
                if (!path.contains(temp)) {
                    count++;
                    continue;
                }
            }
            if (now.row - 1 >= 0 && matrix[now.row - 1][now.col].equalsIgnoreCase(".")) {
                Cord temp = new Cord(now.row - 1, now.col);
                if (!path.contains(temp)) {
                    count++;
                    continue;
                }
            }
            if (now.col + 1 < m && matrix[now.row][now.col + 1].equalsIgnoreCase(".")) {
                Cord temp = new Cord(now.row, now.col + 1);
                if (!path.contains(temp)) {
                    count++;
                    continue;
                }
            }
            if (now.col - 1 >= 0 && matrix[now.row][now.col - 1].equalsIgnoreCase(".")) {
                Cord temp = new Cord(now.row, now.col - 1);
                if (!path.contains(temp)) {
                    count++;
                    continue;
                }
            }
        }

        return count;
    }

    private static List<Cord> findPath(String[][] matrix, int[][] visited, int row, int col, String target, int n, int m) {
        visited[row][col] = 1;
        //System.out.println(row+ " "+col);
        if (matrix[row][col].equalsIgnoreCase("X"))
            return null;

        if (matrix[row][col].equalsIgnoreCase(target)) {
            List<Cord> path = new LinkedList();
            path.add(new Cord(row, col));
            return path;
        }
        List<Cord> pathUp = null;
        List<Cord> pathDown = null;
        List<Cord> pathRight = null;
        List<Cord> pathLeft = null;

        if (row + 1 < n && visited[row + 1][col] == 0) {
            pathUp = findPath(matrix, visited, row + 1, col, target, n, m);
        }
        if (row - 1 >= 0 && visited[row - 1][col] == 0) {
            pathDown = findPath(matrix, visited, row - 1, col, target, n, m);
        }
        if (col + 1 < m && visited[row][col + 1] == 0) {
            pathRight = findPath(matrix, visited, row, col + 1, target, n, m);
        }
        if (col - 1 >= 0 && visited[row][col - 1] == 0) {
            pathLeft = findPath(matrix, visited, row, col - 1, target, n, m);
        }

        if (pathUp != null) {
            pathUp.add(0, new Cord(row, col));
            return pathUp;
        }
        if (pathDown != null) {
            pathDown.add(0, new Cord(row, col));
            return pathDown;
        }
        if (pathRight != null) {
            pathRight.add(0, new Cord(row, col));
            return pathRight;
        }
        if (pathLeft != null) {
            pathLeft.add(0, new Cord(row, col));
            return pathLeft;
        }

        return null;

    }
}

class Cord {
    public int row;
    public int col;

    Cord(int x, int y) {
        row = x;
        col = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cord)) return false;

        Cord cord = (Cord) o;

        if (row != cord.row) return false;
        return col == cord.col;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }
}
