package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);

        int razm1 = fis1.available();
        byte[] b1 = new byte[razm1];
        int razm2 = fis2.available();
        byte[] b2 = new byte[razm2];

        fis1.read(b1);
        fis1.close();
        fis2.read(b2);
        fis2.close();


        FileOutputStream fos1 = new FileOutputStream(file1);
        fos1.write(b2);
        fos1.write(b1);

        fos1.close();
        reader.close();
    }
}
