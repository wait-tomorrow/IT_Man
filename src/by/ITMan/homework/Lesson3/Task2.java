package by.ITMan.homework.Lesson3;

public class Task2 {
    public static int countOfDigitOne(int decNumber) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            count = count + ((1 << 31 - i & decNumber) >>> 31 - i);
        }

        return count;
    }
}
