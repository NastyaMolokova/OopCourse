package ru.academits.molokova.shapes;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Окружность" + "\n"
                + "Ширина фигуры: " + getWidth() + "\n"
                + "Длина фигуры: " + getHeight() + "\n"
                + "Площадь фигуры: " + getArea() + "\n"
                + "Периметр фигуры: " + getPerimeter();
    }
}