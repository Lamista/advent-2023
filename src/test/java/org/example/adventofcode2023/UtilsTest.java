package org.example.adventofcode2023;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTest {
    @Test
    void test_getSum() {
        assertEquals( 12 + 38 + 15 + 77, Utils.getSum(List.of(12, 38, 15, 77)));
    }
}
