package by.ITMan.homework.Lesson2;

public class Task01 {
    public static void main(String[] args) {
        int[] a = new int[]{0, 3, 6, 7, 10, 44365, 1, 4, 6, 5, 2};
        //int[] a = new int[]{0,-1,8,3};

        System.out.println(findSecondMinimalElem(a));
    }

    // CPU: O(n)
    // RAM: O(1)
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
