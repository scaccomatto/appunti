package com.paru.dynamicDrogramming;


import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdditionSubmatrix {

    private final static Logger LOGGER = Logger.getLogger(AdditionSubmatrix.class.getName());
    //private final static Logger LOGGER = Logger.getLogger(Solution.class.getName());

    public static void main(String[] args) {
        String input = "2\n" +
                "5 6\n" +
                "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30\n" +
                "3 4 4 5\n" +
                "3 3\n" +
                "9 8 7 4 2 1 6 5 3\n" +
                "1 2 3 3";

        try (Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)))) {
            //try (Scanner scanner = new Scanner(System.in)) {
            int testNumber = scanner.nextInt();

            for(int i=0; i<testNumber;i++){
                int rowSize = scanner.nextInt();
                int colSize = scanner.nextInt();
                int[][] matrix = new int[rowSize][colSize];
                for(int row=0;row<rowSize;row++){
                    for(int col=0;col<colSize;col++){
                        matrix[row][col]=scanner.nextInt();
                    }
                }

                int topLeftRow = scanner.nextInt()-1;
                int topLeftCol = scanner.nextInt()-1;
                int bottomRightRow = scanner.nextInt()-1;
                int bottomRightCol = scanner.nextInt()-1;

                System.out.println(calculateSumSubMatrix(topLeftRow, topLeftCol,bottomRightRow,bottomRightCol, matrix , rowSize, colSize));
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private static int calculateSumSubMatrix(int topLeftRow, int topLeftCol,int bottomRightRow,int bottomRightCol, int[][] matrix, int rowSixe, int colSize) {

        int startSubMatrixRow = topLeftRow;
        int endSubMatrixRow = bottomRightRow;
        int startSubMatrixCol = topLeftCol;
        int endSubMatrixCol = bottomRightCol;

        int sum = 0;

        for(int row = startSubMatrixRow; row <=endSubMatrixRow;row++ ){
            for(int col = startSubMatrixCol; col<=endSubMatrixCol;col++){
                sum = sum + matrix[row][col];
            }
        }
        return sum;
    }
}
