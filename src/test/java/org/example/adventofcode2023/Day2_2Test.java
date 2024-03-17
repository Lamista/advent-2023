package org.example.adventofcode2023;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Day2_2Test {
    Day2_2 day = new Day2_2();

    @Test
    void test_findFewestPossibleCubesSet() {
        Map<String, Integer> result = day.findFewestPossibleCubesSet("3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");

        assertEquals(4, result.get("red"));
        assertEquals(2, result.get("green"));
        assertEquals(6, result.get("blue"));
    }

    @Test
    void test_findPowerOfFewestPossibleSets() {
        assertEquals(48, day.findPowerOfFewestPossibleSets(List.of(4, 2, 6)));
    }

    @Test
    void test_findSumOfThePowerOfFewestPossibleSets() {
        assertEquals(2286, day.findSumOfThePowerOfFewestPossibleSets(List.of(
                "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green")));
    }
}