package com.javarush.task.pro.task03.task0308;

import java.util.Scanner;

/* 
Координатные четверти
*/

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if ((y > 0) && (x > 0)) {
                System.out.println(1);
        }
        else if ((y > 0) && (x < 0)) {
            System.out.println(2);
        }
        else if ((y < 0) && (x > 0)) {
            System.out.println(4);
        }
        else if ((y < 0) && (x < 0)) {
                System.out.println(3);
        }
    }
}
