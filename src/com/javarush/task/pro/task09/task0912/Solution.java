package com.javarush.task.pro.task09.task0912;

/* 
Проверка URL-адреса
*/

public class Solution {
    public static void main(String[] args) {
        String[] urls = {"https://javarush.ru", "https://google.com", "http://wikipedia.org", "facebook.com", "https://instagram", "codegym.cc"};
        for (String url : urls) {
            String protocol = checkProtocol(url);
            String domain = checkDomain(url);

            System.out.println("У URL-адреса - " + url + ", сетевой протокол - " + protocol + ", домен - " + domain);
        }
    }

    public static String checkProtocol(String url) {
        String s1 = "https";
        String s2 = "http";
        if (url.startsWith(s1)) {
            return s1;
        } else if (url.startsWith(s2)) {
            return s2;
        }
        return "неизвестный";
    }

    public static String checkDomain(String url) {
        String s1 = "com";
        String s2 = "net";
        String s3 = "org";
        String s4 = "ru";
        if (url.endsWith(s1)) {
            return s1;
        } else if (url.endsWith(s2)) {
            return s2;
        } else if (url.endsWith(s3)) {
            return s3;
        } else if (url.endsWith(s4)) {
            return s4;
        }
        return "неизвестный";
    }
}
