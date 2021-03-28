package me.vdoosa.range;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IntRangeTest {

    @Test
    void intRange() {
        var list = new ArrayList<Integer>();
        for (var num : Range.of(1, 2)) list.add(num);
        assertEquals(List.of(1, 2), list);
    }

    @Test
    void intRangeWithStep() {
        var list = new ArrayList<Integer>();
        for (var num : Range.of(2, 4, 2)) list.add(num);
        assertEquals(List.of(2, 4), list);

        list.clear();
        for (var num : Range.of(2, 5, 2)) list.add(num);
        assertEquals(List.of(2, 4), list);
    }

    @Test
    void intRangeIncorrectArgs() {
        assertThrows(IllegalArgumentException.class, () -> Range.of(1, 0),
                "endInclusive >= start");
        assertThrows(IllegalArgumentException.class, () -> Range.of(1, 2, 0),
                "step > 0");
        assertThrows(IllegalArgumentException.class, () -> Range.of(1,
                2, -1), "step > 0");
    }
}
