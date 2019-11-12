package by.ITMan.homework.Lesson4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void findFixedErrors() {
        int errorsCount = 5;
        int[] errors = {1, 5, 8, 123, 7};
        int[] errorsAfterFirstFix = {123, 7, 5, 1};
        int[] errorsAfterSecondFix = {5, 1, 7};

        long[] result = Task3.findFixedErrors(errorsCount, errors, errorsAfterFirstFix, errorsAfterSecondFix);

        assertArrayEquals(new long[]{8, 123}, result);
    }

    @Test
    void findFixedErrors2() {
        int errorsCount = 6;
        int[] errors = {1, 4, 3, 3, 5, 7};
        int[] errorsAfterFirstFix = {3, 7, 5, 4, 3};
        int[] errorsAfterSecondFix = {4, 3, 7, 5};

        long[] result = Task3.findFixedErrors(errorsCount, errors, errorsAfterFirstFix, errorsAfterSecondFix);

        assertArrayEquals(new long[]{1, 3}, result);
    }
}