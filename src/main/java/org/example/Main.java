package org.example;

import org.example.adventofcode2023.Day1;
import org.example.adventofcode2023.Day2;
import org.example.adventofcode2023.Day2_2;
import org.example.adventofcode2023.FileReader;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReader reader = new FileReader();
        Day1.setReplaceWordsToDigits(false);
        System.out.println("Day1 result = " + Day1.getCalibration(reader.getStringListFromFile("src/main/resources/Day1.txt")));
        Day1.setReplaceWordsToDigits(true);
        System.out.println("Day1_2 result = " + Day1.getCalibration(reader.getStringListFromFile("src/main/resources/Day1.txt")));
        Day2 day2 = new Day2();
        day2.setAvailableCubes(Map.of("red", 12, "green", 13, "blue", 14));
        System.out.println("Day2 result = " + day2.getPossibleGamesSum(reader.getStringListFromFile("src/main/resources/Day2.txt")));
        Day2_2 day2_2 = new Day2_2();
        System.out.println("Day2_2 result = " + day2_2.findSumOfThePowerOfFewestPossibleSets(reader.getStringListFromFile("src/main/resources/Day2.txt")));
    }
}