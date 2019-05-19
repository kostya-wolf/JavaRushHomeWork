package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name;
        int age;
        Human spouse;
        int phone;
        boolean sex;
        byte children;

        public Human(String name){
            this.name = name;
        }

        public Human(int age){
            this.age = age;
        }

        public Human(Human spouse){
            this.spouse = spouse;
        }

        public  Human(boolean sex){
            this.sex = sex;
        }

        public Human(byte children){
            this.children = children;
        }

        public Human(String name, int age, Human spouse, int phone, boolean sex, byte children)
        {
            this.name = name;
            this.age = age;
            this.spouse = spouse;
            this.phone = phone;
            this.sex = sex;
            this.children = children;
        }

        public Human(String name, int phone)
        {
            this.name = name;
            this.phone = phone;
        }

        public Human(String name, Human spouse, byte children)
        {
            this.name = name;
            this.spouse = spouse;
            this.children = children;
        }

        public Human(String name, int age, int phone, boolean sex)
        {
            this.name = name;
            this.age = age;
            this.phone = phone;
            this.sex = sex;
        }

        public Human(String name, Human spouse)
        {
            this.name = name;
            this.spouse = spouse;
        }
    }
}
