package ru.academits.molokova.array_main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListHome {
    public static ArrayList<Integer> getOddArrayList(ArrayList<Integer> numbersList) {
        for (int i = numbersList.size() - 1; i >= 0; i--) {
            if (numbersList.get(i) % 2 == 0) {
                numbersList.remove(i);
            }
        }

        return numbersList;
    }

    public static ArrayList<Integer> removeDuplication(ArrayList<Integer> numbersList) {
        ArrayList<Integer> newNumbersList = new ArrayList<>(numbersList.size());

        for (Integer number : numbersList) {
            if (!newNumbersList.contains(number)) {
                newNumbersList.add(number);
            }
        }

        return newNumbersList;
    }

    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        System.out.println("Содержимое файла: " + lines);

        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 5, 8, 7, 3, 2, 6, 9, 4, 5, 3, 9));

        System.out.println("Исходный список чисел: " + numbersList);

        System.out.println("Список после удаления четных чисел: " + getOddArrayList(numbersList));

        System.out.println("Новый список без повторяющихся элементов: " + removeDuplication(numbersList));
    }
}