package com.javarush.test.level09.lesson11.bonus03;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //напишите тут ваш код
        ArrayList<Integer> strNum = new ArrayList<Integer>();
        ArrayList<Integer> intNum = new ArrayList<Integer>();

        for (int i=0; i<array.length; i++){
            if (isNumber(array[i])) intNum.add(i);
            else strNum.add(i);
        }

        for (int i=0; i<strNum.size()-1; i++)
            for (int j = 0; j < strNum.size()-i-1; j++)
            {
                if (isGreaterThan(array[strNum.get(j)], array[strNum.get(j+1)])){
                    String temp = array[strNum.get(j)];
                    array[strNum.get(j)] = array[strNum.get(j+1)];
                    array[strNum.get(j+1)] = temp;
                }
            }

        for (int i=0; i<intNum.size()-1; i++)
            for (int j = 0; j < intNum.size()-i-1; j++)
            {
                if (Integer.parseInt(array[intNum.get(j)]) < Integer.parseInt(array[intNum.get(j+1)])){
                    String temp = array[intNum.get(j)];
                    array[intNum.get(j)] = array[intNum.get(j+1)];
                    array[intNum.get(j+1)] = temp;
                }
            }

    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
