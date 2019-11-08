package by.ITMan.homework.Lesson3;

import java.util.Arrays;

public class Task1 {

    // CPU:     O(n)
    // Memory:  O(n)
    public static String intToBinary(int decNumber) {
        int binTempIndex = 31;
        char[] binaryNumber = new char[32];

        while (binTempIndex >= 0) {
            binaryNumber[binTempIndex] = (char) (((1 << 31 - binTempIndex & decNumber) >>> 31 - binTempIndex) + 48);
            binTempIndex--;
        }

        return new String(binaryNumber);
    }

    //CPU:      O(n)
    //Memory:   O(1)
    public static int binaryToInt(String binaryNumber) {
        int intNumber = 0;

        for (int i = 0; i < 32; i++) {
            intNumber = intNumber + (binaryNumber.charAt(31 - i) - '0' << i);
        }

        return intNumber;
    }
}
