package ru.academits.molokova.shapes;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        checkRadius(radius);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        checkRadius(radius);
        this.radius = radius;
    }

    private void checkRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус окружности должне быть > 0. Радиус: " + radius);
        }
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
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return String.format("Окружность%nРадиус: %.1f%nШирина: %.1f%nДлина: %.1f%nПлощадь: %.2f%nПериметр: %.2f%n",
                radius, getWidth(), getHeight(), getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(radius);
        return hash;
    }
}