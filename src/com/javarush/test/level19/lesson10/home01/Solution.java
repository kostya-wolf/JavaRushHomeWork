package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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
        ArrayList<String> listNames = new ArrayList<>(map.keySet());
        Collections.sort(listNames);

        for (String name: listNames)
        {
            System.out.println(name+' '+map.get(name));
        }

        reader.close();
    }
}
