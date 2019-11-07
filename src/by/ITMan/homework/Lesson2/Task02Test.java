package by.ITMan.homework.Lesson2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task02Test {

    @Test
    void calculateDiagsDiffereceTest1() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int [][] clonedMatrix = matrix.clone();

        int result = Task02.calculateDiagsDifferece(clonedMatrix);

        assertEquals(0, result);
        assertArrayEquals(matrix, clonedMatrix);
    }

    @Test
    void calculateDiagsDiffereceTest2() {
        int[][] matrix = new int[][]{
                {1, 2, -3},
                {4, -5, 6},
                {7, 8, -9}
        };

        int [][] clonedMatrix = matrix.clone();

        int result = Task02.calculateDiagsDifferece(clonedMatrix);

        assertEquals(-12, result);
        assertArrayEquals(matrix, clonedMatrix);
    }

    @Test
    void calculateDiagsDiffereceTest3() {
        int[][] matrix = new int[][]{
                {10, 2, 5},
                {4, -1, 6},
                {-8, 8, 4}
        };

        int [][] clonedMatrix = matrix.clone();

        int result = Task02.calculateDiagsDifferece(clonedMatrix);

        assertEquals(17, result);
        assertArrayEquals(matrix, clonedMatrix);
    }
}