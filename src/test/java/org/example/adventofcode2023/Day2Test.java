package org.example.adventofcode2023;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {
    Day2 day2;
    @BeforeEach
    void setUp() {
        day2 = new Day2();
        Map<String, Integer> availableCubes = Map.of("red", 12, "green", 13, "blue", 14);
        day2.setAvailableCubes(availableCubes);
    }

    @Test
    void test_isPossible() {
        assertTrue(day2.isPossibleGame(" 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
        assertTrue(day2.isPossibleGame(" 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"));
        assertFalse(day2.isPossibleGame(" 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"));
        assertFalse(day2.isPossibleGame(" 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"));
        assertTrue(day2.isPossibleGame(" 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"));
    }

    @Test
    void test_splitGameInput() {
        String[] result = day2.splitGameInput("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green");
        String[] result2 = day2.splitGameInput("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue");
        assertEquals("1", result[0]);
        assertEquals(" 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green", result[1]);
        assertEquals("2", result2[0]);
        assertEquals(" 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue", result2[1]);
    }

    @Test
    void test_getPossibleGamesSum() {
        assertEquals( 8, day2.getPossibleGamesSum(List.of(
                "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green")));
    }
}