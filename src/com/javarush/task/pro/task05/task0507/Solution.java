package com.javarush.task.pro.task05.task0507;

import java.util.Scanner;

/* 
Максимальное из N чисел
*/

public class Solution {
    public static int[] array;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }

        int max = array[0];
        for (int i = 1; i < number; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println(max);
    }

}



