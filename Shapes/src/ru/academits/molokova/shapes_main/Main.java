package ru.academits.molokova.shapes_main;

import ru.academits.molokova.comparator.ShapeAreaComparator;
import ru.academits.molokova.comparator.ShapePerimeterComparator;
import ru.academits.molokova.shapes.*;

import java.util.Arrays;

public class Main {
    public static Shape getMaxAreaShape(Shape[] shapes) {
        Arrays.sort(shapes, new ShapeAreaComparator());
        return shapes[shapes.length - 1];
    }

    public static Shape getSecondMaxPerimeterShape(Shape[] shapes) {
        Arrays.sort(shapes, new ShapePerimeterComparator());
        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(6),
                new Rectangle(5, 9),
                new Triangle(5, 8, 18, 3, 10, 25),
                new Circle(7),
                new Rectangle(2, 14),
                new Triangle(2, 20, 10, 2, 15, 20)
        };

        System.out.println("Фигура с максимальной площадью: " + getMaxAreaShape(shapes));
        System.out.println("Фигура со вторым по величине периметром: " + getSecondMaxPerimeterShape(shapes));
    }
}