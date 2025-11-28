package com.javarush.task.pro.task16.task1612;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/* 
Синтезируем LocalDateTime
*/

public class Solution {

    public static void main(String[] args) {
        Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
        printCollection(dateMap.entrySet());

        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);
    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {
        Set<LocalDateTime> localDateTimeSet = new HashSet<>();
        for (LocalDate localDateElement : sourceMap.keySet() ) {
            if (sourceMap.get(localDateElement).size() > 1) {
                for (LocalTime localTime : sourceMap.get(localDateElement)) {
                    localDateTimeSet.add(LocalDateTime.of(localDateElement, localTime));
                }
            } else {
                localDateTimeSet.add(LocalDateTime.of(localDateElement, sourceMap.get(localDateElement).get(0)));
            }
        }

        return localDateTimeSet;
    }

    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}