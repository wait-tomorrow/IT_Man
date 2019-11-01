package by.ITMan.homework.Lesson1;

/*  3) Task3 Вводиться 6 чисел (2 даты) день первой даты, месяц первой даты, год первой даты, день второй даты, месяц второй даты, год второй даты. Гарантируется, что даты будут валидными (т.е присутствовать в календаре)
    Программа должна вывести наибольшую дату в формате dd.mm.yyyy (с ведущими нулями для дня и месяца)

    Примеры:
    1 12 987 1 1 988
    01.01.988

    19 2 2017 20 2 2017
    20.02.2017
*/

public class Task03 {
    public static void main(String[] args) {
        int[] date1 = {Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])};
        int[] date2 = {Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5])};

        int[] maxDate;

        if (date1[2] > date2[2]) {
            maxDate = date1;
        } else if (date1[1] < date2[2]) {
            maxDate = date2;
        } else {

            if (date1[1] > date2[1]) {
                maxDate = date1;
            } else if (date1[1] < date2[1]) {
                maxDate = date2;
            } else {

                if (date1[0] > date2[0]) {
                    maxDate = date1;
                } else if (date1[0] < date2[0]) {
                    maxDate = date2;
                } else {
                    System.out.println("Даты равны!");
                    return;
                }
            }
        }

        if (maxDate[0] < 10) {
            System.out.print("0" + maxDate[0]);
        } else {
            System.out.print(maxDate[0]);
        }

        System.out.print(".");

        if (maxDate[1] < 10) {
            System.out.print("0" + maxDate[1]);
        } else {
            System.out.print(maxDate[1]);
        }

        System.out.print("." + maxDate[2]);
    }
}
