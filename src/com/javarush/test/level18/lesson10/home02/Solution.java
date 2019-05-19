package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(args[0]);
        int probel = 0, count = fis.available();
        while (fis.available() > 0){
            int sym = fis.read();
            if (sym == 32) probel++;
        }
        BigDecimal sootn = new BigDecimal((double) probel/count*100);
        sootn = sootn.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(sootn);
        fis.close();
    }
}
