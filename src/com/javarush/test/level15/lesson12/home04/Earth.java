package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Волковы on 11.08.2016.
 */
public class Earth implements Planet
{
    private static Earth instance;

    public static Earth getInstance()
    {
        if (instance == null){
            instance = new Earth();
        }
        return instance;
    }

    private Earth()
    {
    }
}