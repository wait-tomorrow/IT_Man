package by.ITMan.homework.Lesson2;

import java.util.Arrays;
import java.util.Random;

public class Task03 {
    public static void main(String[] args) {
        //int[] a = new int[]{1, 9, 2, 8, 3, 7, 4, 6};
        //int[] a = new int[]{1, 5, 9, 4, 7, 3, 6, 2};
        int[] a = createTestArray();

        long startTime = System.currentTimeMillis();
        int[] b = createModifiedArray(a);

        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println(timeSpent);
    }

    public static int[] createModifiedArray(int[] a) {
        int[] clonedArray = new int[a.length];
        int[] resultArray = new int[a.length / 2];

        //make a copy of array
        for (int i = 0; i < a.length; i++) {
            clonedArray[i] = a[i];
        }

        //do some math
        for (int i = 0; i < resultArray.length; i++) {
            //we got positive numbers in the array so using "-1" is safe
            int min = Integer.MAX_VALUE;
            int minInd = -1;

            int max = 0;
            int maxInd = -1;

            for (int j = 0; j < clonedArray.length; j++) {
                if (clonedArray[j] != -1 && clonedArray[j] < min) {
                    min = clonedArray[j];
                    minInd = j;
                }

                if (clonedArray[j] != -1 && clonedArray[j] > max) {
                    max = clonedArray[j];
                    maxInd = j;
                }
            }

            if (minInd != -1 && maxInd != -1) {
                resultArray[i] = min + max;

                clonedArray[minInd] = -1;
                clonedArray[maxInd] = -1;
            }
        }

        return clonedArray;
    }

    public static int[] createTestArray(){
        int[] a = new int[10000];
        Random rand = new Random(System.currentTimeMillis());

        for(int i =0; i<10000; i++){
            a[i] = rand.nextInt(100);
        }

        return a;
    }
}
