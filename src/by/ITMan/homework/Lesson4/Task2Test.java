package by.ITMan.homework.Lesson4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void calculateMinRadius() {
        int streetLength = 15;
        int[] lights = {15, 5, 3, 7, 9, 14, 0};

        double result = Task2.calculateMinRadius(lights, streetLength);

        assertEquals(2.5, result);
    }

    @Test
    void calculateMinRadius2() {
        int streetLength = 5;
        int[] lights = {2, 5};

        double result = Task2.calculateMinRadius(lights, streetLength);

        assertEquals(2.0, result);
    }
}