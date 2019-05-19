package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human child1 = new Human();
        child1.name = "child1";
        child1.sex = true;
        child1.age = 5;
        child1.children = new ArrayList<Human>();

        Human child2 = new Human();
        child2.name = "child2";
        child2.sex = false;
        child2.age = 3;
        child2.children = new ArrayList<Human>();

        Human child3 = new Human();
        child3.name = "child3";
        child3.sex = true;
        child3.age = 1;
        child3.children = new ArrayList<Human>();

        Human otec = new Human();
        otec.name = "otec";
        otec.sex = true;
        otec.age = 29;
        otec.children = new ArrayList<Human>();
        otec.children.add(child1);
        otec.children.add(child2);
        otec.children.add(child3);

        Human mother = new Human();
        mother.name = "mother";
        mother.sex = false;
        mother.age = 28;
        mother.children = new ArrayList<Human>();
        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);

        Human ded1 = new Human();
        ded1.name = "ded1";
        ded1.sex = true;
        ded1.age = 55;
        ded1.children = new ArrayList<Human>();
        ded1.children.add(otec);

        Human baba1 = new Human();
        baba1.name = "baba1";
        baba1.sex = false;
        baba1.age = 54;
        baba1.children = new ArrayList<Human>();
        baba1.children.add(otec);

        Human ded2 = new Human();
        ded2.name = "ded2";
        ded2.sex = true;
        ded2.age = 65;
        ded2.children = new ArrayList<Human>();
        ded2.children.add(mother);

        Human baba2 = new Human();
        baba2.name = "baba2";
        baba2.sex = false;
        baba2.age = 64;
        baba2.children = new ArrayList<Human>();
        baba2.children.add(mother);

        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(baba1);
        System.out.println(baba2);
        System.out.println(otec);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
