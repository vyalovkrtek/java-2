package ru.geekbrains.qa.java2.lesson3;

// Демонстрация обобщенного класса
public class Demo2 {

    public static class BoxGen<T> {
        private T obj;

        public BoxGen(T obj) {
            this.obj = obj;
        }

        public T getObj() {
            return obj;
        }

        public void setObj(T obj) {
            this.obj = obj;
        }

        @Override
        public String toString() {
            return "Box{" +
                "type=" + obj.getClass().getSimpleName() +
                " object=" + obj +
                '}';
        }
    }

    public static void main(String[] args) {
        BoxGen<Integer> intBox1 = new BoxGen<>(10);
        BoxGen<Integer> intBox2 = new BoxGen<>(20);

        // Ошибки не возникает
        int sum = intBox1.getObj() + intBox2.getObj();
        System.out.println(sum);

//        intBox2.setObj("String now"); <- Ошибка компиляции
    }

}
