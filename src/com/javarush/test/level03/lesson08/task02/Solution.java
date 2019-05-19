package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры отдельно Имя, число1, число2. Вывести надпись:
«Имя» получает «число1» через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//напишите тут ваш код

        String name = reader.readLine();
        String sChislo1 = reader.readLine();
        int chislo1 = Integer.parseInt(sChislo1);
        String sChislo2 = reader.readLine();
        int chislo2 = Integer.parseInt(sChislo2);
        System.out.println(name+" получает "+chislo1+" через "+chislo2+" лет.");
    }
}