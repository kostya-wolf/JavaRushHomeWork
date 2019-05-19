package com.javarush.test.level05.lesson05.task02;

/* Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет,
т.е. возвращать true, если выиграли и false - если нет.
Должно выполняться условие:
если cat1.fight(cat2) = true , то cat2.fight(cat1) = false
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cat
{
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat()
    {
    }

//    public Cat(String name, int age, int weight, int strength)
//    {
//        this.name = name;
//        this.age = age;
//        this.weight = weight;
//        this.strength = strength;
//    }

    private double calcKage (int age){
        if (age>=1 && age<=7) return 1;
        else return 0.5;
    }

    private double calcKweight (int weight){
        if (weight>=2 && weight<=8) return 1;
        else return 0.5;
    }

    public boolean fight(Cat anotherCat)
    {
        //напишите тут ваш код
        double kAge, kWeight; // коэффициенты возраста и веса
        double kWin1, kWin2; // коэффициенты победы
        kAge = calcKage(this.age);
        kWeight = calcKweight(this.weight);
        kWin1 = kAge*this.age + kWeight*this.weight + this.strength;

//        System.out.println(this.name+": возарст: "+this.age+" вес: "+this.weight+" сила: "+this.strength);
//        System.out.println("Коэф. возраста + коэф. веса: "+kAge+" + "+kWeight);
//        System.out.println("РАСЧЁТ ПОБЕДЫ: "+kAge*this.age+" + "+kWeight*this.weight+" + "+this.strength);
//        System.out.println("Коэф. победы: "+kWin1);
//        System.out.println();

        kAge = calcKage(anotherCat.age);
        kWeight = calcKweight(anotherCat.weight);
        kWin2 = kAge*anotherCat.age + kWeight*anotherCat.weight + anotherCat.strength;

//        System.out.println(anotherCat.name+": возарст: "+anotherCat.age+" вес: "+anotherCat.weight+" сила: "+anotherCat.strength);
//        System.out.println("Коэф. возраста + коэф. веса: "+kAge+" + "+kWeight);
//        System.out.println("РАСЧЁТ ПОБЕДЫ: "+kAge*anotherCat.age+" + "+kWeight*anotherCat.weight+" + "+anotherCat.strength);
//        System.out.println("Коэф. победы: "+kWin2);


        return (kWin1>=kWin2);
    }

//    public static void main(String[] args) throws Exception
//    {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Ведите имя кота 1:");
//        String name = reader.readLine();
//        System.out.println("Ведите возраст кота 1:");
//        int age = Integer.parseInt(reader.readLine());
//        System.out.println("Ведите вес кота 1:");
//        int weight = Integer.parseInt(reader.readLine());
//        System.out.println("Ведите силу кота 1:");
//        int strength = Integer.parseInt(reader.readLine());
//        Cat cat1 = new Cat(name, age, weight, strength);
//
//        System.out.println("Ведите имя кота 2:");
//        name = reader.readLine();
//        System.out.println("Ведите возраст кота 2:");
//        age = Integer.parseInt(reader.readLine());
//        System.out.println("Ведите вес кота 2:");
//        weight = Integer.parseInt(reader.readLine());
//        System.out.println("Ведите силу кота 2:");
//        strength = Integer.parseInt(reader.readLine());
//        Cat cat2 = new Cat(name, age, weight, strength);
//
//
//        if (cat1.fight(cat2)) System.out.println("Победил кот "+cat1.name);
//        else System.out.println("Победил кот "+cat2.name);
//    }
}
