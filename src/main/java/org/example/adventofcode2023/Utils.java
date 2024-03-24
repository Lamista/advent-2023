package org.example.adventofcode2023;

import java.util.List;

public class Utils {
    public static int getSum(List<Integer> integers) {
        return integers.stream().mapToInt(Integer::intValue).sum();
    }

    public static long getLongSum(List<Long> longs) {
        return longs.stream().mapToLong(Long::longValue).sum();
    }

    public static void printIntList(List<Integer> nums) {
        for (var num : nums) {
            System.out.println(num);
        }
    }
}
