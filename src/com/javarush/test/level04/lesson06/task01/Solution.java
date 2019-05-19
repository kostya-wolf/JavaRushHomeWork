package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        if (x<y) System.out.println(x);
        else System.out.println(y);
    }
}