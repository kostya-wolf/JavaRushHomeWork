package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String>[] arrayOfStringList = new ArrayList[3];

        for (int i=0; i<arrayOfStringList.length; i++){
           arrayOfStringList[i] = new ArrayList<String>();
        }

        for (int i=0; i<arrayOfStringList.length; i++){
            for (int j=0; j<10; j++){
                arrayOfStringList[i].add("Строка"+j);
            }
        }

        return arrayOfStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}