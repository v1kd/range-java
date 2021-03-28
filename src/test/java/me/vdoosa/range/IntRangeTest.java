package me.vdoosa.range;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class IntRangeTest {

    @Test
    void simpleRangeInclusive() {
        var list = new ArrayList<Integer>();
        for (var num : Range.of(1, 2)) list.add(num);
        assertEquals(List.of(1, 2), list);
    }

    @Test
    void simpleRangeExclusive() {
        var list = new ArrayList<Integer>();
        for (var num : Range.until(1, 3)) list.add(num);
        assertEquals(List.of(1, 2), list);
    }

    @Test
    void rangeWithStepInclusive() {
        var list = new ArrayList<Integer>();
        for (var num : Range.of(2, 4, 2)) list.add(num);
        assertEquals(List.of(2, 4), list);

        list.clear();
        for (var num : Range.of(2, 5, 2)) list.add(num);
        assertEquals(List.of(2, 4), list);
    }

    @Test
    void rangeWithStepExclusive() {
        var list = new ArrayList<Integer>();
        for (var num : Range.until(2, 6, 2)) list.add(num);
        assertEquals(List.of(2, 4), list);

        list.clear();
        for (var num : Range.until(2, 6, 2)) list.add(num);
        assertEquals(List.of(2, 4), list);
    }

    @Test
    void incorrectArgs() {
        assertThrows(IllegalArgumentException.class, () -> Range.of(1, 2, 0),
                "step > 0");
        assertThrows(IllegalArgumentException.class, () -> Range.of(1,
                2, -1), "step > 0");
    }

    @Test
    void emptyRangeInclusive() {
        var list = new ArrayList<Integer>();
        for (var num: Range.of(10, 1)) list.add(num);
        assertEquals(0, list.size());
    }

    @Test
    void emptyRangeExclusive() {
        var list = new ArrayList<Integer>();
        for (var num: Range.until(10, 1)) list.add(num);
        assertEquals(0, list.size());
    }

    @Test
    void streamInclusive() {
        var list = Range.of(1, 4).stream().collect(Collectors.toList());
        assertEquals(List.of(1, 2, 3, 4), list);

        var filteredList = Range.of(1, 10)
                .stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        assertEquals(List.of(2, 4, 6, 8, 10), filteredList);

        var mappedList = Range.of(1, 4)
                .stream()
                .map(i -> i * 2)
                .collect(Collectors.toList());
        assertEquals(List.of(2, 4, 6, 8), mappedList);
    }

    @Test
    void streamExclusive() {
        var list = Range.until(1, 5).stream().collect(Collectors.toList());
        assertEquals(List.of(1, 2, 3, 4), list);

        var filteredList = Range.until(1, 11)
                .stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        assertEquals(List.of(2, 4, 6, 8, 10), filteredList);

        var mappedList = Range.until(1, 5)
                .stream()
                .map(i -> i * 2)
                .collect(Collectors.toList());
        assertEquals(List.of(2, 4, 6, 8), mappedList);
    }
}
