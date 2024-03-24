package org.example.adventofcode2023;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day3Test {
    List<String> input = List.of(
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598.."
    );

    @Test
    void test_getNumbersAdjacentToSymbol() {
        assertArrayEquals(
                new int[]{467, 35, 633, 617, 592, 755, 664, 598},
                Day3.getNumbersAdjacentToSymbol(input).stream().mapToInt(i -> i).toArray()
        );
    }

    @Test
    void test_hasAdjacentSymbol() {
        assertFalse(Day3.hasAdjacentSymbol(0, 0, input));
        assertFalse(Day3.hasAdjacentSymbol(0, 1, input));
        assertTrue(Day3.hasAdjacentSymbol(0, 2, input));
        assertTrue(Day3.hasAdjacentSymbol(9, 5, input));
        assertTrue(Day3.hasAdjacentSymbol(9, 6, input));
        assertFalse(Day3.hasAdjacentSymbol(9, 7, input));
    }

    @Test
    void test_getSumOfNumbersAdjacentToSymbol() {
        assertEquals(4361, Day3.getSumOfNumbersAdjacentToSymbol(input));
    }
}