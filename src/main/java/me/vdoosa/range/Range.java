package me.vdoosa.range;

public interface Range<T> extends Iterable<T> {

    static Range<Integer> of(int start, int endInclusive) {
        return new IntegerRange(start, endInclusive, 1);
    }

    static Range<Integer> of(int start, int endInclusive, int step) {
        return new IntegerRange(start, endInclusive, step);
    }
}
