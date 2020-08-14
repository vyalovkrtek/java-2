package ru.geekbrains.qa.java2.lesson9;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

// Демонстрация лямбды
public class Demo2 {

    /*
    Из предыдущего примера свернуть анонимный класс в лямбду

    Лямбды = Анонимные функции
    1. Указывать тип можно, но компилятор приводит к нужному типу самостоятельно
    2. Если выражение в одну строку, не обязательно писать return и ставить {}

    Продемонстрировать лямбды на остальных примерах
    */

    public static void main(String[] args) {
        UnaryOperator<Integer> getCube =
            (Integer integer) -> {
                return integer * integer * integer;
            };

        System.out.println(getCube.apply(10));

        Consumer<Object> printObject = it -> System.out.println(it);

        printObject.accept(new Object());
    }


}
