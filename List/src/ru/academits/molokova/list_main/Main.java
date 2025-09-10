package ru.academits.molokova.list_main;

import ru.academits.molokova.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(6);
        list.add(1, 5);

        System.out.println("Список " + list);

        System.out.println("Размер списка: " + list.size());
        System.out.println("Первый элемент списка: " + list.getFirst());

        System.out.println("Замена элемента: " + list.set(1, 6));
        System.out.println("Список после замены: " + list);

        System.out.println("Значение элемента по индексу '0': " + list.get(0));

        System.out.println("Удалён элемент по индексу '2': " + list.remove(2));
        System.out.println("Список после удаления: " + list);

        System.out.println("Удалён первый элемент списка: " + list.removeFirst());
        System.out.println("Список после удаления: " + list);

        list.addFirst(9);
        System.out.println("Список после добавления в начало: " + list);

        list.reverse();
        System.out.println("Список после разворота: " + list);

        SinglyLinkedList<Integer> copy = list.copy();
        System.out.println("Копия списка: " + copy);

        System.out.println("Удаление элемента по значению '5': " + copy.removeByValue(5));
        System.out.println("Копия списка после удаления: " + copy);
    }
}