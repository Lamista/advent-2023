package org.example.adventofcode2023;

import java.util.*;

import static org.example.adventofcode2023.Utils.getLongSum;
import static org.example.adventofcode2023.Utils.getSum;

public class Day3_2 {
    static Set<String> gearLocations = new HashSet<>();

    public static long getSumOfRatioOfNumbersAdjacentToGearSymbol(List<String> input) {
        Map<String, List<Integer>> gearLocationsAndValues = getNumbersAdjacentToGearSymbol(input);
        return getLongSum(getRatiosOfNumbersAdjacentToGearSymbol(gearLocationsAndValues));
    }

    public static List<Long> getRatiosOfNumbersAdjacentToGearSymbol(Map<String, List<Integer>> gearsAndNumbers) {
        List<Long> ratios = new ArrayList<>();
        for (String key : gearsAndNumbers.keySet()) {
            List<Integer> numbers = gearsAndNumbers.get(key);
            if (numbers.size() != 2) continue;
            ratios.add((long) numbers.get(0) * numbers.get(1));
        }
        return ratios;
    }

    public static Map<String, List<Integer>> getNumbersAdjacentToGearSymbol(List<String> input) {
        Map<String, List<Integer>> gears = new HashMap<>();
        StringBuilder number = new StringBuilder();

        for (int i = 0, size = input.size(); i < size; i++) {
            for (int j = 0, length = input.get(0).length(); j < length; j++) {
                char current = input.get(i).charAt(j);
                if (Character.isDigit(current)) {
                    number.append(current);
                    hasAdjacentGearSymbol(i, j, input);
                } else {
                    if (!number.isEmpty() && !gearLocations.isEmpty()) {
                        for (String location : gearLocations) {
                            gears.putIfAbsent(location, new ArrayList<>());
                            gears.get(location).add(Integer.valueOf(number.toString()));
                        }
                        gearLocations = new HashSet<>();
                    }
                    number = new StringBuilder();
                }
            }
        }
        return gears;
    }

    public static boolean hasAdjacentGearSymbol(int row, int col, List<String> input) {
        return
                // row above
                check(row - 1, col - 1, input)
                        | check(row - 1, col, input)
                        | check(row - 1, col + 1, input)
                        // current row
                        | check(row, col - 1, input)
                        | check(row, col + 1, input)
                        // row after
                        | check(row + 1, col - 1, input)
                        | check(row + 1, col, input)
                        | check(row + 1, col + 1, input);
    }

    private static boolean check(int row, int col, List<String> input) {
        if (row < 0 || row >= input.size() || col < 0 || col >= input.get(0).length()) {
            return false;
        }
        char current = input.get(row).charAt(col);
        if (current == '*') {
            gearLocations.add("row" + row + "col" + col);
            return true;
        }
        return false;
    }
}
