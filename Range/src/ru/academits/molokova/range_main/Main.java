package ru.academits.molokova.range_main;

import java.util.Scanner;

import ru.academits.molokova.range.Range;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начальное значение первого интервала:");
        int rangeStart1 = scanner.nextInt();

        System.out.println("Введите конечное значение первого интервала:");
        int rangeEnd1 = scanner.nextInt();

        System.out.println("Введите начальное значение второго интервала:");
        int rangeStart2 = scanner.nextInt();

        System.out.println("Введите конечное значение второго интервала:");
        int rangeEnd2 = scanner.nextInt();

        Range range1 = new Range(rangeStart1, rangeEnd1);
        Range range2 = new Range(rangeStart2, rangeEnd2);

        Range intersection = range1.intersection(range2);

        if (intersection != null) {
            System.out.println("Пересечение интервалов: [" + intersection.getFrom() + ", " + intersection.getTo() + "]");
        } else {
            System.out.println("Пересечений нет.");
        }

        Range[] union = range1.union(range2);
        System.out.print("Объединение интервалов:");

        for (Range e : union) {
            System.out.print("[" + e.getFrom() + ", " + e.getTo() + "]");
        }

        System.out.println();

        Range[] complement = range1.complement(range2);

        if (complement.length == 0) {
            System.out.println("Получить разность интервалов невозможно.");
        } else {
            System.out.print("Разность интервалов:");

            for (Range e : complement) {
                System.out.print("[" + e.getFrom() + ", " + e.getTo() + "]");
            }
        }
    }
}