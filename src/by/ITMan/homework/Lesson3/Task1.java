package by.ITMan.homework.Lesson3;

import java.util.Arrays;

public class Task1 {

    // CPU:     O(n)
    // Memory:  O(n)
    public static String intToBinary(int decimalNumber) {
        int[] binaryTemp = new int[32];
        int binaryTempIndexToInsert = 31;
        char[] binaryNumber = new char[32];

        boolean decimalNumberIsPositive = decimalNumber < 0 ? false : true;

        while (decimalNumber != 0) {
            binaryTemp[binaryTempIndexToInsert] = decimalNumber % 2;
            decimalNumber = decimalNumber / 2;

            binaryTempIndexToInsert--;
        }

        if (decimalNumberIsPositive) {
            binaryNumber[0] = '0';
        } else {
            binaryNumber[0] = '1';
        }

        for (int i = 1; i < binaryTemp.length; i++) {
            if (decimalNumberIsPositive) {
                if (binaryTemp[i] == 0) {
                    binaryNumber[i] = '0';
                } else {
                    binaryNumber[i] = '1';
                }
            } else {
                if (binaryTemp[i] == 0) {
                    binaryNumber[i] = '1';
                } else {
                    binaryNumber[i] = '0';
                }
            }
        }

        return new String(binaryNumber);
    }
}
