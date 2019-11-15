package by.ITMan.homework.Lesson4;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int[][] notebooks = new int[count][2];

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 2; j++) {
                notebooks[i][j] = sc.nextInt();
            }
        }

        if (isCoolNotebookExists(notebooks)) {
            System.out.println("Happy Alex");
        } else {
            System.out.println("Poor Alex");
        }
    }

    /*  Описание решения:
        У нас n ноутбуков.
        Качество    - диапазон от 1 до n.
        Цена        - диапазон от 1 до n.

        Следовательно, если в списке есть ноутбук, у которого цена не равна качеству,
        то у этого ноутбука будет "пара". И у одного из этих ноутов качество точно будет выше цены.
     */

    // cpu:     O(n)
    // memory:  O(1)
    public static boolean isCoolNotebookExists(int[][] notebooks) {
        for (int[] notebook : notebooks) {
            if (notebook[0] != notebook[1]) {
                return true;
            }
        }

        return false;
    }
}
