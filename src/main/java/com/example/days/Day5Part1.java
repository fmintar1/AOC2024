package com.example.days;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day5Part1 {
    static String dataPath = "src\\main\\java\\com\\example\\textFiles\\day5data";
    static String rulesPath = "src\\main\\java\\com\\example\\textFiles\\day5rules";
    static List<List<String>> dataList = new ArrayList<>();
    static List<List<String>> rulesList = new ArrayList<>();

    static boolean matchFound = true;
    static boolean rulesLoop = true;
    static boolean repeat = true;
    static int counter = 0;
    static int answer = 0;

    public static void day5Method() {
        fileReader(dataPath, dataList, ",");
        fileReader(rulesPath, rulesList, "\\|");
        // data y axis
        for(int diy = 0; diy < dataList.size(); diy++) {
            matchFound = true;
            // data x axis first number
            if(matchFound) {
                for(int dix = 0; dix < dataList.get(diy).size()-1; dix++) {
                    System.out.println(dix);
                    repeat = true;
                    // rules y axis, check if data is in rules first index
                        for (int riy = 0; riy < rulesList.size(); riy++) {
                            if (repeat) {
                            System.out.println("starting the rules loop");
                            if (dataList.get(diy).get(dix).equals(rulesList.get(riy).get(0))) {
                                // data x axis second number, check if data is in rules second index
                                for (int i = dix + 1; i < dataList.get(diy).size(); i++) {
                                    if (dataList.get(diy).get(i).equals(rulesList.get(riy).get(1)) && dix == dataList.get(diy).size() - 1) {
                                        System.out.println("final data targeted is " + dataList.get(diy).get(dix) + " and " + dataList.get(diy).get(i));
                                        System.out.println("data found in rules. Data is " + dataList.get(diy) + " and rules is " + rulesList.get(riy));
                                        repeat = false;
                                        break;
                                    }
                                    if (dataList.get(diy).get(i).equals(rulesList.get(riy).get(1))) {
                                        System.out.println("data targeted is " + dataList.get(diy).get(dix) + " and " + dataList.get(diy).get(i));
                                        System.out.println("data found in rules. Data is " + dataList.get(diy) + " and rules is " + rulesList.get(riy));
                                        repeat = false;
                                        matchFound = false;
                                        break;
                                    }
                                    if (!dataList.get(diy).get(i).equals(rulesList.get(riy).get(1)) && riy == rulesList.size() - 1) {
                                        System.out.println("false data targeted is " + dataList.get(diy).get(dix) + " and " + dataList.get(diy).get(i));
                                        System.out.println("data not found in rules. Data is " + dataList.get(diy) + " and rules is " + rulesList.get(riy));
                                        matchFound = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    public static void fileReader(String filePath, List<List<String>> listOfList, String regex) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            int answer = 0;
            while (scanner.hasNextLine()) {
                listOfList.add(Arrays.asList(scanner.nextLine().split(regex)));
            }
            System.out.println(listOfList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
