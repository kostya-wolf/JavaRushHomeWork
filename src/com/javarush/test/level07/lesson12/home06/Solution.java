package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось:
Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human ded1 = new Human();
        ded1.name = "Дед1";
        ded1.sex = true;
        ded1.age = 77;

        Human ded2 = new Human();
        ded2.name = "Дед2";
        ded2.sex = true;
        ded2.age = 76;

        Human baba1 = new Human();
        baba1.name = "Баба1";
        baba1.sex = false;
        baba1.age = 70;

        Human baba2 = new Human();
        baba2.name = "Баба2";
        baba2.sex = false;
        baba2.age = 69;

        Human daddy = new Human();
        daddy.name = "Отец";
        daddy.sex = true;
        daddy.age = 50;
        daddy.father = ded1;
        daddy.mother = baba1;

        Human mommy = new Human();
        mommy.name = "Мать";
        mommy.sex = false;
        mommy.age = 49;
        mommy.father = ded2;
        mommy.mother = baba2;

        Human child1 = new Human();
        child1.name = "Ребенок1";
        child1.sex = true;
        child1.age = 30;
        child1.father = daddy;
        child1.mother = mommy;

        Human child2 = new Human();
        child2.name = "Ребенок2";
        child2.sex = false;
        child2.age = 25;
        child2.father = daddy;
        child2.mother = mommy;

        Human child3 = new Human();
        child3.name = "Ребенок3";
        child3.sex = true;
        child3.age = 20;
        child3.father = daddy;
        child3.mother = mommy;

        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(baba1);
        System.out.println(baba2);
        System.out.println(daddy);
        System.out.println(mommy);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        Boolean sex;
        int age;
        Human father;
        Human mother;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
