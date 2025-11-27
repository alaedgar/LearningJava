package com.javarush.task.pro.task15.task1520;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Перемещение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Path.of(scanner.nextLine());
        Path targetDirectory = Path.of(scanner.nextLine());
        OutputStream stream = System.out;

        try (DirectoryStream<Path> sourceFiles = Files.newDirectoryStream(sourceDirectory)) {
            for (Path path : sourceFiles) {
                if (Files.isRegularFile(path)) {
                    Path resolve = targetDirectory.resolve(path.getFileName());
                    Files.move(path, resolve);
                }
            }
        }
    }
}

