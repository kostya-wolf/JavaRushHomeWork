package com.javarush.test.level17.lesson10.bonus02;

import java.util.Date;

public class Person {
    volatile private String name;
    volatile private Sex sex;
    volatile private Date birthDay;

    private Person(String name, Sex sex, Date birthDay) {
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
    }

    synchronized public static Person createMale(String name, Date birthDay){
        return new Person(name, Sex.MALE, birthDay);
    }

    synchronized public static Person createFemale(String name, Date birthDay){
        return new Person(name, Sex.FEMALE, birthDay);
    }

    synchronized public String getName() {
        return name;
    }

    synchronized public void setName(String name) {
        this.name = name;
    }

    synchronized public Sex getSex() {
        return sex;
    }

    synchronized public void setSex(Sex sex) {
        this.sex = sex;
    }

    synchronized public Date getBirthDay() {
        return birthDay;
    }

    synchronized public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
