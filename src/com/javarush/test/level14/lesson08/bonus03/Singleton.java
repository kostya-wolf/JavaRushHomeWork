package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Волковы on 10.08.2016.
 */
public class Singleton
{
    private static Singleton singleton = new Singleton();

    private Singleton(){}

    static Singleton getInstance(){
        return singleton;
    }
}
