package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1, f2, f3;
        f1 = reader.readLine();
        f2 = reader.readLine();
        f3 = reader.readLine();

        FileInputStream fpotok = new FileInputStream(f1);
        int kolvobytes = fpotok.available();
        int pol1, pol2;

        pol2 = kolvobytes/2;
        pol1 = kolvobytes-pol2;

        FileOutputStream fpotok2 = new FileOutputStream(f2);
        FileOutputStream fpotok3 = new FileOutputStream(f3);

        for (int i=0; i<pol1; i++){
            fpotok2.write(fpotok.read());
        }
        for (int i=0; i<pol2; i++){
            fpotok3.write(fpotok.read());
        }

        reader.close();
        fpotok.close();
        fpotok2.close();
        fpotok3.close();
    }
}
