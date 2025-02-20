package ru.academits.molokova.range_main;

import java.util.Scanner;

import ru.academits.molokova.range.Range;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начальное значение первого интервала:");
        double firstRangeFrom = scanner.nextDouble();

        System.out.println("Введите конечное значение первого интервала:");
        double firstRangeTo = scanner.nextDouble();

        System.out.println("Введите начальное значение второго интервала:");
        double secondRangeFrom = scanner.nextDouble();

        System.out.println("Введите конечное значение второго интервала:");
        double secondRangeTo = scanner.nextDouble();

        System.out.println("Введите число для проверки принадлежности указанным интервалам:");
        double number = scanner.nextDouble();

        Range firstRange = new Range(firstRangeFrom, firstRangeTo);
        Range secondRange = new Range(secondRangeFrom, secondRangeTo);

        System.out.printf("Длина первого интервала: %.2f%nДлина второго интервала: %.2f%n%n", firstRange.getLength(), secondRange.getLength());

        if (firstRange.isInside(number)) {
            System.out.println("Ваше число принадлежит первому интервалу.");
        } else {
            System.out.println("Ваше число не принадлежит первому интервалу.");
        }

        if (secondRange.isInside(number)) {
            System.out.println("Ваше число принадлежит второму интервалу.");
        } else {
            System.out.println("Ваше число не принадлежит второму интервалу.");
        }

        System.out.println();

        Range intersection = firstRange.getIntersection(secondRange);

        if (intersection != null) {
            System.out.println("Пересечение интервалов: [" + intersection.getFrom() + ", " + intersection.getTo() + "]");
        } else {
            System.out.println("Пересечений нет.");
        }

        Range[] union = firstRange.getUnion(secondRange);
        System.out.print("Объединение интервалов: ");

        for (Range range : union) {
            System.out.print("[" + range.getFrom() + ", " + range.getTo() + "]");
        }

        System.out.println();

        Range[] firstDifference = firstRange.getDifference(secondRange);

        if (firstDifference.length == 0) {
            System.out.println("Получить разность интервалов невозможно, первый интервал входит во второй. Попробуем из второго интервала вычесть первый.");

            firstRange.setFrom(secondRangeFrom);
            firstRange.setTo(secondRangeTo);
            secondRange.setFrom(firstRangeFrom);
            secondRange.setTo(firstRangeTo);

            Range[] secondDifference = firstRange.getDifference(secondRange);
            System.out.print("Разность интервалов: ");

            for (Range range : secondDifference) {
                System.out.print("[" + range.getFrom() + ", " + range.getTo() + "]");
            }
        } else {
            System.out.print("Разность интервалов: ");

            for (Range range : firstDifference) {
                System.out.print("[" + range.getFrom() + ", " + range.getTo() + "]");
            }
        }
    }
}