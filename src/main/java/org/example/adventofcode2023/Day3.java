package org.example.adventofcode2023;

import java.util.ArrayList;
import java.util.List;

import static org.example.adventofcode2023.Utils.getSum;

public class Day3 {
    public static int getSumOfNumbersAdjacentToSymbol(List<String> input) {
        return getSum(getNumbersAdjacentToSymbol(input));
    }

    public static List<Integer> getNumbersAdjacentToSymbol(List<String> input) {
        List<Integer> nums = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        boolean hasAdjacent = false;

        for (int i = 0, size = input.size(); i < size; i++) {
            for (int j = 0, length = input.get(0).length(); j < length; j++) {
                char current = input.get(i).charAt(j);
                if (Character.isDigit(current)) {
                    number.append(current);
                    if (!hasAdjacent) {
                        hasAdjacent = hasAdjacentSymbol(i, j, input);
                    }
                } else {
                    if (!number.isEmpty() && hasAdjacent) {
                        nums.add(Integer.valueOf(number.toString()));
                        hasAdjacent = false;
                    }
                    number = new StringBuilder();
                }
            }
        }
        return nums;
    }

    public static boolean hasAdjacentSymbol(int row, int col, List<String> input) {
        return
                // row above
                check(row - 1, col - 1, input)
                        || check(row - 1, col, input)
                        || check(row - 1, col + 1, input)
                        // current row
                        || check(row, col - 1, input)
                        || check(row, col + 1, input)
                        // row after
                        || check(row + 1, col - 1, input)
                        || check(row + 1, col, input)
                        || check(row + 1, col + 1, input);
    }

    private static boolean check(int row, int col, List<String> input) {
        if (row < 0 || row >= input.size() || col < 0 || col >= input.get(0).length()) {
            return false;
        }
        char current = input.get(row).charAt(col);

        if (Character.isDigit(current) || current == '.') {
            return false;
        }
        return true;
    }
}
