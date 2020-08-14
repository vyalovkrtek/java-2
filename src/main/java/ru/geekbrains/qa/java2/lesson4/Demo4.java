package ru.geekbrains.qa.java2.lesson4;

import com.sun.tools.javac.util.List;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

// Презентация "Set". Вспоминаем hashCode. Что такое hash
public class Demo4 {

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cat cat = (Cat) o;
            return name != null ? name.equals(cat.name) : cat.name == null;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }
    }

    public static void main(String[] args) {
        /*
        Hash - математическое преобразование массива данных произвольной длины в битовую строку определенной длины
        по определенному алгоритму.

        (Привести примеры из жизни - контрольная сумма файлов на торрент-трекерах)

        В Java вычисление хэша поддерживается на уровне языка

        (Продемонстрировать переопределение equals без переопределения hashCode - два объекта equals но хэши разные.
        */

        Cat cat1 = new Cat("Murzik");
        Cat cat2 = new Cat("Murzik");
        System.out.println(cat1.equals(cat2));
        System.out.println(Integer.toHexString(cat1.hashCode()));
        System.out.println(Integer.toHexString(cat2.hashCode()));

        /*
        Почему это плохо?
        Некоторые коллекции судят об "одинаковости" элементов по хэшу
        */

        Set<Cat> catSet = new HashSet<>(List.of(cat1, cat2));
        System.out.println(catSet);

        /*
        Переопределить метод hashCode для корректной работы Set
        */

        // Добавление в порядке, зависящем от хэша
        Set<Integer> uniqElems = new HashSet<>(Arrays.asList(1, 0, 2, 3, 4, 2, 2, 1, 2, 3, 4, 1, 0, 5, 2, 12, 100));
        System.out.println(uniqElems);

        // Добавление по порядку, если элемент уже существует - не добавляется
        Set<Integer> linkedUniqElems = new LinkedHashSet<>(Arrays.asList(1, 0, 2, 3, 4, 2, 2, 1, 2, 3, 4, 1, 0, 5, 2, 12, 100));
        System.out.println(linkedUniqElems);

        // Множество, которое сортирует при добавлении
        Set<Integer> sortedUniqElems = new TreeSet<>(Arrays.asList(1, 0, 2, 3, 4, 2, 2, 1, 2, 3, 4, 1, 0, 5, 2, 12, 100));
        System.out.println(sortedUniqElems);

        /*
        Освежить уже пройденный Comparable
        java.lang.ClassCastException: Cat cannot be cast to java.lang.Comparable

        Set<Cat> sortedCatList = new TreeSet<>(Arrays.asList(new Cat("Murzik"), new Cat("Barsik")));
        System.out.println(sortedCatList);
        */

    }

}
