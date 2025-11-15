package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Jon Smith", 45.3);
        grades.put("Jon Jackson", 35.3);
        grades.put("Jenifer Lopez", 42.1);
        grades.put("Adam Lewis", 28.9);
        grades.put("Sandra Hayward", 85.7);
    }
}
