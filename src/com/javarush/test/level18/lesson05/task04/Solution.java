package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1, f2;
        f1 = reader.readLine();
        f2 = reader.readLine();

        FileInputStream fpotok1 = new FileInputStream(f1);
        FileOutputStream fpotok2 = new FileOutputStream(f2);

        ArrayList<Integer> mas = new ArrayList<>();

        while (fpotok1.available() > 0) mas.add(0, fpotok1.read());

        for (int i: mas)
        {
            fpotok2.write(i);
        }
        reader.close();
        fpotok1.close();
        fpotok2.close();
    }
}
