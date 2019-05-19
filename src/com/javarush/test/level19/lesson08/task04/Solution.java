package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream fakeConsole = new PrintStream(outputStream);

        System.setOut(fakeConsole);

        testString.printSomething();

        String s = outputStream.toString();
        String[] mas = s.split(" = \\s+");


        for (int i=0; i<mas.length; i++)
        {
            int index = mas[i].indexOf(' ');
            int a = Integer.valueOf(mas[i].substring(0,index));
            int b = Integer.valueOf(mas[i].substring(index+3,mas[i].length()));
            char c = mas[i].charAt(index+1);
            int result=0;
            switch (c){
                case '+': result=a+b;
                    break;
                case '-': result=a-b;
                    break;
                case '*': result=a*b;
                    break;
            }
            mas[i] += " = "+result;
        }

        System.setOut(console);


        for (int i=0; i< mas.length; i++){
            System.out.println(mas[i]);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

