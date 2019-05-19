package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int sum = 0;
        int strok = a.length;
        int stolbcov = a[0].length;
        for (int i = 0; i < strok; i++)
        {
            for (int j = 0; j < stolbcov; j++)
            {
                if (a[i][j] == 1)
                {
                    sum++;
                    a = clean1(a, i, j);
                }
            }
        }
        return sum;
    }

    private static byte[][] clean1(byte[][] a, int i, int j)
    {
        int x = i;
        int y = j;
        int x2 = 0;
        int y2 = 0;
        while (y<a[i].length && a[i][y] == 1){
            y++;
        }
        y2 = y;
        while (x<a.length && a[x][j] == 1){
            x++;
        }
        x2 = x;
        for (x=i; x<x2; x++){
            for (y=j; y<y2; y++){
                a[x][y]=0;
            }
        }
        return a;
    }
}
