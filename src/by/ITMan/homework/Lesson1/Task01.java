package by.ITMan.homework.Lesson1;

/*  1) Task1 Вводиться целое число x (-10 ^ 9 <= x <= 10 ^ 9)
    Программа должна вывести even, если число четное. Или odd, если нечетное.
    Примеры:
    2019
    odd
*/

public class Task01 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);

        if (x % 2 == 0) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }
}
