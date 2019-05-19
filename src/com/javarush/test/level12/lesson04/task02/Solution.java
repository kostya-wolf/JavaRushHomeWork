package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        int i = 100;
        Integer i2 = 200;
        Solution sol = new Solution();
        sol.print(i);
        sol.print(i2);
    }

    //Напишите тут ваши методы
    public void print(int i)
    {
        System.out.println(i);
    }

    public void print(Integer i)
    {
        System.out.println(i);
    }
}
