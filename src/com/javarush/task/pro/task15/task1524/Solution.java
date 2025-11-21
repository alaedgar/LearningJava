package com.javarush.task.pro.task15.task1524;

import java.io.*;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in);
             FileInputStream src = new FileInputStream(scanner.nextLine());
             FileOutputStream dst = new FileOutputStream(scanner.nextLine())){

            byte[] buffer = src.readAllBytes();
            byte[] output = new byte[buffer.length];

            for (int i = 0; i < buffer.length; i += 2) {
                if (i < buffer.length - 1) {
                    output[i] = buffer[i + 1];
                    output[i + 1] = buffer[i];
                } else {
                    output[i] = buffer[i];
                }
            }

            dst.write(output);
        } catch (IOException e) {
            System.out.println("There was some exception.");
        }
    }
}