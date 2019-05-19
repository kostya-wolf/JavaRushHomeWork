package com.javarush.test.level14.lesson08.bonus01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();


    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }


    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try
        {
            int[] arr = new int[1]; // размер массива 1
            arr[1] = 0; // индекса 1 нет, только 0

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("drA.txt")));

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String s = "str";
            int a = Integer.parseInt(s);

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String s = "str";
            int a = s.charAt(18);

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IndexOutOfBoundsException(); // вышел за пределы ArrayList

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new RuntimeException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IllegalArgumentException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new SocketException();

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new Exception();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}
