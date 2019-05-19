package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        int[] mas = {a,b,c};
        for (int j=0; j<2; j++)
        for (int i=1; i<3; i++)
            if (mas[i] > mas[i-1])
            {
                a = mas[i];
                mas[i] = mas[i-1];
                mas[i-1] = a;
            }
        for (int i=0; i<3; i++) System.out.print(mas[i]+" ");
    }
}
