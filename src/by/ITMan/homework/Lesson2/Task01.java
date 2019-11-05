package by.ITMan.homework.Lesson2;

public class Task01 {

    // CPU:     O(n)
    // Memory:  O(1)
    public static int findSecondMinimalElem(int[] a) {
        int minFirst = Integer.MAX_VALUE;
        int minFirstInd = -1;
        int minSecond = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < minFirst) {
                minSecond = minFirst;
                minFirst = a[i];
                minFirstInd = i;
            }

            if (a[i] <= minSecond && i != minFirstInd) {
                minSecond = a[i];
            }
        }

        return minSecond;
    }
}
