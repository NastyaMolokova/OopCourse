package ru.academits.molokova.range;

public class Range {
    private int from;
    private int to;

    public Range(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public Range intersection(Range other) {
        if (this.to <= other.from || other.to <= this.from) {
            return null;
        }

        return new Range(Math.max(this.from, other.from), Math.min(this.to, other.to));
    }

    public Range[] union(Range other) {
        if (this.to < other.from || other.to < this.from) {
            return new Range[]{new Range(this.from, this.to), new Range(other.from, other.to)};
        }

        return new Range[]{new Range(Math.min(this.from, other.from), Math.max(this.to, other.to))};
    }

    public Range[] complement(Range other) {
        if (this.from >= other.from && this.to <= other.to) {
            return new Range[0];
        } else if (this.to < other.from) {
            return new Range[]{new Range(this.from, this.to)};
        } else if (this.from < other.from && this.to > other.to) {
            return new Range[]{new Range(this.from, other.from - 1), new Range(other.to + 1, this.to)};
        } else if (this.from < other.from) {
            return new Range[]{new Range(this.from, other.from - 1)};
        }

        return new Range[]{new Range(other.to + 1, this.to)};
    }
}