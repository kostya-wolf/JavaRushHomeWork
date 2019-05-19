package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        HashMap<String, Double> map = new HashMap<String, Double>();
        String s;


        while ( (s = reader.readLine()) != null){
            int index = s.indexOf(' ');
            String name = s.substring(0, index);
            Double salary = Double.valueOf(s.substring(index+1, s.length()));
            if (!map.containsKey(name)){
                map.put(name,salary);
            }
            else {
                map.put(name, map.get(name)+salary);
            }
        }

        List<Map.Entry<String, Double>> list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>()
        {
            @Override
            public int compare(Map.Entry<String, Double> e1, Map.Entry<String, Double> e2)
            {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        Double maxSalary = list.get(0).getValue();

        for (Map.Entry<String, Double> pair: list)
        {
            if (Double.compare(pair.getValue(),maxSalary) == 0) System.out.println(pair.getKey());
        }

        reader.close();
    }
}
