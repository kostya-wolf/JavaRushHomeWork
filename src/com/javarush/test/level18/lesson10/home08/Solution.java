package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arr = new ArrayList<>();
        String s;
        while (!(s = reader.readLine()).equals("exit")){
            arr.add(s);
        }

        for (String str: arr)
        {
            ReadThread rt = new ReadThread(str);
            rt.start();
            rt.join();
        }

        reader.close();


        for (Map.Entry<String, Integer> pair: resultMap.entrySet())
        {
            System.out.println(pair.getKey()+" "+pair.getValue());
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run()
        {
            int[] mas = new int[256];
            try {
                FileInputStream fis = new FileInputStream(fileName);

                while (fis.available() > 0){
                    mas[fis.read()]++;
                }

                int max=Integer.MIN_VALUE;
                for (int i=0; i<mas.length; i++){
                    if (mas[i] > max) max = mas[i];
                }

                if (max>0){
                    for (int i=0; i<mas.length; i++){
                        if (mas[i] == max) {
                            resultMap.put(fileName, i);
                            break;
                        }
                    }
                }

                fis.close();
            }
            catch (IOException e){
                System.out.println(e);
            }
        }
    }
}
