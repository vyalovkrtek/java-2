package ru.geekbrains.qa.java2.lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Iterable, iterator
public class Demo6 {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9,0));

        // Цикл for
        for (int i = 0; i < integerList.size(); i++) {
            System.out.print(integerList.get(i));
        }
        System.out.println();

        // Использование итератора
        Iterator<Integer> iterator = integerList.iterator();
        while (iterator.hasNext()) {
            // iterator.next() - проскочим один элемент
            System.out.print(iterator.next());
        }

        System.out.println();
        // For-each - использует итератор
        for (Integer integer : integerList) {
            System.out.print(integer);
        }

        System.out.println();

        // Удаление в процессе обхода - ConcurrentModificationException
        for (Integer integer: integerList) {
            if (integer == 5) {
//                integerList.remove(integer);
            }
        }

        // Для удаления используем итератор
        Iterator<Integer> iterator1 = integerList.iterator();
        while (iterator1.hasNext()) {
            int a = iterator1.next();
            if (a == 5) {
                iterator1.remove();
            }
        }

        System.out.println(integerList);
    }
}
