package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader inStream = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine()), "cp1251"));
        //InputStreamReader inStream = new InputStreamReader(new FileInputStream(reader.readLine()), "Cp1251");

        String line = inStream.readLine();
        while (line != null){
            System.out.println(line);

            line = inStream.readLine();
        }

        inStream.close();
        reader.close();
    }
}
