package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int sum = 0;
        while (!"сумма".equals(s)){
            sum+=Integer.parseInt(s);
            s = scan.nextLine();
        }
        System.out.println(sum);
    }
}
