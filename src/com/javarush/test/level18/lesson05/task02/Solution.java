package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn = reader.readLine();

        int kolvo=0;

        FileInputStream fileInputStream = new FileInputStream(fn);

        while (fileInputStream.available() > 0){
            int simvol = fileInputStream.read();
            if (simvol == 44) kolvo++;
        }

        System.out.println(kolvo);
        reader.close();
        fileInputStream.close();
    }
}
