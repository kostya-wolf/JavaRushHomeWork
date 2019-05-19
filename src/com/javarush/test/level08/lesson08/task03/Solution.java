package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i=0; i<10; i++){
            map.put("Фамилия"+i, "Имя"+i);
        }
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int sum=0;
        for (String first : map.values()){
            if (name.equals(first)) sum++;
        }
        return sum;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        if (map.containsKey(lastName)) return 1;
        else return 0;
    }
}
