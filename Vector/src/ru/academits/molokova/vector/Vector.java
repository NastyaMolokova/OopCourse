package ru.academits.molokova.vector;

import java.util.Arrays;

public class Vector {
    private double[] vector;


    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0.");
        }

        vector = new double[n];
    }

    public Vector(Vector other) {
        vector = Arrays.copyOf(other.vector, other.vector.length);
    }

    public Vector(double[] array) {
        vector = array;
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0.");
        }

        vector = new double[n];
        System.arraycopy(array, 0, vector, 0, Math.min(n, array.length));
    }

    public int getSize() {
        return vector.length;
    }

    public void add(Vector other) {
        int maxLength = Math.max(vector.length, other.vector.length);
        double[] newVector = new double[maxLength];

        for (int i = 0; i < maxLength; i++) {
            double thisVector = (i < vector.length) ? vector[i] : 0;
            double otherVector = (i < other.vector.length) ? other.vector[i] : 0;
            newVector[i] = thisVector + otherVector;
        }

        this.vector = newVector;
    }

    public void subtract(Vector other) {
        int maxLength = Math.max(vector.length, other.vector.length);
        double[] newVector = new double[maxLength];

        for (int i = 0; i < maxLength; i++) {
            double thisVector = (i < vector.length) ? vector[i] : 0;
            double otherVector = (i < other.vector.length) ? other.vector[i] : 0;
            newVector[i] = thisVector - otherVector;
        }

        vector = newVector;
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] *= scalar;
        }
    }

    public void turnVector() {
        multiplyByScalar(-1);
    }

    public double getVectorLength() {
        double sum = 0;
        for (double component : vector) {
            sum += component * component;
        }
        return Math.sqrt(sum);
    }

    public double getComponent(int index) {
        if (index >= 0 && index < vector.length) {
            return vector[index];
        } else {
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за пределы массива компонентов.");
        }
    }

    public void setComponent(int index, double component) {
        if (index >= 0 && index < vector.length) {
            vector[index] = component;
        } else {
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за пределы массива компонентов.");
        }
    }

    public static Vector getAddition(Vector first, Vector second) {
        int maxLength = Math.max(first.vector.length, second.vector.length);
        double[] newVector = new double[maxLength];

        for (int i = 0; i < maxLength; i++) {
            double thisVector = (i < first.vector.length) ? first.vector[i] : 0;
            double otherVector = (i < second.vector.length) ? second.vector[i] : 0;
            newVector[i] = thisVector + otherVector;
        }

        return new Vector(newVector);
    }

    public static Vector getSubtraction(Vector first, Vector second) {
        int maxLength = Math.max(first.vector.length, second.vector.length);
        double[] newVector = new double[maxLength];

        for (int i = 0; i < maxLength; i++) {
            double thisVector = (i < first.vector.length) ? first.vector[i] : 0;
            double otherVector = (i < second.vector.length) ? second.vector[i] : 0;
            newVector[i] = thisVector - otherVector;
        }

        return new Vector(newVector);
    }

    public static double getScalarProduct(Vector first, Vector second) {
        int maxLength = Math.max(first.vector.length, second.vector.length);
        double scalarProduct = 0;

        for (int i = 0; i < maxLength; i++) {
            double thisVector = (i < first.vector.length) ? first.vector[i] : 0;
            double otherVector = (i < second.vector.length) ? second.vector[i] : 0;
            scalarProduct += thisVector * otherVector;
        }

        return scalarProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Vector vector1 = (Vector) o;
        return Arrays.equals(vector, vector1.vector);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(vector);
        return hash;
    }

    @Override
    public String toString() {
        if (vector == null) {
            return "{}";
        }

        return Arrays.toString(vector).replace('[', '{')
                .replace(']', '}');
    }
}