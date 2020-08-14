package ru.geekbrains.qa.java2.lesson1;

/* Презентация " Конструкторы". */
public class Demo5 {

    public abstract static class Animal {
        protected String name;

        public Animal(String name) {
            this.name = name;
        }

        public void eat(Demo2.CatFood catFood) {
            System.out.println(this.name + " eat " + catFood.getTitle());
        }

        public String getName() {
            return name;
        }
    }

    public static class Cat extends Animal {

        public Cat(String name) {
            super(name);
        }

        public void meow() {
            System.out.println(this.name + " makes meow!" );
        }
    }

    public static class Dog extends Animal {

        public Dog(String name) {
            super(name);
        }

        public void bark() {
            System.out.println(this.name + " makes bark!" );
        }
    }

    public static void main(String[] args) {
        Demo2.CatFood catFood = new Demo2.CatFood();
        catFood.setTitle("Китикет");

        Animal dog = new Dog("Шарик");
        Animal cat = new Cat("Барсик");

        Animal[] animals = {cat, dog};
        for (Animal animal: animals) {
            animal.eat(catFood);
        }
    }

}


/*
        Специальные методы, которые вызываются при создании объекта.
        Они "конструируют" новый объект определенного класса.
 */