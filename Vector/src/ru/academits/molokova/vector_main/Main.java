package ru.academits.molokova.vector_main;

import ru.academits.molokova.vector.Vector;

import static ru.academits.molokova.vector.Vector.*;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(5);
        System.out.println("Первый вектор: " + vector1);

        double[] array1 = {1.8, 6.5, 9.3};
        Vector vector2 = new Vector(array1);
        System.out.println("Второй вектор: " + vector2);

        Vector vector3 = new Vector(5, array1);
        System.out.println("Третий вектор: " + vector3);

        Vector vector4 = new Vector(vector3);
        System.out.println("Четвертый вектор: " + vector4);

        double[] array2 = {2.3, 1.5, 4.7, 11.5};
        Vector vector5 = new Vector(4, array2);
        System.out.println("Пятый вектор: " + vector5);

        System.out.println("Размерность второго веткора: " + vector2.getSize());

        vector2.add(vector5);
        System.out.println("Если ко второму вектору прибавить пятый вектор, то " + vector2);

        vector5.subtract(vector2);
        System.out.println("Если из пятого вектора вычесть второй, то " + vector5);

        System.out.println("Длина пятого вектора: " + vector5.getVectorLength());

        System.out.println("Второй компонент третьего вектора: " + vector3.getComponent(2));

        vector1.setComponent(3, 5.7);
        System.out.println("Первый вектор: " + vector1);

        vector2.turnVector();
        System.out.println("Развернутый второй вектор: " + vector2);

        Vector vector6 = getAddition(vector2, vector5);
        System.out.println("Вектор 6 (результат сложения 2 и 5 вектора): " + vector6);

        System.out.println("Вектор 7 (результат вычитания 5 и 6 вектора): " + getSubtraction(vector5, vector6));

        System.out.println("Скалярное произведение второго и третьего векторов: " + getScalarProduct(vector2, vector3));
    }
}