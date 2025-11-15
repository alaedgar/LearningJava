package com.javarush.task.pro.task13.task1316;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        JavarushQuest[] quests = JavarushQuest.values();
        for (JavarushQuest quest : quests) {
            System.out.println(quest.ordinal());
        }
    }
}
