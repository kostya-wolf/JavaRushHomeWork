package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try{
            InputStream inputStream = new FileInputStream(bufferedReader.readLine());
            load(inputStream);
            bufferedReader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void save(OutputStream outputStream) throws Exception {
        Properties props = new Properties();
        props.putAll(properties);
        props.save(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        Properties props = new Properties();
        props.load(inputStream);
        properties.putAll((Map)props);
    }

//    public static void main(String[] args) throws Exception
//    {
//        Solution solution = new Solution();
//        solution.fillInPropertiesMap();
//
//        OutputStream outputStream = new FileOutputStream("2_.properties");
//        solution.save(outputStream);
//
//        InputStream inputStream = new FileInputStream("2_.properties");
//        solution.load(inputStream);
//
//        outputStream = new FileOutputStream("2__.properties");
//        solution.save(outputStream);
//    }
}
