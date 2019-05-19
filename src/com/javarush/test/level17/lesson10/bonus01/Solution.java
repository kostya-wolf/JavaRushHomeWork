package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        int length = args.length;
        if (length>0){
            String name;
            char sex;
            SimpleDateFormat inFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Date bd;
            int id;
            for (int index = 0; index < args.length; )
            {
                if (args[index].equals("-c")){
                    name = args[index+1];
                    sex = args[index+2].charAt(0);
                    bd = inFormat.parse(args[index+3]);
                    index += 4;
                    if (sex == 'м'){
                        allPeople.add(Person.createMale(name, bd));
                        System.out.println(allPeople.size()-1);
                    }
                    else if (sex == 'ж'){
                        allPeople.add(Person.createFemale(name, bd));
                        System.out.println(allPeople.size()-1);
                    }
                }
                else if (args[index].equals("-u")) {
                    id = Integer.parseInt(args[index+1]);
                    name = args[index+2];
                    sex = args[index+3].charAt(0);
                    bd = inFormat.parse(args[index+4]);
                    index += 5;
                    Person newPerson = allPeople.get(id);
                    newPerson.setName(name);
                    if (sex=='м') newPerson.setSex(Sex.MALE);
                    else if (sex=='ж') newPerson.setSex(Sex.FEMALE);
                    newPerson.setBirthDay(bd);
                }
                else if (args[index].equals("-d")) {
                    id = Integer.parseInt(args[index+1]);
                    index += 2;
                    Person newPerson = allPeople.get(id);
                    newPerson.setName(null);
                    newPerson.setSex(null);
                    newPerson.setBirthDay(null);
                }
                else if (args[index].equals("-i")) {
                    id = Integer.parseInt(args[index+1]);
                    index += 2;
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
            }
        }

    }
}
