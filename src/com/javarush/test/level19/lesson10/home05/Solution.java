package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        String s;
        Pattern p = Pattern.compile("\\d");
        Matcher m;


        while ((s = reader.readLine()) != null){
            String[] mas = s.split(" ");
            for (String str: mas)
            {
                m = p.matcher(str);
                if (m.find()) {
                    writer.write(str);
                    writer.write(' ');
                }
            }
        }

        reader.close();
        writer.close();
    }
}
