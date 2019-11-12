package by.ITMan.homework.Lesson4;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] errors = new long[n];
        long[] errorsAfterFirstFix = new long[n - 1];
        long[] errorsAfterSecondFix = new long[n - 2];

        for (int i = 0; i < errors.length; i++) {
            errors[i] = sc.nextLong();
        }

        for (int i = 0; i < errorsAfterFirstFix.length; i++) {
            errorsAfterFirstFix[i] = sc.nextLong();
        }

        for (int i = 0; i < errorsAfterSecondFix.length; i++) {
            errorsAfterSecondFix[i] = sc.nextLong();
        }

        long[] result = findFixedErrors(errors, errorsAfterFirstFix, errorsAfterSecondFix);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    // CPU:     O(n)
    // Memory:  O(1)
    public static long[] findFixedErrors(long[] errors, long[] errorsAfterFirstFix, long[] errorsAfterSecondFix) {
        long[] fixedErrors = new long[2];
        long errorsSum = 0;
        long errors1 = 0;
        long errors2 = 0;

        for (long error : errors) {
            errorsSum = errorsSum + error;
        }

        for (long afterFirstFix : errorsAfterFirstFix) {
            errors1 = errors1 + afterFirstFix;
        }

        for (long afterSecondFix : errorsAfterSecondFix) {
            errors2 = errors2 + afterSecondFix;
        }

        fixedErrors[0] = errorsSum - errors1;
        fixedErrors[1] = errors1 - errors2;

        return fixedErrors;
    }
}
