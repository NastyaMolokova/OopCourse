package ru.academits.molokova.shapes;

public class Square implements Shape {
    private double sideLength;

    public Square(double length) {
        super();
        this.sideLength = length;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return sideLength * 4;
    }

    @Override
    public String toString() {
        return "Квадрат" + "\n"
                + "Ширина фигуры: " + getWidth() + "\n"
                + "Длина фигуры: " + getHeight() + "\n"
                + "Площадь фигуры: " + getArea() + "\n"
                + "Периметр фигуры: " + getPerimeter();
    }
}