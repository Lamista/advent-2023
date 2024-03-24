package org.example.adventofcode2023;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.example.adventofcode2023.TestUtils.assertLongListEqualsInAnyOrder;
import static org.example.adventofcode2023.TestUtils.assertStringListEqualsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

class Day3_2Test {
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

    List<String> input2 = List.of(
            ".......5......",
            "..7*..*.......",
            "...*13*.......",
            ".......15....."
    );

    List<String> input3 = List.of(
            ".....24.*23.",
            "..10........",
            "..397*.610..",
            ".......50...",
            "1*2..4......"
    );

    Map<String, List<Integer>> gearLocationsAndValues = Map.of(
            "13", List.of(467, 35),
            "43", List.of(617),
            "85", List.of(755, 598)
    );

    @Test
    void test_hasAdjacentGearSymbol() {
        assertFalse(Day3_2.hasAdjacentGearSymbol(0, 0, input));
        assertFalse(Day3_2.hasAdjacentGearSymbol(0, 1, input));
        assertTrue(Day3_2.hasAdjacentGearSymbol(0, 2, input));
        assertFalse(Day3_2.hasAdjacentGearSymbol(9, 1, input));
        assertFalse(Day3_2.hasAdjacentGearSymbol(9, 2, input));
        assertFalse(Day3_2.hasAdjacentGearSymbol(9, 3, input));
    }

    @Test
    void test_getNumbersAdjacentToGearSymbol() {
        assertStringListEqualsInAnyOrder(
                List.of("13", "43", "85"),
                Day3_2.getNumbersAdjacentToGearSymbol(input).keySet().stream().toList());
        assertArrayEquals(new int[]{467, 35}, Day3_2.getNumbersAdjacentToGearSymbol(input).get("13").stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{617}, Day3_2.getNumbersAdjacentToGearSymbol(input).get("43").stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{755, 598}, Day3_2.getNumbersAdjacentToGearSymbol(input).get("85").stream().mapToInt(i -> i).toArray());
    }

    @Test
    void test_getNumbersAdjacentToGearSymbol2() {
        Map<String, List<Integer>> res = Day3_2.getNumbersAdjacentToGearSymbol(input2);
        assertStringListEqualsInAnyOrder(List.of("13", "16", "23", "26"),
                res.keySet().stream().toList());
        assertArrayEquals(new int[]{7, 13}, res.get("13").stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{5, 13}, res.get("16").stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{7, 13}, res.get("23").stream().mapToInt(i -> i).toArray());
        assertArrayEquals(new int[]{13, 15}, res.get("26").stream().mapToInt(i -> i).toArray());
    }

    @Test
    void test_getNumbersAdjacentToGearSymbol3() {
        Map<String, List<Integer>> res = Day3_2.getNumbersAdjacentToGearSymbol(input3);
        assertStringListEqualsInAnyOrder(List.of("41", "08", "25"),
                res.keySet().stream().toList());
        assertArrayEquals(new int[]{1,2}, res.get("41").stream().mapToInt(i -> i).toArray());
    }

    @Test
    void test_getRatiosOfNumbersAdjacentToGearSymbol() {
        assertLongListEqualsInAnyOrder(List.of(16345l, 451490l), Day3_2.getRatiosOfNumbersAdjacentToGearSymbol(gearLocationsAndValues));
    }

    @Test
    void test_getSumOfRatioOfNumbersAdjacentToGearSymbol() {
        assertEquals(467835, Day3_2.getSumOfRatioOfNumbersAdjacentToGearSymbol(input));
    }


}