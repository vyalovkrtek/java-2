package ru.geekbrains.qa.java2.lesson5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

// java.io.Reader, Writer
public class Demo3 {

    public static void main(String[] args) {

        /* Запишем побайтно киррилические символы в файл */
        try (OutputStream out = new FileOutputStream("5.txt")) {
            out.write("Привет, мир!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* 1 спрособ чтения - указание кодировки для InputStreamReader */
        try (InputStreamReader in = new InputStreamReader(new FileInputStream("5.txt"), UTF_8)) {
            int x;
            while ((x = in.read()) != -1) {
                System.out.print((char) x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        try (BufferedReader reader = new BufferedReader(new FileReader("5.txt"))) {
            String s = reader.readLine();
            System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        C помощью Reader можно решать более сложные задачи. Допустим есть файл-справочник users.txt
        Работа с файлом сводится к работе со строками. Давайте прочтем файл в список пользователей
        */

        List<User> userList = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("users.txt"))) {
            String result = null;
            in.readLine(); // вычитка первой строки
            while ((result = in.readLine()) != null) {
                String[] tokens = result.split("\\s");
                User user = new User(Long.parseLong(tokens[0]), tokens[1], tokens[2]);
                userList.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        userList.forEach(System.out::println);

        /*
        Для простой записи данных в файл можно использовать PrintWriter
        */
        try (PrintWriter out = new PrintWriter("new_users.txt")) {
            for (User u: userList) {
                out.println(u);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static class User {

        private Long id;
        private String username;
        private String email;

        public User(Long id, String username, String email) {
            this.id = id;
            this.username = username;
            this.email = email;
        }

        @Override
        public String toString() {
            return String.format("id=%d, name=%s, email=%s", id, username, email);
        }
    }
}

