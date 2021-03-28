package me.vdoosa.range;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface Range<T> extends Iterable<T> {

    static Range<Integer> of(int start, int endInclusive) {
        return of(start, endInclusive, 1);
    }

    static Range<Integer> of(int start, int endInclusive, int step) {
        return new IntegerRange(start, endInclusive, step);
    }

    static Range<Integer> until(int start, int endExclusive) {
        return until(start, endExclusive, 1);
    }

    static Range<Integer> until(int start, int endExclusive, int step) {
        // TODO: Handle underflow
        return new IntegerRange(start, endExclusive - 1, step);
    }

    default Stream<T> stream() {
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(
                        this.iterator(),
                        Spliterator.ORDERED
                ),
                false
        );
    }
}
