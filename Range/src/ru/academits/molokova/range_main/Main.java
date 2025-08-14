package ru.academits.molokova.range_main;

import java.util.Scanner;

import ru.academits.molokova.range.Range;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начальное значение первого интервала:");
        double range1From = scanner.nextDouble();

        System.out.println("Введите конечное значение первого интервала:");
        double range1To = scanner.nextDouble();

        System.out.println("Введите начальное значение второго интервала:");
        double range2From = scanner.nextDouble();

        System.out.println("Введите конечное значение второго интервала:");
        double range2To = scanner.nextDouble();

        System.out.println("Введите число для проверки принадлежности указанным интервалам:");
        double number = scanner.nextDouble();

        Range range1 = new Range(range1From, range1To);
        Range range2 = new Range(range2From, range2To);

        System.out.printf("Длина первого интервала: %.2f%nДлина второго интервала: %.2f%n%n", range1.getLength(), range2.getLength());

        if (range1.isInside(number)) {
            System.out.println("Ваше число принадлежит первому интервалу.");
        } else {
            System.out.println("Ваше число не принадлежит первому интервалу.");
        }

        if (range2.isInside(number)) {
            System.out.println("Ваше число принадлежит второму интервалу.");
        } else {
            System.out.println("Ваше число не принадлежит второму интервалу.");
        }

        System.out.println();

        Range intersection = range1.getIntersection(range2);

        if (intersection != null) {
            System.out.println("Пересечение интервалов: [" + intersection.getFrom() + ", " + intersection.getTo() + "]");
        } else {
            System.out.println("Пересечений нет.");
        }

        Range[] union = range1.getUnion(range2);
        System.out.print("Объединение интервалов: ");

        for (Range range : union) {
            System.out.print("[" + range.getFrom() + ", " + range.getTo() + "]");
        }

        System.out.println();

        Range[] Difference1 = range1.getDifference(range2);

        if (Difference1.length != 0) {
            System.out.print("Разность интервалов: ");

            for (Range range : Difference1) {
                System.out.print("[" + range.getFrom() + ", " + range.getTo() + "]");
            }
        } else {
            System.out.println("В результате операции разности получается пустое множество,т.к. первый интервал входит во второй. Попробуем из второго интервала вычесть первый.");

            range1.setFrom(range2From);
            range1.setTo(range2To);
            range2.setFrom(range1From);
            range2.setTo(range1To);

            Range[] Difference2 = range1.getDifference(range2);
            System.out.print("Разность интервалов: ");

            for (Range range : Difference2) {
                System.out.print("[" + range.getFrom() + ", " + range.getTo() + "]");
            }
        }
    }
}