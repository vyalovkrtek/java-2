package ru.geekbrains.qa.java2.lesson4;

import java.util.HashMap;
import java.util.Map;

// Презентация "Map"
public class Demo5 {

    public static void main(String[] args) {
        Map<String, Integer> month = new HashMap<>();
        month.put("Январь", 1);
        month.put("Февраль", 2);
        month.put("Март", 3);
        month.put("Апрель", 4);
        month.put("Май", 5);

        // не гарантирует порядок добавления
        System.out.println(month);

        // доступ по ключу
        System.out.println(month.get("Март")); // 3
        System.out.println(month.get("Абракадабра")); // null

        // Обновление значения по ключу
        month.put("Январь", 111);
        System.out.println(month);

        // Перебор ключей
        for (String key: month.keySet()) {
            System.out.printf("key=%s, val=%d \n", key, month.get(key));
        }

        System.out.println(month.values());
    }

}
