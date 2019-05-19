package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn;
        String nowFn="";
        String ppp="";
        ArrayList<Integer> mas = new ArrayList<>();

        while (!(fn = reader.readLine()).equals("end")){
            int index = fn.lastIndexOf(".");
            ppp = fn.substring(index, index+5).toLowerCase();


            nowFn = fn.substring(0, index);
            int chast = Integer.parseInt(fn.substring(index+5));
            if (!mas.contains(chast)) mas.add(chast);
        }


        for (int i=0; i < mas.size()-1; i++)
            for (int j=i+1; j < mas.size(); j++)
                if (mas.get(i)>mas.get(j)){
                    int temp = mas.get(j);
                    mas.set(j, mas.get(i));
                    mas.set(i, temp);
                }

        FileOutputStream fos = new FileOutputStream(nowFn);
        for (int nomer=0; nomer<mas.size(); nomer++)
        {
            FileInputStream fis = new FileInputStream(nowFn+ppp+mas.get(nomer));
            byte[] buf = new byte[fis.available()];
            while (fis.available() > 0){
                int count = fis.read(buf);
                fos.write(buf, 0, count);
            }
            fis.close();
        }
        fos.close();
        reader.close();
    }
}
