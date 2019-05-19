package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn = reader.readLine();

        FileInputStream fpotok = new FileInputStream(fn);

        int[] mas = new int[256];

        while (fpotok.available() > 0){
            int chis = fpotok.read();
            mas[chis]++;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < mas.length; i++)
        {
            if ((mas[i] < min) && (mas[i] > 0)) min = mas[i];
        }

        String cTpoka="";
        for (int i = 0; i < mas.length; i++)
        {
            if (mas[i] == min) cTpoka += i + " ";

        }

        cTpoka = cTpoka.trim();

        System.out.println(cTpoka);

        reader.close();
        fpotok.close();
    }
}
