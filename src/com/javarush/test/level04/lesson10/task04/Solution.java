package com.javarush.test.level04.lesson10.task04;

import java.io.*;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int i=0, j=0;
        while (j<10)
        {
            while (i < 10)
            {
                System.out.print("S");
                i++;
            }
            i=0;
            System.out.println("");
            j++;
        }
    }
}
