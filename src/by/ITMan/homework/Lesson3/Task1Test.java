package by.ITMan.homework.Lesson3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    void intToBinary() {
        String number77 = Task1.intToBinary(77);
        String number_77 = Task1.intToBinary(-77);
        String numberMaxValue = Task1.intToBinary(Integer.MAX_VALUE);
        String numberMinValue = Task1.intToBinary(Integer.MIN_VALUE);
        String number0 = Task1.intToBinary(0);

        assertEquals("00000000000000000000000001001101", number77);
        assertEquals("11111111111111111111111110110011", number_77);
        assertEquals("01111111111111111111111111111111", numberMaxValue);
        assertEquals("10000000000000000000000000000000", numberMinValue);
        assertEquals("00000000000000000000000000000000", number0);
    }

    @Test
    void binaryToInt() {
        System.out.println(Integer.MAX_VALUE);
        int number77 = Task1.binaryToInt("00000000000000000000000001001101");
        int number_77 = Task1.binaryToInt("11111111111111111111111110110011");
        int numberMaxValue = Task1.binaryToInt("01111111111111111111111111111111");
        int numberMinValue = Task1.binaryToInt("10000000000000000000000000000000");
        int number0 = Task1.binaryToInt("00000000000000000000000000000000");

        assertEquals(77, number77);
        assertEquals(-77, number_77);
//        assertEquals(Integer.MAX_VALUE, numberMaxValue);
        //assertEquals(Integer.MIN_VALUE, numberMinValue);
        //assertEquals(0, number0);
    }
}