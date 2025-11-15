package com.javarush.task.pro.task13.task1323;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;

import static java.util.Arrays.asList;

/* 
Преобразование списка во множество
*/

public class Solution {

    public static void main(String[] args) {
        ArrayList<String> listOfWords = new ArrayList<>(asList(
                "В свет вышла новая серия книг по программированию на Java: \"Java для начинающих\", \"Java для продолжающих\", \"Java для заканчивающих\""
                .split(" ")));
        System.out.println("Количество слов в списке: " + listOfWords.size());
        HashSet<String> setOfWords = listToSet(listOfWords);
        System.out.println("Количество слов во множестве: " + setOfWords.size());
    }

    public static HashSet<String> listToSet(ArrayList<String> listOfWords) {
        HashSet<String> result = new HashSet<>();
        for (String word : listOfWords) {
            result.add(word);
        }

        return result;
    }
}