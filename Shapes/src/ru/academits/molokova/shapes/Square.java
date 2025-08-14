package ru.academits.molokova.shapes;

public class Square implements Shape {
    private double sideLength;

    public Square(double length) {
        checkSideLength(length);
        sideLength = length;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        checkSideLength(sideLength);
        this.sideLength = sideLength;
    }

    private void checkSideLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Длина стороны квадрата должна быть > 0. Длина: " + length);
        }
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
        return String.format("Квадрат%nСторона квадрата: %.1f%nШирина: %.1f%nДлина: %.1f%nПлощадь: %.2f%nПериметр: %.2f%n",
                sideLength, getWidth(), getHeight(), getArea(), getPerimeter());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Square square = (Square) o;
        return sideLength == square.sideLength;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(sideLength);
        return hash;
    }
}