package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        boolean probel = true;
        String sym;

        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)==' ') probel=true;
            else if (s.charAt(i)!=' ' && probel==true){
                sym = s.substring(i,i+1);
                sym = sym.toUpperCase();
                //tyt заменить символ строки на sym
                s = s.substring(0, i) + sym + s.substring(i+1);
                probel = false;
            }

        }

        System.out.println(s);
    }
}
