package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(args[0]);
        int count = 0;
        while (fis.available() > 0){
            int sym = fis.read();
            if ((sym >=65  && sym <=90) || (sym >=97  && sym <=122)) count++;
        }
        System.out.println(count);
        fis.close();
    }
}
