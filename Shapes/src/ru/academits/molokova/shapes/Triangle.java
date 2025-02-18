package ru.academits.molokova.shapes;

public class Triangle implements Shape {
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;

    public Triangle(double x1, double x2, double x3, double y1, double y2, double y3) {
        super();
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(x1, Math.max(x2, x3)) - Math.min(x1, Math.min(x2, x3));
    }

    @Override
    public double getHeight() {
        return Math.max(y1, Math.max(y2, y3)) - Math.min(y1, Math.min(y2, y3));
    }

    @Override
    public double getArea() {
        return 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));
    }

    @Override
    public double getPerimeter() {
        double triangleSide1Length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double triangleSide2Length = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        double triangleSide3Length = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));

        return triangleSide1Length + triangleSide2Length + triangleSide3Length;
    }

    @Override
    public String toString() {
        return "Треугольник" + "\n"
                + "Ширина фигуры: " + getWidth() + "\n"
                + "Длина фигуры: " + getHeight() + "\n"
                + "Площадь фигуры: " + getArea() + "\n"
                + "Периметр фигуры: " + getPerimeter();
    }
}