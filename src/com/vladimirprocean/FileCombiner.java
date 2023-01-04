package com.vladimirprocean;

import java.io.*;

public class FileCombiner {

    public File combineFiles(File f1, File f2) {
        File out = new File("test.txt");
        StringBuilder result = new StringBuilder();
        try (BufferedReader br1 = new BufferedReader(new FileReader(f1)); BufferedReader br2 = new BufferedReader(new FileReader(f2))) {
            String temp1 = "";
            String temp2 = "";
            while (((temp1 = br1.readLine()) != null) && ((temp2 = br2.readLine()) != null)) {
                String[] words1 = temp1.split(" ");
                String[] words2 = temp2.split(" ");
                for (int i = 0; i < words1.length; i++) {
                    for (int j = 0; j < words2.length; j++) {
                        if ((words1[i].equals(words2[j]))) {
                            result.append(words1[i]).append(",");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] matchedWords = result.toString().split(",");
        String[] filteredWords = filterArrayOfWords(matchedWords);
        saveStringToFile(filteredWords, out);
        return out;
    }

    private String[] filterArrayOfWords(String[] words) {
        String[] distinctArray = new String[0];
        int index = 0;
        for (int i = 0; i < words.length; i++) {
            int flag = 0;
            for (int j = 0; j < i; j++) {
                if (words[i].equals(words[j])) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                distinctArray = insertElement(words[i], distinctArray);
                index++;
            }

        }
        return distinctArray;
    }

    private void saveStringToFile(String[] strArray, File file) {
        for (int i = 0; i < strArray.length; i++) {
            try (Writer writer = new FileWriter(file,true)) {
                writer.write((strArray[i] + ","));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private String[] insertElement(String elem, String[] array) {
        int count = 0;
        String[] newArr = new String[array.length + 1];
            for (int i = 0; i < array.length; i++) {
                newArr[i] = array[i];
                count++;
            }
            newArr[count] = elem;
            return newArr;
        }

}
