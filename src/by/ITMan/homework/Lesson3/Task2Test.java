package by.ITMan.homework.Lesson3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void countOfDigitOne() {
        int countMaxValue = Task2.countOfDigitOne(Integer.MAX_VALUE);
        int countMinValue = Task2.countOfDigitOne(Integer.MIN_VALUE);
        int countZero = Task2.countOfDigitOne(0);
        int count77 = Task2.countOfDigitOne(77);
        int count_77 = Task2.countOfDigitOne(-77);

        Assertions.assertEquals(31, countMaxValue);
        Assertions.assertEquals(1, countMinValue);
        Assertions.assertEquals(0, countZero);
        Assertions.assertEquals(4, count77);
        Assertions.assertEquals(29, count_77);
    }
}