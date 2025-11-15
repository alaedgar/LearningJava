package com.javarush.task.pro.task04.task0410;

import java.util.Scanner;

/* 
Второе минимальное число из введенных
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        int preMin = min;

        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();

                if (number < min ) {
                    preMin = min;
                    min = number;
                } else if ((number < preMin) && (number != min)) {
                    preMin = number;
                }


            } else {
                break;
            }
        }
        System.out.println(preMin);

    }
}