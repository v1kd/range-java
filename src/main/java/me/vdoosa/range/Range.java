package me.vdoosa.range;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface Range<T> extends Iterable<T> {

    static Range<Integer> of(int start, int endInclusive) {
        return new IntegerRange(start, endInclusive, 1);
    }

    static Range<Integer> of(int start, int endInclusive, int step) {
        return new IntegerRange(start, endInclusive, step);
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
