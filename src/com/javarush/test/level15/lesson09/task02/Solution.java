package com.javarush.test.level15.lesson09.task02;

import sun.net.util.IPAddressUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Статики 2
1. В статическом блоке считайте две переменные с консоли А и В с типом int.
2. Не забыть про IOException, который надо обработать в блоке catch.
3. Закрыть поток ввода методом close().
*/

public class Solution {
    public static int A;
    public static int B;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean notend = true;
        while (notend)
        {
            try
            {
                A = Integer.parseInt(reader.readLine());
                B = Integer.parseInt(reader.readLine());
                notend = false;
                reader.close();
            }
            catch (IOException e)
            {
                System.out.println("IOException: Введите целые числа A  и B заново:");
            }
            catch (NumberFormatException e)
            {
                System.out.println(e+" : Введите целые числа A  и B заново:");
            }
        }
    }

    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }


}
