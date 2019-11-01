package by.ITMan.homework.Lesson1;

/*  2) Task2 Вводиться год (целое число: как положительное, так и отрицательное - до нашей эры)
    Программа должна вывести век и AD для нашей эры и BC до нашей эры

    Примеры:
    2019
    21AD

    -29
    1BC
*/

public class Task02 {
    public static void main(String[] args) {
        int year = Integer.parseInt(args[0]);
        int century = year / 100;

        if (year < 0) {
            century = -century;
        }

        if (year % 100 != 0) {  // 2000 год - 20 век
            century++;
        }

        if (year > 0) {
            System.out.println(century + "AD");
        } else {
            System.out.println(century + "BC");
        }
    }
}
