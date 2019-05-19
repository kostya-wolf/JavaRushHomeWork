package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        BufferedReader inStream = new BufferedReader(new FileReader(file));

        ArrayList<Integer> arr = new ArrayList<Integer>();

        String line = inStream.readLine();;

        while (line != null){
            arr.add(Integer.parseInt(line));
            line = inStream.readLine();
        }

        for (int i = 0; i < arr.size(); )
        {
            if (arr.get(i) % 2 == 0) i++;
            else arr.remove(i);
        }

        Integer[] mas = arr.toArray(new Integer[arr.size()]);

        for (int i = 0; i < mas.length-1; i++)
        for (int j = 0; j < mas.length-i-1; j++)
        {
            if (mas[j] > mas[j+1])
            {
                int temp = mas[j];
                mas[j] = mas[j+1];
                mas [j+1] = temp;
            }

        }

        for (int i=0; i<mas.length; i++){
            System.out.println(mas[i]);
        }

        inStream.close();
        reader.close();
    }
}
