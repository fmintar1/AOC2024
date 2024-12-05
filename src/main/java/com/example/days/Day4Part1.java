package com.example.days;

import java.io.*;
import java.util.*;

public class Day4Part1 {

    private static final int WORD_LENGTH = 4;
    static String filePath = "src\\main\\java\\com\\example\\textFiles\\day4data";

    public static void day4Method() {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            int answer = 0;
            List<char[]> allLines = new ArrayList<>();

            while (scanner.hasNextLine()) {
                allLines.add(scanner.nextLine().toCharArray());
            }

            char[][] array2D = allLines.toArray(new char[0][]);

            for (int y = 0; y < array2D.length; y++) {
                for (int x = 0; x < array2D[y].length; x++) {
                    if (array2D[y][x] == 'X') {
                        answer += checkDirection(array2D, y, x, 1, 0);  // Right
                        answer += checkDirection(array2D, y, x, 0, 1);  // Down
                        answer += checkDirection(array2D, y, x, -1, 0); // Left
                        answer += checkDirection(array2D, y, x, 0, -1); // Up
                        answer += checkDirection(array2D, y, x, 1, 1);  // Right-Down
                        answer += checkDirection(array2D, y, x, 1, -1); // Right-Up
                        answer += checkDirection(array2D, y, x, -1, 1); // Left-Down
                        answer += checkDirection(array2D, y, x, -1, -1); // Left-Up
                    }
                }
            }
            System.out.println("Answer: " + answer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int checkDirection(char[][] lines, int y, int x, int dx, int dy) {
        int rows = lines.length;
        int cols = lines[0].length;

        if (y + (WORD_LENGTH - 1) * dy >= rows || y + (WORD_LENGTH - 1) * dy < 0 || 
            x + (WORD_LENGTH - 1) * dx >= cols || x + (WORD_LENGTH - 1) * dx < 0) {
            return 0;
        }

        if (lines[y + dy][x + dx] == 'M' &&
            lines[y + 2 * dy][x + 2 * dx] == 'A' &&
            lines[y + 3 * dy][x + 3 * dx] == 'S') {
            return 1;
        }
        return 0;
    }
}