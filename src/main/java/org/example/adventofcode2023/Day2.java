package org.example.adventofcode2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2 {
    private Map<String, Integer> availableCubes;

    public Map<String, Integer> getAvailableCubes() {
        return availableCubes;
    }

    public void setAvailableCubes(Map<String, Integer> availableCubes) {
        this.availableCubes = availableCubes;
    }

    public boolean isPossibleGame(String game) {
        String[] sets = game.split(";");
        for (var set : sets) {
            for (var subset : set.split(",")) {
                String[] revealInfo = subset.trim().split(" ");
                int number = Integer.parseInt(revealInfo[0]);
                String color = revealInfo[1];
                if (availableCubes.get(color) < number) return false;
            }
        }
        return true;
    }

    public String[] splitGameInput(String gameInput) {
        String[] gameIdAndSets =  gameInput.split(":");
        gameIdAndSets[0] = gameIdAndSets[0].replace("Game ", "");
        return gameIdAndSets;
    }

    public int getPossibleGamesSum(List<String> games) {
        List<Integer> gameIds = new ArrayList<>();
        for (String game : games) {
            var gameInfo = splitGameInput(game);
            if (isPossibleGame(gameInfo[1])) gameIds.add(Integer.parseInt(gameInfo[0]));
        }
        return Utils.getSum(gameIds);
    }
}
