package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //напишите тут ваш код
    private String name; // м.б. null
    private int weight;
    private int age;
    private String color;
    private String address; // м.б. null

    private int avweight = 3; // средний вес - вес по умолчанию
    private int avage = 1; // средний возраст - возраст по умолчанию
    private String avcolor = "gray"; // // средний цвет - цвет по умолчанию

    Cat(String name){
        this.name = name;

        this.weight = avweight;
        this.age = avage;
        this.color = avcolor;
    }

    Cat(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;

        this.color = avcolor;
    }

    Cat(String name, int age){
        this.name = name;
        this.age = age;

        this.weight = avweight;
        this.color = avcolor;
    }

    Cat(int weight, String color){
        this.weight = weight;
        this.color = color;

        this.age = avage;
    }

    Cat(int weight, String color, String address){
        this.weight = weight;
        this.color = color;
        this.address = address;

        this.age = avage;
    }

}