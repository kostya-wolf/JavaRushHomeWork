package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        StringBuilder chislo = new StringBuilder();

        while (fis.available() > 0){
            int sym = fis.read();
            if (sym != 32){
                chislo.append((char)sym);
            }
            else {
                BigDecimal okrugl = new BigDecimal(chislo.toString());
                if (okrugl.compareTo(BigDecimal.ZERO) < 0)
                    okrugl = okrugl.setScale(0, BigDecimal.ROUND_HALF_DOWN);
                else
                    okrugl = okrugl.setScale(0, BigDecimal.ROUND_HALF_UP);
                fos.write(okrugl.toString().getBytes());
                fos.write(32);
                chislo = new StringBuilder("");
            }
        }

        BigDecimal okrugl = new BigDecimal(chislo.toString());
        if (okrugl.compareTo(BigDecimal.ZERO) < 0)
            okrugl = okrugl.setScale(0, BigDecimal.ROUND_HALF_DOWN);
        else
            okrugl = okrugl.setScale(0, BigDecimal.ROUND_HALF_UP);
        fos.write(okrugl.toString().getBytes());

        fis.close();
        fos.close();
        reader.close();
    }
}
