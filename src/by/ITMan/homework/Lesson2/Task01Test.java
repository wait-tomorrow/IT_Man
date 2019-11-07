package by.ITMan.homework.Lesson2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task01Test {

    @Test
    void findSecondMinimalElemBasicTest() {
        int[] array = new int[]{0, 3, 6, 7, 10, 44365, 1, 4, 6, 5, 2};
        int[] clonedArray = array.clone();

        int result = Task01.findSecondMinimalElem(clonedArray);

        assertEquals(1, result);
        assertArrayEquals(array, clonedArray);
    }

    @Test
    void findSecondMinimalElemWhen2th() {
        int[] array = new int[]{0, -1, 8, 3};
        int[] clonedArray = array.clone();

        int result = Task01.findSecondMinimalElem(clonedArray);

        assertEquals(0, result);
        assertArrayEquals(array, clonedArray);
    }

    @Test
    void findSecondMinimalElemWhenFirst() {
        int[] array = new int[]{-5, 18, -1, 0, 8, 3};
        int[] clonedArray = array.clone();

        int result = Task01.findSecondMinimalElem(clonedArray);

        assertEquals(-1, result);
        assertArrayEquals(array, clonedArray);
    }
}