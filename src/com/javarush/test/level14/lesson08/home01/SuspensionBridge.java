package com.javarush.test.level14.lesson08.home01;

/**
 * Created by Волковы on 10.08.2016.
 */
public class SuspensionBridge implements Bridge
{
    public int getCarsCount(){
        return Integer.MAX_VALUE-1;
    }
}
