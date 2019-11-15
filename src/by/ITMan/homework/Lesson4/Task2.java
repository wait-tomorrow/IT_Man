package by.ITMan.homework.Lesson4;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int countStreetLight = sc.nextInt();
        int streetLength = sc.nextInt();

        int[] lights = new int[countStreetLight];

        for (int i = 0; i < lights.length; i++) {
            lights[i] = sc.nextInt();
        }

        System.out.println(calculateMinRadius(lights, streetLength));
    }

    // cpu:     O(N log N)
    // memory:  O(1)
    public static double calculateMinRadius(int[] lights, int streetLength) {
        quickSort(lights, 0, lights.length - 1);
        System.out.println(Arrays.toString(lights));
        int maxSpaceBetweenLights = 0;

        for (int i = 0; i < lights.length - 1; i++) {
            int space = lights[i + 1] - lights[i];

            if (space > maxSpaceBetweenLights) {
                maxSpaceBetweenLights = space;
            }
        }

        //the beginning of the street
        if (lights[0] > maxSpaceBetweenLights) { //lights[0] = lights[0] - 0
            maxSpaceBetweenLights = lights[0];
        }

        //end of the street
        if (streetLength - lights[lights.length - 1] > maxSpaceBetweenLights) {
            maxSpaceBetweenLights = streetLength - lights[lights.length - 1];
        }
        System.out.println(maxSpaceBetweenLights);
        return maxSpaceBetweenLights / 2.0;
    }

    public static void quickSort(int[] a, int l, int r) {
        int m = l + (r - l) / 2;
        if (a[l] > a[m]) {
            int t = a[l];
            a[l] = a[m];
            a[m] = t;
        }
        if (a[l] > a[r]) {
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
        }
        if (a[m] > a[r]) {
            int t = a[r];
            a[r] = a[m];
            a[m] = t;
        }
        int x = a[m];

        int i = l + 1;
        int j = r - 1;
        while (i <= j) {
            while (a[i] < x) {
                i++;
            }
            while (a[j] > x) {
                j--;
            }
            if (i <= j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
                j--;
            }
        }
        if (l < j) {
            quickSort(a, l, j);
        }
        if (i < r) {
            quickSort(a, i, r);
        }
    }
}
