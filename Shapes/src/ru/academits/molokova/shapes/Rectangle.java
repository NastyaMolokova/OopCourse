package ru.academits.molokova.shapes;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        checkWidth(width);
        checkHeight(height);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        checkWidth(width);
        this.width = width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        checkHeight(height);
        this.height = height;
    }

    private void checkWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Ширина прямоугольника должна быть > 0. Ширина: " + width);
        }
    }

    private void checkHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Длина прямогульника должна быть > 0. Длина: " + height);
        }
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
        return String.format("Прямоугольник%nШирина: %.1f%nДлина: %.1f%nПлощадь: %.2f%nПериметр: %.2f%n",
                width, height, getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) o;
        return width == rectangle.width && height == rectangle.height;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(width);
        hash = prime * hash + Double.hashCode(height);
        return hash;
    }
}