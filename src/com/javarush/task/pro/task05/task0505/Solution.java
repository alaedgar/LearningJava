package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number > 0) {
                int[] intArray = new int[number];
                for (int i = 0; i < number; i++) {
                    intArray[i] = scanner.nextInt();
                }
                if (number % 2 == 0) {
                    for (int i = number-1; i >= 0 ; i--) {
                        System.out.println(intArray[i]);
                    }
                } else {
                    for (int i = 0; i < number; i++) {
                        System.out.println(intArray[i]);
                    }
                }
            }
        }

    }
}
