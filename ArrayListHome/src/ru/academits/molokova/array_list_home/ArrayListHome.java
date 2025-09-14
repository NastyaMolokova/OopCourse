package ru.academits.molokova.array_list_home;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListHome {
    public static void removeEvenNumbers(ArrayList<Integer> numbersList) {
        for (int i = numbersList.size() - 1; i >= 0; i--) {
            if (numbersList.get(i) % 2 == 0) {
                numbersList.remove(i);
            }
        }
    }

    public static <T> ArrayList<T> getUniqueElementsList(ArrayList<T> list) {
        ArrayList<T> result = new ArrayList<>(list.size());

        for (T element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            ArrayList<String> lines = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            System.out.println("Содержимое файла: " + lines);
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден!");
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 5, 8, 7, 3, 2, 6, 9, 4, 5, 3, 9));
        System.out.println("Исходный список чисел: " + numbersList);

        removeEvenNumbers(numbersList);

        System.out.println("Список после удаления четных чисел: " + numbersList);
        System.out.println("Новый список без повторяющихся элементов: " + getUniqueElementsList(numbersList));
    }
}