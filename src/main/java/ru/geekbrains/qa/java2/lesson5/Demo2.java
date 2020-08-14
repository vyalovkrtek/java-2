package ru.geekbrains.qa.java2.lesson5;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// java.io.OutputStream, InputStream
public class Demo2 {

    public static void main(String[] args) {

        File file = new File("our_file.txt");
        /* Попробуем записать в файл байт */

        // Продемонстрировать запись и дозапись в файл
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            //            outputStream = new FileOutputStream(file, true);
            outputStream.write(65);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /* Try with resources */
        try (OutputStream out = new FileOutputStream(file)) {
            out.write(65);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Запишем в файл слово целиком, используем метод getBytes. Нельзя использовать закрытый стрим*/
        try (OutputStream out = new FileOutputStream("1.txt")) {
            out.write("Java".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Попробуем наполнить файл пятью мегабайтами текста и засечь время */

        long time = System.currentTimeMillis();
        try (OutputStream out = new FileOutputStream("2.txt")) {
            for (int i = 0; i < 5 * 1024 * 1024; i++) {
                out.write(65);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("time: " + (System.currentTimeMillis() - time));

        /*
        Очень медленно. Нам может помочь буфферизация. Данные будут быстро записываться в буффер а
        затем разом будут записаны в файловую систему
        */

        long time2 = System.currentTimeMillis();
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream("3.txt"))) {
            for (int i = 0; i < 5 * 1024 * 1024; i++) {
                out.write(65);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("time: " + (System.currentTimeMillis() - time2));

        /* На самом деле, с OutputStream вы знакомы довольно давно */
        System.out.println("out - экземпляр PrintStream (форматируемый поток данных)");

        /*
        Работа с InputStream аналогична работе с OutputStream
        Давайте прочтем байт из файла
        Таким способом не получится читать киррилические символы, т.к 1 символ кодируется >1 байтом
        */
        try (InputStream in = new FileInputStream(file)) {
            // System.out.println(in.read()); // <- 65
            System.out.println((char) in.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
