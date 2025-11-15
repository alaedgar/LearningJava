package com.javarush.task.jdk13.task06.task0624;

import java.util.Scanner;

/* 
Максимальный элемент
*/

public class Solution {
    public static int[][] array = new int[3][3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (scanner.hasNextInt()) {
                    array[i][j] = scanner.nextInt();
                    if (array[i][j] > max) {
                        max = array[i][j];
                    }
                }
            }
        }
        System.out.print(max);
    }
}
