package ru.geekbrains.qa.java2.lesson4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// Презентация "List". Демонстрация методов ArrayList
public class Demo3 {

    public static abstract class Vehicle {

        protected String model;

        public Vehicle(String model) {
            this.model = model;
        }
    }

    public static class Car extends Vehicle {

        public Car(String model) {
            super(model);
        }
    }

    public static class Bike extends Vehicle {

        public Bike(String model) {
            super(model);
        }
    }

    public static void main(String[] args) {

        // В отличии от обобщений, коллекции ковариантны
        ArrayList<Vehicle> garageList = new ArrayList<>();

        Bike b = new Bike("Ява");
        Car c = new Car("Ваз 2105");
        garageList.add(b);
        garageList.add(c);

        // Получение индекса по элементу
        System.out.println(garageList.indexOf(b));

        // Добавление элементов при инициализации
        ArrayList<Vehicle> garageList2 = new ArrayList<>(
            Arrays.asList(new Bike("Комета"), new Car("ЗиЛ 130"))
        );

        // Сортировка
        Integer[] ints = new Integer[]{5, 3, 4, 1, 2};
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(ints));

        Collections.sort(integers);
        System.out.println(integers);

        Collections.reverse(integers);
        System.out.println(integers);

        //  Замена элемента
        integers.set(4, 100);
        System.out.println(integers);
    }
}
