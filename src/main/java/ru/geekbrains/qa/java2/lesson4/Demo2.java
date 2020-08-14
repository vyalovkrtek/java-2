package ru.geekbrains.qa.java2.lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

// Презентация "Collection". Демонстрация методов интерфейса
public class Demo2 {

    // Для демонстрации методов интерфейса Collections используем реализацию ArrayList. С его методами мы поработаем далее.
    public static void main(String[] args) {
        Collection<Integer> integers = new ArrayList<>();

        // Определение размера
        System.out.println(integers.size());
        System.out.println(integers.isEmpty());

        System.out.println("---------------");

        // Добавление элементов
        integers.add(12345);
        Collection<Integer> anotherIntegers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0));
        integers.addAll(anotherIntegers);

        System.out.println(integers);

        System.out.println("---------------");

        // Проверка на вхождение
        System.out.println(integers.contains(12345));
        System.out.println(integers.containsAll(anotherIntegers));
        System.out.println(integers.contains(146));

        System.out.println("---------------");

        // Сравнение
        System.out.println(integers.equals(anotherIntegers));

        System.out.println("---------------");

        // Удаление элементов
        integers.remove(0);
        System.out.println(integers);
        integers.removeAll(anotherIntegers);
        System.out.println(integers);
        integers.addAll(anotherIntegers);
        integers.retainAll(anotherIntegers);
        System.out.println(integers);
        integers.clear();
        System.out.println(integers);

        System.out.println("---------------");

        // Копирование
        integers.addAll(anotherIntegers);
        Object[] integerArray = integers.toArray();

        // Обратить внимание на то, что у массивов length - поле, у коллекций size - метод
        System.out.println(integerArray.length);
    }
}
