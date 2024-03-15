package org.example;

import org.example.adventofcode2023.Day1;
import org.example.adventofcode2023.FileReader;

public class Main {
    public static void main(String[] args) {
        FileReader reader = new FileReader();
        System.out.println("Day1 result = " + Day1.getCalibration(reader.getStringListFromFile("src/main/resources/Day1.txt")));
    }
}