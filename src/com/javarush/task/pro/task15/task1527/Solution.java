package com.javarush.task.pro.task15.task1527;

import java.io.*;
import java.util.Scanner;

/* 
 Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             FileReader in = new FileReader(scanner.nextLine());
             BufferedReader reader = new BufferedReader(in)) {
            int i = 1;
            while (reader.ready()) {
                String line = reader.readLine();
                if (i % 2 != 0) {
                    System.out.println(line);
                }
                i++;
            }

        } catch (Exception e) {
            System.out.println("Some Exception happened !" + e);
        }
    }
}