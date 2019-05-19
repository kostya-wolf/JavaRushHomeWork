package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());
        reader.close();

        Pattern p = Pattern.compile("\\d+");
        Matcher m;

        String s;
        reader = new BufferedReader(fileReader);
        while ( (s = reader.readLine()) != null ){
            String[] arr = s.split(" ");
            for (String str: arr){
                m = p.matcher(str);
                if (m.matches()) {
                    fileWriter.write(str);
                    fileWriter.append(' ');
                }
            }
        }

        fileReader.close();
        fileWriter.close();
    }
}
