package by.ITMan.homework.Lesson2;

public class Task01 {

    // CPU:     O(n)
    // Memory:  O(1)
    public static int findSecondMinimalElem(int[] a) {
        int minFirst = Integer.MAX_VALUE;
        int minSecond = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < minFirst) {
                minSecond = minFirst;
                minFirst = a[i];
            } else if (a[i] <= minSecond) {
                minSecond = a[i];
            }
        }

        return minSecond;
    }
}
