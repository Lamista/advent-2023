package org.example.adventofcode2023;

import java.util.*;

public class Day4_2 {
    public static int getSumOfAllOfCards(List<String> input) {
        return Arrays.stream(getCountsOfCards(input)).sum();
    }

    private static int[] getCountsOfCards(List<String> input) {
        int[] cardCounts = new int[input.size()];
        for (int i = 0, length = input.size(); i < length; i++) {
            String card = input.get(i);
            count(card, i, cardCounts);
        }
        return cardCounts;
    }

    public static void count(String card, int cardNumber, int[] cardCounts) {
        String[] cardInfoAndCardNumbers = card.split(":");
        String[] winningAndCheckNumbers = cardInfoAndCardNumbers[1].trim().split("[|]");
        List<Integer> winningNumbers = Arrays.stream(winningAndCheckNumbers[0].trim().split(" ")).filter(s -> !s.equals("")).map(Integer::parseInt).toList();
        List<Integer> checkNumbers = Arrays.stream(winningAndCheckNumbers[1].trim().split(" ")).filter(s -> !s.equals("")).map(Integer::parseInt).toList();

        cardCounts[cardNumber]++;
        int matchingCount = getMatchingNumbersCount(winningNumbers, checkNumbers);
        int currentCardCount = cardCounts[cardNumber];

        for (int i = 0, length = cardCounts.length; i < matchingCount && (cardNumber + i + 1) < length; i++) {
            cardCounts[cardNumber + i + 1] += currentCardCount;
        }
    }

    private static int getMatchingNumbersCount(List<Integer> winningNumbers, List<Integer> checkNumbers) {
        int counter = 0;
        for (int num : winningNumbers) {
            if (checkNumbers.contains(num)) {
                counter++;
            }
        }
        return counter;
    }
}
