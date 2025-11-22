package com.javarush.task.pro.task15.task1526;

import java.io.*;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             FileReader src = new FileReader(scanner.nextLine())){

            while (src.ready()) {
                int real = src.read();
                char c = (char) real;
                if (c != '.' && c != ',' & c != ' ') {
                    System.out.print((char) real);
                }
            }
        } catch (IOException e) {
            System.out.println("There was some exception.");
        }
    }
}