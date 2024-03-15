package org.example.adventofcode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public List<String> getStringListFromFile(String fileName) {
        List<String> list = new ArrayList<>();
        File inputFile = new File(fileName);
        Scanner reader = null;
        try {
            reader = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (reader.hasNextLine()) {
            String value = reader.nextLine();
            list.add(value);
        }
        return list;
    }
}
