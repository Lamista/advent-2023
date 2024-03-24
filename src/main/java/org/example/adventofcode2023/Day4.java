package org.example.adventofcode2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.adventofcode2023.Utils.getSum;

public class Day4 {
    public static int getSumOfPointsOfCards(List<String> input) {
        return getSum(getPointsOfCards(input));
    }

    private static List<Integer> getPointsOfCards(List<String> input) {
        List<Integer> pointsForCard = new ArrayList<>();
        for (var card : input) {
            pointsForCard.add(getPointsOfCard(card));
        }
        return pointsForCard;
    }

    public static Integer getPointsOfCard(String card) {
        int points = 0;
        String[] cardAndCardNumbers = card.split(":");
        String[] winningAndCheckNumbers = cardAndCardNumbers[1].trim().split("[|]");
        List<Integer> winningNumbers = Arrays.stream(winningAndCheckNumbers[0].trim().split(" ")).filter(s -> !s.equals("")).map(Integer::parseInt).toList();
        List<Integer> checkNumbers = Arrays.stream(winningAndCheckNumbers[1].trim().split(" ")).filter(s -> !s.equals("")).map(Integer::parseInt).toList();
        for (int winningNumber : winningNumbers) {
            if (checkNumbers.contains(winningNumber)) {
                if (points == 0) {
                    points++;
                } else {
                    points *= 2;
                }
            }
        }
        return points;
    }
}
