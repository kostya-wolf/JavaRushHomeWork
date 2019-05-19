package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(args[0]);
        int[] mas = new int[256];

        while (fis.available() > 0){
            int sym = fis.read();
            mas[sym]++;
        }

        for (int i=0; i<mas.length; i++){
            if (mas[i]>0){
                System.out.println((char)i + " " + mas[i]);
            }
        }

        fis.close();
    }
}
