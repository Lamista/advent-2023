package org.example.adventofcode2023;

import java.util.List;

public class Utils {
    public static int getSum(List<Integer> integers) {
        return integers.stream().mapToInt(Integer::intValue).sum();
    }
}
