package org.example.adventofcode2023;

import java.util.ArrayList;
import java.util.List;

public class Day1 {
    private static boolean replaceWordsToDigits;

    public static void setReplaceWordsToDigits(boolean replaceWordsToDigits) {
        Day1.replaceWordsToDigits = replaceWordsToDigits;
    }

    public static int getNumber(String str) {
        String number = "";
        var array = str.toCharArray();

        for (int i = 0, length = str.length(); i < length; i++) {
            if (Character.isDigit(array[i])) {
                number += array[i];
                break;
            }
        }

        for (int i = str.length() - 1; i >= 0; i--) {
            if (Character.isDigit(array[i])) {
                number += array[i];
                break;
            }
        }
        return Integer.parseInt(number);
    }

    public static int getCalibration(List<String> input) {
        List<Integer> numbers = new ArrayList<>();
        for (var s : input) {
            numbers.add(getNumber(replaceWordsToDigits ? replaceWordsToDigits(s) : s));
        }
        return Utils.getSum(numbers);
    }

    public static String replaceWordsToDigits(String string) {
        var array = string.toCharArray();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = array[i];
            if (Character.isDigit(c)) {
                s.append(c);
            } else {
                s.append(getIfNumber(string, i));
            }
        }
        return s.toString();
    }

    public static String getIfNumber(String string, int i) {
        char[] array = string.toCharArray();
        char c = array[i];

        if (c == 'o') {
            if (string.length() >= i + 3 && string.substring(i, i + 3).equals("one")) return "1";
        } else if (c == 't') {
            if (string.length() >= i + 5 && string.substring(i, i + 5).equals("three")) return "3";
            if (string.length() >= i + 3 && string.substring(i, i + 3).equals("two")) return "2";
        }  else if (c == 'f') {
            if (string.length() >= i + 4) {
                if (string.substring(i, i + 4).equals("four")) return "4";
                if (string.substring(i, i + 4).equals("five")) return "5";
            }
        } else if (c == 's') {
            if (string.length() >= i + 5 && string.substring(i, i + 5).equals("seven")) return "7";
            if (string.length() >= i + 3 && string.substring(i, i + 3).equals("six")) return "6";
        } else if (c == 'e') {
            if (string.length() >= i + 5 && string.substring(i, i + 5).equals("eight")) return "8";
        } else if (c == 'n') {
            if (string.length() >= i + 4 && string.substring(i, i + 4).equals("nine")) return "9";
        } else if (c == 'z') {
            if (string.length() >= i + 4 && string.substring(i, i + 4).equals("zero")) return "0";
        }
        return "";
    }
}
