package org.example.adventofcode2023;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day4_2Test {
    List<String> input = List.of(
            "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
            "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
            "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1",
            "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83",
            "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",
            "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11"
    );

    @Test
    void test_count() {
        int[] cardCounts = new int[input.size()];
        Day4_2.count(input.get(0), 0, cardCounts);
        Day4_2.count(input.get(1), 1, cardCounts);
        Day4_2.count(input.get(2), 2, cardCounts);
        Day4_2.count(input.get(3), 3, cardCounts);
        Day4_2.count(input.get(4), 4, cardCounts);
        Day4_2.count(input.get(5), 5, cardCounts);

        assertEquals(1, cardCounts[0]);
        assertEquals(2, cardCounts[1]);
        assertEquals(4, cardCounts[2]);
        assertEquals(8, cardCounts[3]);
        assertEquals(14, cardCounts[4]);
        assertEquals(1, cardCounts[5]);
    }

    @Test
    void test_getSumOfAllOfCards() {
        assertEquals(30, Day4_2.getSumOfAllOfCards(input));
    }

}