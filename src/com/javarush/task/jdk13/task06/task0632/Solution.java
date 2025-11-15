package com.javarush.task.jdk13.task06.task0632;

import java.util.Scanner;

/* 
Пирамида
*/

public class Solution {
    public static char[][] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
        }

        array = new char[number][];

        for (int i = 0; i < array.length; i++) {
            int rowLength = 2*array.length - 1;
            array[i] = new char[rowLength];
            for (int j = 0; j < rowLength; j++) {
                if ((j < (rowLength/2) - i) || (j > (rowLength/2) + i)) {
                    array[i][j] = ' ';
                } else {
                    array[i][j] = '#';
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < (2*array.length - 1); j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }


    }
}
