package com.example.demo.main;

public class FileExtension {

    public static void main(String[] args) {

        System.out.println(getFileExtension("1234.pdf"));


    }

    public static String getFileExtension(String fileName){

        System.out.println(fileName.lastIndexOf("."));
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        return fileExtension;
    }
}
