package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        int index = url.indexOf('?');
        url = url.substring(index+1);

        ArrayList<String> arr = new ArrayList<String>();

        while (url.length() > 0){
            index = url.indexOf('&');
            if (index == -1) {
                arr.add(url.substring(0));
                url="";
            }
            else {
                arr.add(url.substring(0, index));
                url = url.substring(index+1);
            }
        }


        String params = "";
        ArrayList<String> arrObj = new ArrayList<String>();
        String val = "";

        for (String s: arr)
        {
            index = s.indexOf('=');
            if (index == -1) params += s+" ";
            else {
                String param = s.substring(0, index);
                params += param+" ";
                if (param.equals("obj"))
                {
                    val = s.substring(index + 1);
                    arrObj.add(val);
                }
            }
        }

        params = params.substring(0, params.length()-1);

        System.out.println(params);

        for (String s: arrObj)
        {
            try{
                alert(Double.parseDouble(s));
            }
            catch (NumberFormatException e)
            {
                alert(s);
            }
        }

        //System.out.println(arr);

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
