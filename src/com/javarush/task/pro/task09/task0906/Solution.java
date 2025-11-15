package com.javarush.task.pro.task09.task0906;

import java.util.regex.Pattern;

/* 
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        decimalNumber = 34;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111111111111111111111111111111";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        if (decimalNumber > 0) {
            String binaryNumber = "";
            while (decimalNumber !=0 ) {
                binaryNumber = Integer.toString(decimalNumber % 2) + binaryNumber;
                decimalNumber /=2;
            }
            return binaryNumber;
        } else {
            return "";
        }
    }

    public static int toDecimal(String binaryNumber) {
        if (binaryNumber == null || (binaryNumber.length() == 0)) {
            return 0;
        }
        int decimalNumber = 0;
        int l = binaryNumber.length();
        for (int i = 0; i < l; i++) {
            decimalNumber += (binaryNumber.charAt(i) - '0') * ((int) Math.pow(2.0, (l - i - 1)));
        }
        return decimalNumber;

    }
}
