package com.javarush.test.level20.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    static double[][] degree;

    public static int[] getNumbers(int N) {
        int[] result = null;
        degree = getDegree(N);
        ArrayList<Integer> tempArray = new ArrayList<>();

        for (int i=1; (i<10 && i<N); i++){
            tempArray.add(i);
        }

        for (int i = 10; i<N; i++){
            if (isNeed(i))
            {
                int iSum = getSum(i);
                if (iSum>=i && iSum<=N && isArmstrongDigital(iSum)){
                    if (!tempArray.contains(iSum)) tempArray.add(iSum);
                }
            }
        }

        result = new int[tempArray.size()];

        for (int j=0; j<tempArray.size(); j++){
            result[j] = tempArray.get(j);
        }

        Arrays.sort(result);
        return result;
    }


    public static int calcLengthOfInteger(int N)
    {
        if (N > 999999)
        {
            if (N < 10000000) return 7;
            else if (N < 100000000) return 8;
            else if (N < 1000000000) return 9;
            else return 10;
        } else
        {
            if (N > 999)
            {
                if (N < 10000) return 4;
                else if (N < 100000) return 5;
                else return 6;
            } else
            {
                if (N > 99) return 3;
                else if (N > 9) return 2;
                else return 1;
            }
        }
    }


    public static boolean isNeed(int x)
    {
        int len = calcLengthOfInteger(x);
        int tempX = x;
        for (int i = 1; i < len; i++)
        {
            int a1 = tempX % 10;
            tempX = tempX / 10;
            int a0 = tempX % 10;
            if (a0 > a1 && a1 != 0)
            {
                return false;
            }
        }
        return true;
    }


    public static int getSum(int i)
    {
        int M = calcLengthOfInteger(i);
        int tempN = i;
        int sum = 0;

        for (int j = 0; j < M; j++)
        {
            sum += degree[tempN % 10][M];
            tempN /= 10;
        }
        return sum;
    }


    public static boolean isArmstrongDigital(int i)
    {
        int M = calcLengthOfInteger(i);
        int[] mas = new int[M];
        int tempN = i;

        for (int j = 0; j < M; j++)
        {
            mas[j] = tempN % 10;
            tempN = tempN / 10;
        }
        int sum = 0;
        for (int j = 0; j < M; j++)
        {
            sum += degree[mas[j]][M];
        }
        if (sum == i)
        {
            return true;
        }
        return false;
    }


    private static double[][] getDegree(int N)
    {
        int stepen = calcLengthOfInteger(N);
        degree = new double[10][stepen+1];
        for(int i=0; i<=stepen; i++){
            for (int j=0; j<10; j++){
                degree[j][i] = Math.pow(j, i);
            }
        }
        return degree;
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println("Long.MAX_VALUE= "+Long.MAX_VALUE);
        System.out.println("Integer.MAX_VALUE= "+Integer.MAX_VALUE);
        int N = Integer.MAX_VALUE /10;
        System.out.println("N = "+N);
        long startTime = System.currentTimeMillis();
        long startTime2 = System.nanoTime();
        int[] res = getNumbers(N);
        System.out.println(((System.currentTimeMillis() - startTime) / 1000)+" секунд");
        System.out.println((System.nanoTime() - startTime2)+" наносекунд");
        for (int k = 0; k < res.length; k++)
        {
            System.out.print(res[k] + "_");
        }
    }
}
