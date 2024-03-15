package org.example.adventofcode2023;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {
    FileReader reader = new FileReader();

    @Test
    void test_readFile() {
        List<String> expectedList = List.of("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet");
        List<String> resultList = reader.getStringListFromFile("src/test/resources/test.txt");

        assertTrue(expectedList.size() == resultList.size());

        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i), resultList.get(i));
        }
    }
}