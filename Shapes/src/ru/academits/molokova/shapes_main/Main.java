package ru.academits.molokova.shapes_main;

import ru.academits.molokova.shapes.*;

import java.util.Arrays;

public class Main {
    public static Shape findMaxAreaFigure(Shape[] shapes) {
        Arrays.sort(shapes, new SortByArea());
        return shapes[shapes.length - 1];
    }

    public static Shape findSecondMaxPerimeterFigure(Shape[] shapes) {
        Arrays.sort(shapes, new SortByPerimeter());
        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{new Square(6), new Rectangle(5, 9), new Triangle(5, 18, 10, 8, 3, 25), new Circle(7), new Rectangle(2, 14), new Triangle(2, 10, 15, 20, 2, 20)};

        System.out.println("Фигура с максимальной площадью: " + (findMaxAreaFigure(shapes)).toString());

        System.out.println();

        System.out.println("Фигура со вторым по величине периметром: " + (findSecondMaxPerimeterFigure(shapes)).toString());
    }
}