package ru.academits.molokova.range_main;

import java.util.Scanner;

import ru.academits.molokova.range.Range;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начальное значение первого интервала:");
        double rangeFrom1 = scanner.nextDouble();

        System.out.println("Введите конечное значение первого интервала:");
        double rangeTo1 = scanner.nextDouble();

        System.out.println("Введите начальное значение второго интервала:");
        double rangeFrom2 = scanner.nextDouble();

        System.out.println("Введите конечное значение второго интервала:");
        double rangeTo2 = scanner.nextDouble();

        System.out.println("Введите число для проверки принадлежности указанным интервалам:");
        double number = scanner.nextDouble();

        Range range1 = new Range(rangeFrom1, rangeTo1);
        Range range2 = new Range(rangeFrom2, rangeTo2);

        System.out.printf("Длина первого интервала: %.2f\n", range1.getLength());
        System.out.printf("Длина второго интервала: %.2f", range2.getLength());
        System.out.println();

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

        Range getIntersection = range1.getIntersection(range2);

        if (getIntersection != null) {
            System.out.println("Пересечение интервалов: [" + getIntersection.getFrom() + ", " + getIntersection.getTo() + "]");
        } else {
            System.out.println("Пересечений нет.");
        }

        Range[] getUnion = range1.getUnion(range2);
        System.out.print("Объединение интервалов: ");

        for (Range range : getUnion) {
            System.out.print("[" + range.getFrom() + ", " + range.getTo() + "]");
        }

        System.out.println();

        Range[] getDifference1 = range1.getDifference(range2);

        if (getDifference1.length == 0) {
            System.out.println("Получить разность интервалов невозможно, первый интервал входит во второй. Попробуем из второго интервала вычесть первый.");

            range1.setFrom(rangeFrom2);
            range1.setTo(rangeTo2);
            range2.setFrom(rangeFrom1);
            range2.setTo(rangeTo1);

            Range[] getDifference2 = range1.getDifference(range2);
            System.out.print("Разность интервалов: ");

            for (Range range : getDifference2) {
                System.out.print("[" + range.getFrom() + ", " + range.getTo() + "]");
            }

        } else {
            System.out.print("Разность интервалов: ");

            for (Range range : getDifference1) {
                System.out.print("[" + range.getFrom() + ", " + range.getTo() + "]");
            }
        }
    }
}