package ru.academits.molokova.shapes;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public String toString() {
        return "Прямоугольник" + "\n"
                + "Ширина фигуры: " + getWidth() + "\n"
                + "Длина фигуры: " + getHeight() + "\n"
                + "Площадь фигуры: " + getArea() + "\n"
                + "Периметр фигуры: " + getPerimeter();
    }
}