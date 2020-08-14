package ru.geekbrains.qa.java2.lesson3;

// Коробка с двумя разными типами
public class Demo3 {

    public static class BoxWithTwoGenerics<T, U> {
        private T obj1;
        private U obj2;

        public BoxWithTwoGenerics(T obj1, U obj2) {
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        public T getObj1() {
            return obj1;
        }

        public void setObj1(T obj1) {
            this.obj1 = obj1;
        }

        public U getObj2() {
            return obj2;
        }

        public void setObj2(U obj2) {
            this.obj2 = obj2;
        }
    }

    public static void main(String[] args) {
        BoxWithTwoGenerics<Integer, Integer> box1 = new BoxWithTwoGenerics<>(1, 1);
        BoxWithTwoGenerics<Integer, String > box2 = new BoxWithTwoGenerics<>(145_000_000, "Население России");

        int peopleInRussia = box2.getObj1(); // Никаких явных приведений к типу
    }

}
