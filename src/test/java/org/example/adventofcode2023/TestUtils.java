package org.example.adventofcode2023;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUtils {
    public static void assertStringListEqualsInAnyOrder(List<String> expected, List<String> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual));
        assertTrue(actual.containsAll(expected));
    }

    public static void assertIntListEqualsInAnyOrder(List<Integer> expected, List<Integer> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual));
        assertTrue(actual.containsAll(expected));
    }

    public static void assertLongListEqualsInAnyOrder(List<Long> expected, List<Long> actual) {
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual));
        assertTrue(actual.containsAll(expected));
    }
}
