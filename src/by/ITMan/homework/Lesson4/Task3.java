package by.ITMan.homework.Lesson4;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] errors = new int[n];
        int[] errorsAfterFirstFix = new int[n - 1];
        int[] errorsAfterSecondFix = new int[n - 2];

        for (int i = 0; i < errors.length; i++) {
            errors[i] = sc.nextInt();
        }

        for (int i = 0; i < errorsAfterFirstFix.length; i++) {
            errorsAfterFirstFix[i] = sc.nextInt();
        }

        for (int i = 0; i < errorsAfterSecondFix.length; i++) {
            errorsAfterSecondFix[i] = sc.nextInt();
        }

        long[] result = findFixedErrors(n, errors, errorsAfterFirstFix, errorsAfterSecondFix);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    // CPU:     O(n)
    // Memory:  O(1)
    public static long[] findFixedErrors(int errorsCount, int[] errors, int[] errorsAfterFirstFix, int[] errorsAfterSecondFix) {
        long[] fixedErrors = new long[2];
        long errorsSum = 0;
        long errors1 = 0;
        long errors2 = 0;

        for (int i = 0; i < errorsCount; i++) {
            errorsSum = errorsSum + (long) errors[i];
        }

        for (int afterFirstFix : errorsAfterFirstFix) {
            errors1 = errors1 + (long) afterFirstFix;
        }

        for (int afterSecondFix : errorsAfterSecondFix) {
            errors2 = errors2 + (long) afterSecondFix;
        }

        fixedErrors[0] = errorsSum - errors1;
        fixedErrors[1] = errors1 - errors2;

        return fixedErrors;
    }
}
