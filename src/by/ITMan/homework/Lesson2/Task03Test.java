package by.ITMan.homework.Lesson2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task03Test {

    @Test
    void createModifiedArrayTest1() {
        int[] array = new int[]{1, 9, 2, 8, 3, 7, 4, 6};
        int[] clonedArray = array.clone();

        int[] result = Task03.createModifiedArray(clonedArray);

        assertArrayEquals(new int[]{10, 10, 10, 10}, result);
        assertArrayEquals(array, clonedArray);
    }

    @Test
    void createModifiedArrayTestNegativeNumbers1() {
        int[] array = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
        int[] clonedArray = array.clone();

        int[] result = Task03.createModifiedArray(clonedArray);

        assertArrayEquals(new int[]{-2, -2, -2, -2}, result);
        assertArrayEquals(array, clonedArray);
    }

    @Test
    void createModifiedArrayTestNegativeNumbers2() {
        int[] array = new int[]{-1000, 10, 1100, -1100, 900, -2200, 5, 800, 500, -400};
        int[] clonedArray = array.clone();

        int[] result = Task03.createModifiedArray(clonedArray);

        assertArrayEquals(new int[]{-1100, -200, -200, 100, 15}, result);
        assertArrayEquals(array, clonedArray);
    }
}