package by.ITMan.homework.Lesson3;

import java.util.Arrays;

public class Task1 {

    // CPU:     O(1)
    // Memory:  O(1)
    public static String intToBinary(int decNumber) {
        char[] binaryNumber = new char[32];

        for (int i = 0; i < 32; i++) {
            binaryNumber[i] = (char) (((1 << 31 - i & decNumber) >>> 31 - i) + '0');
        }

        return new String(binaryNumber);
    }

    //CPU:      O(1)
    //Memory:   O(1)
    public static int binaryToInt(String binaryNumber) {
        int intNumber = 0;

        for (int i = 0; i < 32; i++) {
            intNumber = intNumber + (binaryNumber.charAt(31 - i) - '0' << i);
        }

        return intNumber;
    }
}
