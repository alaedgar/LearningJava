package com.javarush.task.jdk13.task06.task0625;

import java.util.Scanner;

/* 
Минимальная сумма
*/

public class Solution {
    public static int[][] array = new int[3][3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <array.length; i++) {
            int sumRow = 0;
            for (int j = 0; j < array[i].length; j++) {
                if (scanner.hasNextInt()) {
                    array[i][j] = scanner.nextInt();
                    sumRow += array[i][j];
                }
            }
            if (sumRow < min) {
                min = sumRow;
            }
        }

        for (int i = 0; i < array.length; i++) {
            int sumCol = 0;
            for (int j = 0; j < array[i].length; j++) {
                sumCol += array[j][i];
            }
            if (sumCol < min) {
                min  = sumCol;
            }
        }
        System.out.print(min);
    }
}
