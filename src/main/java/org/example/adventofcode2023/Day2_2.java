package org.example.adventofcode2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2_2 {
    Day2 day2 = new Day2();

    // fewest possible cubes set, means the max value found in each game
    public Map<String, Integer> findFewestPossibleCubesSet(String game) {
        Map<String, Integer> maxOfEachColor = new HashMap<>(Map.of("red", 0, "green", 0, "blue", 0));
        String[] sets = game.split(";");
        for (var set : sets) {
            for (var subset : set.split(",")) {
                String[] drawInfo = subset.trim().split(" ");
                int number = Integer.parseInt(drawInfo[0]);
                String color = drawInfo[1];
                maxOfEachColor.put(color, Math.max(maxOfEachColor.get(color), number));
            }
        }
        return maxOfEachColor;
    }


    public int findPowerOfFewestPossibleSets(List<Integer> numbers) {
        int res = 1;
        for (int number : numbers) {
            res *= number;
        }
        return res;
    }

    public int findSumOfThePowerOfFewestPossibleSets(List<String> games) {
        List<Integer> fewestPossibleSetsPowers = new ArrayList<>();
        for (String game : games) {
            var gameInfo = day2.splitGameInput(game);
            var colorAndMaxValuesMap = findFewestPossibleCubesSet(gameInfo[1]);
            fewestPossibleSetsPowers.add(
                    findPowerOfFewestPossibleSets(
                            colorAndMaxValuesMap.values().stream().toList()));
        }
        return Utils.getSum(fewestPossibleSetsPowers);
    }
}
