package com.javarush.task.pro.task15.task1529;

import java.io.*;
import java.util.Scanner;

/* 
Пишем символы в файл
*/

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             FileWriter writer = new FileWriter(scanner.nextLine())) {
            char[] chars = new char[]{'j', 'a', 'v', 'a'};
            for (char aChar : chars) {
                writer.write(aChar);
            }
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}