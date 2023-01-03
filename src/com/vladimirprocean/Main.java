package com.vladimirprocean;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String parentFolder = "D:\\Education\\Grammarly";
        File file1 = new File(parentFolder, "03.02.2021.txt");
        File file2 = new File(parentFolder, "24.01.2021.txt");
        FileCombiner fc = new FileCombiner();
        File out = fc.combineFiles(file1, file2);
        try {
            out.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(out.isDirectory());
    }
}