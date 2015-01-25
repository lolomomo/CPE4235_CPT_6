/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorproject.lecture6;

import java.io.File;

/**
 *
 * @author RainWhileLoop
 */
public class FolderWalker {

    public static void main(String[] args) {
        walking(new File("E:\\CPE\\2-2557"));
    }

    public static void walking(File folder) {
        System.out.println("name -> " + folder.getName());
        System.out.println("path -> " + folder.getAbsolutePath());
        System.out.println("size -> " + folder.length() + "\n");

        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            // do nothing
        } else {
            for (File file : files) {
                if (file.isDirectory()) {
                    walking(file);
                }
            }
        }
    }
}
