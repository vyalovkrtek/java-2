package ru.geekbrains.qa.java2.lesson5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Сериализация
public class Demo4 {
    /*
    Если остается 15-20 минут до конца занятия
    */

    static class Student implements Serializable {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                "name='" + name + '\'' +
                "age='" + age + '\'' +
                '}';
        }
    }

    public static void main(String[] args) {
        File file = new File("serialized.student");
        Student student = new Student("Alex", 20);

        // Запись
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(student);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Student readedStudent = (Student) ois.readObject();
            System.out.println(readedStudent.name);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
