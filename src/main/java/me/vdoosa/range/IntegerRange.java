package me.vdoosa.range;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class IntegerRange implements Range<Integer> {
    private final int start;
    private final int endInclusive;
    private final int step;

    public IntegerRange(int start, int endInclusive, int step) {
        if (endInclusive < start) {
            throw new IllegalArgumentException(
                    "Expected endInclusive to be >= start"
            );
        }

        if (step <= 0) {
            throw new IllegalArgumentException(
                    "Expected step to be > 0"
            );
        }
        this.start = start;
        this.endInclusive = endInclusive;
        this.step = step;
    }

    private class IntegerRangeIterator implements Iterator<Integer> {

        private int current = start;

        @Override
        public boolean hasNext() {
            return current <= endInclusive;
        }

        @Override
        public Integer next() {
            int result = current;
            // TODO: Handle overflow
            current += step;
            return result;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntegerRangeIterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Objects.requireNonNull(action);
        for (var i : this) {
            action.accept(i);
        }
    }
}
