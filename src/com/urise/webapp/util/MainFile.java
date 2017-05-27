package com.urise.webapp.util;

import java.io.File;

/**
 * Created by vp on 24.05.17.
 */
public class MainFile {
    public static void main(String[] args) {

        String directoryPath = "/Users/vp/Documents/CODE_START/resume-storage";
        listAllFiles(directoryPath);
    }

    public static void listAllFiles(String directoryName) {
        File directory = new File(directoryName);

        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                System.out.println(file.getName() + " /*DIR*/");
                listAllFiles(file.getAbsolutePath());
            }
        }
    }


}

