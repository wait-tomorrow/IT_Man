package by.ITMan.homework.Lesson4;

public class Task3 {

    // CPU:     O(n)
    // Memory:  O(n)
    public static long[] findFixedErrors(int errorsCount, int[] errors, int[] errorsAfterFirstFix, int[] errorsAfterSecondFix) {
        long fixedErrors[] = new long[2];
        long errorsSum = 0;
        long errors1 = 0;
        long errors2 = 0;

        for (int i = 0; i < errorsCount; i++) {
            errorsSum = errorsSum + (long) errors[i];
        }

        for (int i = 0; i < errorsAfterFirstFix.length; i++) {
            errors1 = errors1 + (long) errorsAfterFirstFix[i];
        }

        for (int i = 0; i < errorsAfterSecondFix.length; i++) {
            errors2 = errors2 + (long) errorsAfterSecondFix[i];
        }

        fixedErrors[0] = errorsSum - errors1;
        fixedErrors[1] = errors1 - errors2;

        return fixedErrors;
    }
}
