package com.example.days;

import java.io.*;
import java.util.*;

public class Day5Part1 {
    
    static String filePath = "src\\main\\java\\com\\example\\textFiles\\day5data";
    static String fileRules = "src\\main\\java\\com\\example\\textFiles\\day5rules";

    static List<List<String>> rulesSplit = new ArrayList<>();
    static List<List<String>> dataSplit = new ArrayList<>();

    static int answer = 0;

    static boolean match = true;

    static boolean stay = true;

    public static void day5Method() {
        fileReader(filePath, dataSplit, ",");
        fileReader(fileRules, rulesSplit, "\\|");
        // check data y axis
        for(int diy = 0; diy < dataSplit.size(); diy++) {
            match = true;
            stay = true;
            // check data x axis
            if(match) {
                for(int dix = 0; dix < dataSplit.get(diy).size()-1; dix++) {
                    stay = true;
                    // check rules y axis
                    if(match && stay) {
                        for(int riy = 0; riy < rulesSplit.size(); riy++) {
                            // match rules first digit
                            if(dataSplit.get(diy).get(dix).equals(rulesSplit.get(riy).get(0)) && match && stay) {
                                    for(int i = dix+1; i < dataSplit.get(diy).size(); i++) {
                                        if(dataSplit.get(diy).get(i).equals(rulesSplit.get(riy).get(1)) && 
                                        dix == dataSplit.get(diy).size()-2 && i == dataSplit.get(diy).size()-1) {
                                            answer += Integer.parseInt(dataSplit.get(diy).get(dataSplit.get(diy).size()/2));
                                            System.out.println(answer);
                                        }
                                        if(!dataSplit.get(diy).get(i).equals(rulesSplit.get(riy).get(1)) && riy == rulesSplit.size()-1) {
                                            System.out.println("data " + dataSplit.get(diy).get(dix) + " with " + dataSplit.get(diy).get(i) + " cannot be found in rules");
                                            match = false;
                                            break;
                                        }
                                        if(dataSplit.get(diy).get(i).equals(rulesSplit.get(riy).get(1))) {
                                            stay = false;
                                            break;
                                        }
                                    }
                                }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void fileReader (String fileName, List<List<String>> listListString, String regex) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            List<String> rawList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                rawList.add(scanner.nextLine());
            }
            for(int i = 0; i < rawList.size(); i++) {
                listListString.add(Arrays.asList(rawList.get(i).split(regex)));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}