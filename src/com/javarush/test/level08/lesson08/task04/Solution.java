package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();

        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Шварц", new Date("DECEMBER 18 1956"));
        map.put("Дольф", new Date("AUGUST 25 1970"));
        map.put("Ван Дамм", new Date("march 15 1969"));
        map.put("Джеки Чан", new Date("april 11 1973"));
        map.put("Эмбер", new Date("july 1 1980"));
        map.put("Моника", new Date("november 18 1956"));
        map.put("Ходченкова", new Date("january 25 1970"));
        map.put("Каменских", new Date("may 15 1969"));
        map.put("Lady Gaga", new Date("february 11 1973"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Date> pair = iterator.next();
            String key = pair.getKey();
            int month = pair.getValue().getMonth()+1;
            if (month>=6 && month<=8) iterator.remove();
        }
    }
}
