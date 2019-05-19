package com.javarush.test.level19.lesson10.home03;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String s;

        while ((s = reader.readLine()) != null){
            String[] mas = s.split(" ");
            int year = Integer.valueOf(mas[mas.length-1]);
            int month = Integer.valueOf(mas[mas.length-2]);
            int day = Integer.valueOf(mas[mas.length-3]);
            StringBuilder sbName = new StringBuilder();
            for (int i=0; i<mas.length-3; i++){
                sbName.append(mas[i]).append(' ');
            }
            String name = sbName.toString().trim();

            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.set(year, month-1, day);

            PEOPLE.add(new Person(name, calendar.getTime()));
        }

        reader.close();
    }
}
