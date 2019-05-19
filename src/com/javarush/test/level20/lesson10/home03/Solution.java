package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {
    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }

        public A() {
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        public B() {
        }

        String name = super.name;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution sol = new Solution();
        B b = sol.new B("Имя_B");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("cat.dat"));
        objectOutputStream.writeObject(b);
        objectOutputStream.close();

        System.out.println(b.name);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("cat.dat"));
        B b2 = (B) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(b2.name);
    }
}
