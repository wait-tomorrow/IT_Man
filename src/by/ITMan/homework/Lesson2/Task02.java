package by.ITMan.homework.Lesson2;

import java.util.Random;

public class Task02 {
    public static void main(String[] args) {
        int[][] matrix = createMatrix(3);

        printMatrix(matrix);
        System.out.println(calculateDiagsDifferece(matrix));
    }

    public static int calculateDiagsDifferece(int[][] matrix) {
        int diagSum1 = 0;
        int diagSum2 = 0;
        int matrixSize = matrix.length;

        for (int i = 0; i < matrixSize; i++) {
            diagSum1 = diagSum1 + matrix[i][i];
            diagSum2 = diagSum2 + matrix[i][matrixSize-i-1];
        }

        return diagSum1 - diagSum2;
    }

    public static int[][] createMatrix(int size) {
        int[][] matrix = new int[size][size];
        Random r = new Random(System.currentTimeMillis());

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = r.nextInt(20) - 10;
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%5d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
