package com.vladimirprocean;

import java.io.*;

public class FileCombiner {

    public File combineFiles(File f1, File f2) {
        File out = new File("test.txt");
        try (BufferedReader br1 = new BufferedReader(new FileReader(f1)); BufferedReader br2 = new BufferedReader(new FileReader(f2))) {
            String result = "";
            String temp1 = "";
            String temp2 = "";
            while (((temp1 = br1.readLine()) != null) && ((temp2 = br2.readLine()) != null)) {
                String[] words1 = temp1.split(" ");
                String[] words2 = temp2.split(" ");
                for (int i = 0; i < words1.length; i++) {
                    for (int j = 0; j < words2.length; j++) {
                        if ((words1[i].equals(words2[j]))) {
                            saveStringToFile(words1[i], out);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }

    private void saveStringToFile(String str, File file) {
        try (Writer writer = new FileWriter(file, true)) {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
