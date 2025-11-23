package com.javarush.task.pro.task15.task1530;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/* 
Байты в символы
*/

public class Solution {

    public static char[] bytesToChars(ByteArrayInputStream stream, int n) {
        int min = Math.min(stream.available(), n);
        char[] c = new char[min];
        for (int i = 0; i < min; i++) {
            c[i] = (char)stream.read();
        }

        return c;
    }
    public static void main(String[] args) {
        ByteArrayInputStream stream = new ByteArrayInputStream("O sole, o sole mio!\nSta 'nfronte a te!\n Sta 'nfronte a te!".getBytes(StandardCharsets.UTF_8));
        System.out.println(new String(bytesToChars(stream, 38)));
    }

    //напишите тут ваш код

}
