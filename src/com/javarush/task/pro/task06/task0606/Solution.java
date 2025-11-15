package com.javarush.task.pro.task06.task0606;

/* 
Универсальный солдат
*/

public class Solution {

    public static void main(String[] args) {
        universalMethod();
        universalMethod("Hello");
        universalMethod(10);
        universalMethod(10.5);
        universalMethod(true);
        universalMethod('A');
        universalMethod(5L);
        universalMethod(3.5D);
        short s = 5;
        universalMethod(s);
        byte b = 1;
        universalMethod(b);
    }

    public static void universalMethod(String text){
        System.out.println(text);
    }

    public static void universalMethod(int number){
        System.out.println(number);
    }

    public static void universalMethod(boolean bool){
        System.out.println(bool);
    }

    public static void universalMethod(char chcacter){
        System.out.println(chcacter);
    }

    public static void universalMethod(long number){
        System.out.println(number);
    }

    public static void universalMethod(double doubleNumber){
        System.out.println(doubleNumber);
    }

    public static void universalMethod(float floatNumber){
        System.out.println(floatNumber);
    }

    public static void universalMethod(byte byteNumber){
        System.out.println(byteNumber);
    }

    public static void universalMethod(short shortNumber){
        System.out.println(shortNumber);
    }

    public static void universalMethod(){
        System.out.println("Nothing to do!");
    }
}
