package me.vdoosa.range;

import org.junit.jupiter.api.Test;

import javax.tools.DiagnosticCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class IntRangeTest {

    @Test
    void simpleRange() {
        var list = new ArrayList<Integer>();
        for (var num : Range.of(1, 2)) list.add(num);
        assertEquals(List.of(1, 2), list);
    }

    @Test
    void rangeWithStep() {
        var list = new ArrayList<Integer>();
        for (var num : Range.of(2, 4, 2)) list.add(num);
        assertEquals(List.of(2, 4), list);

        list.clear();
        for (var num : Range.of(2, 5, 2)) list.add(num);
        assertEquals(List.of(2, 4), list);
    }

    @Test
    void incorrectArgs() {
        assertThrows(IllegalArgumentException.class, () -> Range.of(1, 0),
                "endInclusive >= start");
        assertThrows(IllegalArgumentException.class, () -> Range.of(1, 2, 0),
                "step > 0");
        assertThrows(IllegalArgumentException.class, () -> Range.of(1,
                2, -1), "step > 0");
    }

    @Test
    void stream() {
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
}
