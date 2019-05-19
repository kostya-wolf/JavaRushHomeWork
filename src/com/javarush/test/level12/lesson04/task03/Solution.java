package com.javarush.test.level12.lesson04.task03;

/* Пять методов print с разными параметрами
Написать пять методов print с разными параметрами.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    //Напишите тут ваши методы
    public void print(int i)
    {
        System.out.println(i);
    }

    public void print(String s)
    {
        System.out.println(s);
    }

    public void print(Integer i)
    {
        System.out.println(i);
    }

    public void print(float f)
    {
        System.out.println(f);
    }

    public void print(Solution sol)
    {
        System.out.println(sol);
    }

}
