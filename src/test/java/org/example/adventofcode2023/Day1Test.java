package org.example.adventofcode2023;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {
    Day1 day1 = new Day1();

    @Test
    void test_getNumber() {
        assertEquals(12, day1.getNumber("1abc2"));
        assertEquals(38, day1.getNumber("pqr3stu8vwx"));
        assertEquals(15, day1.getNumber("a1b2c3d4e5f"));
        assertEquals(77, day1.getNumber("treb7uchet"));
    }

    @Test
    void test_getCalibration() {
        assertEquals( 12 + 38 + 15 + 77, day1.getCalibration(List.of("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet")));
        Day1.setReplaceWordsToDigits(true);
        assertEquals( 32 + 38 + 15 + 77, day1.getCalibration(List.of("three1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet")));
        Day1.setReplaceWordsToDigits(false);
        assertEquals( 12 + 38 + 15 + 77, day1.getCalibration(List.of("three1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet")));
    }

    @Test
    void test_replaceWordsToDigits() {
        Day1.setReplaceWordsToDigits(true);
        assertEquals("219", day1.replaceWordsToDigits("two1nine"));
        assertEquals("823", day1.replaceWordsToDigits("eightwothree"));
        assertEquals("123", day1.replaceWordsToDigits("abcone2threexyz"));
        assertEquals("2134", day1.replaceWordsToDigits("xtwone3four"));
        assertEquals("49872", day1.replaceWordsToDigits("4nineeightseven2"));
        assertEquals("18234", day1.replaceWordsToDigits("zoneight234"));
        assertEquals("76", day1.replaceWordsToDigits("7pqrstsixteen"));
    }

    @Test
    void test_getIfNumber() {
        assertEquals( "", day1.getIfNumber("on", 0));
        assertEquals( "1", day1.getIfNumber("one", 0));
        assertEquals( "2", day1.getIfNumber("two", 0));
        assertEquals( "3", day1.getIfNumber("three", 0));
        assertEquals( "4", day1.getIfNumber("four", 0));
        assertEquals( "5", day1.getIfNumber("five", 0));
        assertEquals( "6", day1.getIfNumber("six", 0));
        assertEquals( "7", day1.getIfNumber("seven", 0));
        assertEquals( "8", day1.getIfNumber("eight", 0));
        assertEquals( "9", day1.getIfNumber("nine", 0));
        assertEquals( "0", day1.getIfNumber("zero", 0));
        assertEquals( "2", day1.getIfNumber("twone", 0));
        assertEquals( "1", day1.getIfNumber("twone", 2));
    }

}