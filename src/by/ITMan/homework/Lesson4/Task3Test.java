package by.ITMan.homework.Lesson4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void findFixedErrors() {
        long[] errors = {1, 5, 8, 123, 7};
        long[] errorsAfterFirstFix = {123, 7, 5, 1};
        long[] errorsAfterSecondFix = {5, 1, 7};

        long[] result = Task3.findFixedErrors(errors, errorsAfterFirstFix, errorsAfterSecondFix);

        assertArrayEquals(new long[]{8, 123}, result);
    }

    @Test
    void findFixedErrors2() {
        long[] errors = {1, 4, 3, 3, 5, 7};
        long[] errorsAfterFirstFix = {3, 7, 5, 4, 3};
        long[] errorsAfterSecondFix = {4, 3, 7, 5};

        long[] result = Task3.findFixedErrors(errors, errorsAfterFirstFix, errorsAfterSecondFix);

        assertArrayEquals(new long[]{1, 3}, result);
    }
}