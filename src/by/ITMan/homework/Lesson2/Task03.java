package by.ITMan.homework.Lesson2;

import java.util.Arrays;
import java.util.Random;

public class Task03 {

    // CPU:     O(n^2)
    // Memory:  O(n)
    public static int[] createModifiedArray(int[] a) {
        int[] clonedArray = new int[a.length];
        int[] resultArray = new int[a.length / 2];

        for (int i = 0; i < a.length; i++) {
            clonedArray[i] = a[i];
        }

        boolean oneMore = true;

        while (oneMore) {
            oneMore = false;

            for (int i = 0; i < clonedArray.length - 1; i++) {
                if (clonedArray[i] > clonedArray[i + 1]) {
                    int temp = clonedArray[i];
                    clonedArray[i] = clonedArray[i + 1];
                    clonedArray[i + 1] = temp;

                    oneMore = true;
                }
            }
        }

        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = clonedArray[i] + clonedArray[clonedArray.length - 1 - i];
        }

        return resultArray;
    }
}
