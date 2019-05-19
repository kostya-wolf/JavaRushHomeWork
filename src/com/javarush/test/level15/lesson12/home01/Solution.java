package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        while (!str.equals("exit")){
            check(str);
            str = reader.readLine();
        }
        reader.close();
    }

    static void check(String str){
        int pointCount = 0;
        boolean stroka = false;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i)=='.') pointCount++;
            if (!((str.charAt(i)>='0' && str.charAt(i)<='9') || str.charAt(i)=='.' || str.charAt(i)=='-')) stroka=true;
        }

        if (stroka || pointCount>1) print(str);
        else if ((!stroka) && pointCount==1) print(Double.parseDouble(str));
        else if ((!stroka) && pointCount<1) {
            int x = Integer.parseInt(str);
            if (x>0 && x<128) print((short)x);
            else if (x>=128) print((Integer) x);
            else print(str);
        }

    }

/*    static void checkAndPrint(Object str){
        boolean dob = false;
        String s = (String)str;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='.') dob = true;
        }
        if (dob) print(Double.parseDouble(s));

        else if (((int)str>0 && (int)str<128)) print((short)str);
        else if ((int)str>=128) print((Integer)str);
        else print(s);*/


    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
