package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Locale;


/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public volatile static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public synchronized static void main(String[] args)  throws ParseException {
        //start here - начни тут
        int length = args.length;
        final ArrayList<String> params = new ArrayList<String>(4);
        params.add("-c");
        params.add("-u");
        params.add("-d");
        params.add("-i");
        if (length>0){
            String name;
            char sex;
            SimpleDateFormat inFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Date bd;
            int id;
            for (int index = 0; index < length; )
            {
                if (args[index].equals("-c")){
                    int minusSym=index+1;
                    while ((minusSym < length) && (!params.contains(args[minusSym])))
                    {
                        minusSym++;
                    }
                    int dlinaparametrov = minusSym - index -1;
                    for (int i=0; i<dlinaparametrov/3 ; i++)
                    {
                        name = args[index + 1];
                        sex = args[index + 2].charAt(0);
                        bd = inFormat.parse(args[index + 3]);
                        index += 3;
                        if (sex == 'м')
                        {
                            allPeople.add(Person.createMale(name, bd));
                            System.out.println(allPeople.size() - 1);
                        } else if (sex == 'ж')
                        {
                            allPeople.add(Person.createFemale(name, bd));
                            System.out.println(allPeople.size() - 1);
                        }
                    }
                    index++;
                }
                else if (args[index].equals("-u")) {
                    int minusSym=index+1;
                    while ((minusSym < length) && (!params.contains(args[minusSym])))
                    {
                        minusSym++;
                    }
                    int dlinaparametrov = minusSym - index -1;
                    for (int i=0; i<dlinaparametrov/4 ; i++)
                    {
                        id = Integer.parseInt(args[index+1]);
                        name = args[index+2];
                        sex = args[index+3].charAt(0);
                        bd = inFormat.parse(args[index+4]);
                        index += 4;
                        Person newPerson = allPeople.get(id);
                        newPerson.setName(name);
                        if (sex=='м') newPerson.setSex(Sex.MALE);
                        else if (sex=='ж') newPerson.setSex(Sex.FEMALE);
                        newPerson.setBirthDay(bd);
                    }
                    index++;
                }
                else if (args[index].equals("-d")) {
                    int minusSym=index+1;
                    while ((minusSym < length) && (!params.contains(args[minusSym])))
                    {
                        minusSym++;
                    }
                    int dlinaparametrov = minusSym - index -1;
                    for (int i=0; i<dlinaparametrov/1 ; i++)
                    {
                        id = Integer.parseInt(args[index+1]);
                        index += 1;
                        Person newPerson = allPeople.get(id);
                        newPerson.setName(null);
                        newPerson.setSex(null);
                        newPerson.setBirthDay(null);
                    }
                    index++;
                }
                else if (args[index].equals("-i")) {
                    int minusSym=index+1;
                    while ((minusSym < length) && (!params.contains(args[minusSym])))
                    {
                        minusSym++;
                    }
                    int dlinaparametrov = minusSym - index -1;
                    for (int i=0; i<dlinaparametrov/1 ; i++)
                    {
                        id = Integer.parseInt(args[index+1]);
                        index += 1;
                        String output;
                        Person newPerson = allPeople.get(id);
                        output = newPerson.getName()+" ";

                        if (newPerson.getSex() == Sex.MALE) output += 'м'+" ";
                        else if (newPerson.getSex() == Sex.FEMALE) output += 'ж'+" ";
                        else output += newPerson.getSex()+" ";


                        Date outDate = newPerson.getBirthDay();
                        if (outDate != null) output += outFormat.format(outDate);
                        else output += outDate;
                        System.out.println(output);
                    }
                    index++;
                }
            }
        }
    }
}
