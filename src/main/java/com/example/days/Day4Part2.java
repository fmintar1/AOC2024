package com.example.days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4Part2 {

    static String filePath = "src\\main\\java\\com\\example\\textFiles\\day4data";

    public static void day4Method() {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            int answer = 0;
            int rows = 0;
            List<char[]> allLines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                allLines.add(scanner.nextLine().toCharArray());
                rows++;
            }
            char[][] array2D = allLines.toArray(new char[allLines.size()][]);

            for(int y = 1; y < array2D.length-1; y++) {
                for(int x = 1; x < array2D[y].length-1; x++) {
                    if (array2D[y][x] == 'A') {
                        answer+=checkRotation(array2D, y, x);
                    }
                }
            }
            System.out.println(answer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int checkRotation(char[][] lines, int y, int x) {
        int result = 0;
        if (lines[y-1][x-1] == 'M' && lines[y+1][x+1] == 'S' && lines[y-1][x+1] == 'M' && lines[y+1][x-1] == 'S'){
            result++;
        }
        if (lines[y-1][x-1] == 'M' && lines[y+1][x+1] == 'S' && lines[y+1][x-1] == 'M' && lines[y-1][x+1] == 'S') {
            result++;
        }
        if (lines[y-1][x-1] == 'S' && lines[y+1][x+1] == 'M' && lines[y-1][x+1] == 'M' && lines[y+1][x-1] == 'S') {
            result++;
        }
        if (lines[y-1][x-1] == 'S' && lines[y+1][x+1] == 'M' && lines[y+1][x-1] == 'M' && lines[y-1][x+1] == 'S') {
            result++;
        }
        return result;
    }
}