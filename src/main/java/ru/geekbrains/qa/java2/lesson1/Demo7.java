package ru.geekbrains.qa.java2.lesson1;

/* Презентация "Метод equals и его переопределение". */
public class Demo7 {

    public static void main(String[] args) {
        Dog dog1 = new Dog("Шарик");
        Dog dog2 = new Dog("Шарик");

        System.out.println(dog1.equals(dog2));
    }

    /*
      Изменить стандартное поведение метода equals можно переопределив его.
      Давайте подумаем, как доработать класс чтобы сравнивая его поля можно было однозначно определить равенство?

      Реализация equals ниже, в классе TunedDog
     */

}


class Dog extends Demo5.Animal {

    public Dog(String name) {
        super(name);
    }

    public void bark() {
        System.out.println(this.name + " makes bark!" );
    }
}

class TunedDog extends Demo5.Animal {

    private int dogRegistrationNumber;

    public TunedDog(String name, int dogRegistrationNumber) {
        super(name);
        this.dogRegistrationNumber = dogRegistrationNumber;
    }

    // Какие минусы у такого подхода?
    public boolean equals_1(Object obj) {
        TunedDog dog = (TunedDog) obj;
        return dogRegistrationNumber == dog.dogRegistrationNumber;
    }

    // Добавим проверку на class. Что еще мы не учли?
    public boolean equals_2(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        TunedDog dog = (TunedDog) obj;
        return dogRegistrationNumber == dog.dogRegistrationNumber;
    }

    // Добавим проверку на тот же объект и null
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TunedDog dog = (TunedDog) obj;
        return dogRegistrationNumber == dog.dogRegistrationNumber;
    }


    public void bark() {
        System.out.println(this.name + " makes bark!" );
    }

}