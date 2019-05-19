package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine())};
        int pol=0, otr=0;
        for (int i=0; i<3; i++){
            if (arr[i]>0) pol++;
            if (arr[i]<0) otr++;
        }
        System.out.println("количество отрицательных чисел: "+otr);
        System.out.println("количество положительных чисел: "+pol);
    }
}
