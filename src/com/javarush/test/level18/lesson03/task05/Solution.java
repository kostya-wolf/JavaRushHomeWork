package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
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

        String cTpoka="";

        for (int i = 0; i < mas.length; i++)
        {
            if (mas[i] > 0) cTpoka += i + " ";
        }

        cTpoka = cTpoka.trim();

        System.out.println(cTpoka);

        reader.close();
        fpotok.close();
    }
}
