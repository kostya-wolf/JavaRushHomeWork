package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine())};
        for (int j=1; j<=2; j++){
            for (int i=0; i<2; i++){
                if (arr[i]>arr[i+1]){
                    int w = arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i] = w;
                }
            }
        }
        System.out.println(arr[1]);

    }
}
