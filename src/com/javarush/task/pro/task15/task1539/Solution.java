package com.javarush.task.pro.task15.task1539;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/* 
Использование Paths 2
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(joinToPath(Arrays.asList("d:/", "study/", "javarush/", "полезные куски кода.txt")));
    }

    public static Path joinToPath(List<String> partsList) {
        int size = partsList.size() - 1;
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = partsList.get(i+1);
        }
        return Paths.get(partsList.get(0), array);
    }
}
