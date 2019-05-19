package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        int count = 0;

        StringBuilder sb = new StringBuilder();

        while(fileReader.ready()){
            sb.append((char)fileReader.read());
        }
        String[] arr = sb.toString().split("\\p{P}|\\s");
        for (String s: arr)
        {
            if ("world".equals(s)) count++;
        }

        fileReader.close();
        System.out.println(count);
    }
}