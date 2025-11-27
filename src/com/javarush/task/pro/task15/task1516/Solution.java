package com.javarush.task.pro.task15.task1516;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файл или директория
*/

public class Solution {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line;
        while (true) {
            line = scanner.nextLine();
            Path path = Path.of(line);
            if (Files.exists(path)) {
                if (Files.isRegularFile(path)) {
                    System.out.println(line + " - это файл");
                } else if (Files.isDirectory(path)) {
                    System.out.println(line + " - это директория");
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }
}

