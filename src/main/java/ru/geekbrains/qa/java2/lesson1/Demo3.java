package ru.geekbrains.qa.java2.lesson1;

/* Презентация "Наследование". */
public class Demo3 {

    public abstract static class Animal {
        protected String name;
        public void eat(Demo2.CatFood catFood) { // <- проверить внимательность студентов на моменте с типом еды.
            System.out.println(name + " ест корм " + catFood.getTitle());
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Cat extends Animal {
        public void meow() {
            System.out.println(this.name + " делает мяу");
        }
    }

    public static class Dog extends Animal {
        public void bark() {
            System.out.println(this.name + " делает гав!");
        }
    }
}

/*
        Класс, который наследует свойства другого класса, называется подклассом
         (производным классом, наследующим классом),
         а класс, свойства которого наследуются, известен как суперкласс
         (базовый класс, родительский класс)
 */