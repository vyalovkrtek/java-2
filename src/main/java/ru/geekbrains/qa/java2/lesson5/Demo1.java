package ru.geekbrains.qa.java2.lesson5;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static java.lang.Thread.sleep;

// Демонстрация методов класса java.io.File
public class Demo1 {

    public static void main(String[] args) throws IOException, InterruptedException {

        File file = new File("./");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.isAbsolute());

        System.out.println("----");
        System.out.println(Arrays.toString(file.list()));
        System.out.println(Arrays.toString(file.listFiles()));
        System.out.println("----");
        System.out.println();

        File tempFile = new File("./1.txt");
        tempFile.createNewFile();
//        tempFile.delete();

        tempFile.deleteOnExit();
        sleep(15000);
    }

}
