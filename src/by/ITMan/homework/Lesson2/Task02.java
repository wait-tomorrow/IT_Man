package by.ITMan.homework.Lesson2;

import java.util.Random;

public class Task02 {

    // CPU      O(n)
    // Memory:  O(1)
    public static int calculateDiagsDifferece(int[][] matrix) {
        int diagSum1 = 0;
        int diagSum2 = 0;
        int matrixSize = matrix.length;

        for (int i = 0; i < matrixSize; i++) {
            diagSum1 = diagSum1 + matrix[i][i];
            diagSum2 = diagSum2 + matrix[i][matrixSize - i - 1];
        }

        return diagSum1 - diagSum2;
    }
}
